package com.kosmo.springapp.onememo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.kosmo.springapp.comments.service.impl.LineCommentDAO;
import com.kosmo.springapp.onememo.service.ListPagingData;
import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

import utils.PagingUtil;

/*
 * 	이름 미지정시 ID값은 소문자로 시작하는 클래스명이됨
 * 	예] OnememoServiceImpl 클래스인경우
 * 	ID는 onememoServiceImpl 이됨
 * 
 * 
 */

@Service("memoService")
public class OneMemoServiceImpl implements OneMemoService {
	@Resource(name = "oneMemoDAO")
	private OneMemoDAO dao;
	
	@Value("${PAGE_SIZE}")
	private int pageSize;
	@Value("${BLOCK_PAGE}")
	private int block_page;
	
	@Autowired
	private LineCommentDAO lcdao;
	
	@Autowired
	private TransactionTemplate transaction;
	
	
	@Override
	public boolean isLogin(Map map) {
		System.out.println(this.getClass().getName() + " | Service | isLogin | start ");
		
		boolean result = dao.isLogin(map);
		// TODO Auto-generated method stub

		System.out.println(this.getClass().getName() + " | Service | isLogin | END ");
		return result;
	}

	@Override
	public ListPagingData<OneMemoDTO> selectList(Map map, HttpServletRequest req, int nowPage) {
		// TODO Auto-generated method stub
		// 페이징을 위한 로직 시작]
		// 전체 레코드수
		int totalRecordCount = dao.getTotalRowCount(map);
		// 전체 페이지수
		int totalPage = (int) Math.ceil((double) totalRecordCount / pageSize);
		
		// 시작 및 끝 ROWNUM구하기
		int start = (nowPage - 1) * pageSize + 1;
		int end = nowPage * pageSize;
		// 페이징을 위한 로직 끝]

		map.put("start", start);
		map.put("end", end);
		
		//글 전체목록 얻기 
		System.out.println("START : " + start);
		System.out.println("END : " + end);
		List lists = dao.selectList(map);
		String pagingString =PagingUtil.pagingBootStrapStyle(totalRecordCount,pageSize, block_page, nowPage,req.getContextPath()+"/onememo/bbs/List.do?" );
		
		
		return ListPagingData.builder()
				.lists(lists)
				.nowPage(nowPage)
				.pageSize(pageSize)
				.pagingString(pagingString)
				.totalRecordCount(totalRecordCount)
				.build();
	}

	@Override
	public int getTotalRecord(Map map) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public OneMemoDTO selectOne(Map map) {
		// TODO Auto-generated method stub
		
		
		return dao.selectOne(map);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insert(Map map){
//		// TODO Auto-generated method stub
//		Map map1 = new HashMap<>();
//		map1.put("linecomment", "제발 되라222222");
//		map1.put("no",1);
//		map1.put("id","KIM");
//		lcdao.insert(map1);
//		
		
		
		return dao.insert(map);
	
	}

	/*
	 *  [삭제 작업을 트랜잭션 처리하기]
	 *  1. 빈 설정파일에 트랜 잭션 매니저 등록 
	 *  2. <tx:annotation-driven/>
	 *  3. 어노테이션삽입
	 *  4. 반드시 throws 를 던져줘야 잡음
	 *  런타입 예외 발생시 롤백 , 발생안하면 커밋됨
	 *  
	 *   어노테이션
	 *   rollbackFor : 특정 예외 발생시 rollback 처리할 때 사용한다. 
	 *   rollbackFor = NullPointerException.class
	 *   noRollbackFor : 특정 예외 발생시 rollback 처리하지 않을때 사용한다.
	 *   timeout : 설정한 시동안 해당 메소드가 실행이 완료되지 않으면, rollback한다
	 *   			-1(디폴트- 시간제한이 없음) 
	 */
	@Transactional
	@Override
	public int delete(Map map){
		// TODO Auto-generated method stub

		System.out.println(this.getClass().getName()+" | SERVICE | DELETE | start ");


		int affect=0;
		
		try {
			affect= transaction.execute(txCallback->{
				System.out.println(this.getClass().getName()+" | SERVICE | DELETE | Before deleting linecomments ");
				lcdao.deleteByNo(map);		
				System.out.println(this.getClass().getName()+" | SERVICE | DELETE | Before deleting onememo ");
				dao.delete(map);
				
				//반환값사용가능
				return 2;
			});
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		

		System.out.println(this.getClass().getName()+" | SERVICE | DELETE | end ");
		return 0;
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		return dao.update(map);
	}

	@Override
	public String findNameById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
