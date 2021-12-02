package com.kosmo.springapp.onememo.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.springapp.onememo.service.OneMemoDTO;

//value == id임
@Repository()
public class OneMemoDAO {
	/*
	 * --------------------------------------------
	 * myBatis프레임워크 사용(mybatis-3.버전.jar)
	 * -SqlSessionFactory타입 객체 사용
	   -형변환 불필요(iBatis는 형변환 해야 함)
	 * --------------------------------------------
	 */

	/* 스프링이 myBatis관련해서 지원하는 API 미 사용시
	 * -로그인/목록/입력에 적용해 보자	
	 */
	
	//주입 이전 코드 DIP가 어긋나는 코드 
	/*
	private static SqlSessionFactory sqlMapper;
	static {
		Reader reader;
		try {
			String resource = "onememo/mybatis/configuration.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	/* [스프링에서 지원하는   마이바티스 관련 API(mybatis-spring-2.버전.jar) 미 사용]
	
	[프로그래밍 순서]
	가. SqlSessionFactory타입의 openSession()메소드로 SqlSession타입 얻기
	나. SqlSession타입의 메소드 호출
	.쿼리문이	SELECT
                  	다중레코드 일때:selectList()
                  	단일 레코드일때:selectOne()
	.쿼리문이 	INSERT - insert()
         		DELETE - delete()
         		UPDATE - update()메소드
     		      *****단,I/D/U일때는 반드시 commit()호출
	다.-close()호출

*/
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlMapper;//static 지원안함 
	
	
	
	
	//@Autowired
	@Resource(name="template")
	private SqlSessionTemplate template;
	
	
	public boolean isLogin(Map map) {
		// TODO Auto-generated method stub

		 System.out.println(this.getClass().getName()+" | DAO | isLogin | start ");
		//API 미사용시

		 System.out.println(this.getClass().getName()+" | DAO | isLogin | getSession ");
		//1] SqlSession 얻기
		SqlSession session= sqlMapper.openSession();
		

		 System.out.println(this.getClass().getName()+" | DAO | isLogin | Try to select.... ");
		//2] selectOne 메소드 호출
		int count = session.selectOne("memoIsLogin",map);

		 System.out.println(this.getClass().getName()+" | DAO | isLogin | After SQL ");
		//3]종료
		session.close();
		

		 System.out.println(this.getClass().getName()+" | DAO | isLogin | end ");
		
		return count==1 ? true : false;
	}


	public List<OneMemoDTO> selectList(Map map) {
		System.out.println(this.getClass().getName()+" | DAO | SELECTLIST | START ");
		// TODO Auto-generated method stub
		//세션얻기
		System.out.println(this.getClass().getName()+" | DAO | SELECTLIST | Try to open Session ");
		SqlSession session =  sqlMapper.openSession();
		//실행하기
		System.out.println(this.getClass().getName()+" | DAO | SELECTLIST | Try to select Query ");
		List<OneMemoDTO> lists = session.selectList("memoSelectList", map);
	
		//끄기
		session.close();
		
		return lists;
	}


	public int getTotalRowCount(Map map) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+" | DAO | GETTOTALROWCOUNT | START ");
		// TODO Auto-generated method stub
		//세션얻기
		System.out.println(this.getClass().getName()+" | DAO | GETTOTALROWCOUNT | Try to open Session ");
		SqlSession session =  sqlMapper.openSession();
		//실행하기
		System.out.println(this.getClass().getName()+" | DAO | GETTOTALROWCOUNT | Try to select Query ");
		int counts = session.selectOne("memoTotalRowCount", map);
		//끄기
		session.close();
		System.out.println(this.getClass().getName()+" | DAO | GETTOTALROWCOUNT | Closed session ");		
		
		
		return counts;
	}


	public int insert(Map map) {
		// TODO Auto-generated method stub
		//반드시 커밋할것!!!
		System.out.println(this.getClass().getName()+" | DAO | INSERT | START ");
		// TODO Auto-generated method stub
		//세션얻기
		System.out.println(this.getClass().getName()+" | DAO | INSERT | Try to open Session ");
		SqlSession session =  sqlMapper.openSession();
		//실행하기
		System.out.println(this.getClass().getName()+" | DAO | INSERT | Try to select Query ");
		int affected = session.insert("memoInsert", map);
		
		session.commit();
		System.out.println(this.getClass().getName()+" | DAO | INSERT | CommitComplete ");
		
		//끄기
		session.close();
		System.out.println(this.getClass().getName()+" | DAO | INSERT | Closed session ");		
		
		
		return affected;
	}


	public OneMemoDTO selectOne(Map map) {
		// TODO Auto-generated method stub

		System.out.println(this.getClass().getName()+" | DAO | SELECTONE | START ");
		System.out.println("MAP ? " + map.get("no"));
		
		OneMemoDTO dto = template.selectOne("memoSelectOne", map);
//		template.close();
		System.out.println("컨텐츠 안넘어옹ㅁ ? : " + dto.getContent());
		System.out.println(this.getClass().getName()+" | DAO | SELECTONE | CLOSED ");
		return dto;
	}


	public int update(Map map) {
		// TODO Auto-generated method stub

		System.out.println(this.getClass().getName()+" | DAO | UPDATE | START ");
		
		template.update("memoUpdate",map);

		System.out.println(this.getClass().getName()+" | DAO | UPDATE | END ");
		return 0;
	}


	public void delete(Map map) {
		// TODO Auto-generated method stub
		
		template.delete("memoDeleteByNo",map);
		return;
	}



	
}
