package com.kosmo.springapp.onememo.web;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo.springapp.onememo.service.ListPagingData;
import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;
import com.kosmo.springapp.onememo.service.impl.OneMemoServiceImpl;

// 스프링시큐리티 있으면 알아서된다는 내용 로그인판단만하면된다네용

@Controller
@SessionAttributes("id") // 스프링 시큐리티 사용시엔 주석 해야됨
@RequestMapping("/onememo/bbs/")
public class OneMemoController {
	
	
	//서비스 주입
	
	//@Resource(name = "memoService")
	@Autowired
	private OneMemoService memoService; 
	
	
	
	//id가없을때는 에러를 활용해서 넘김 
	//Tip 일단 작성하고 필요한것들을 추가하는게 빠르다.
	@RequestMapping("List.do")
	public String list(@ModelAttribute("id") String id,
			@RequestParam Map map,
			@RequestParam(required = false,defaultValue = "1")int nowPage,
			HttpServletRequest req,
			Model model) {
		
		List<Map.Entry> entryList = new LinkedList<>(map.entrySet());
		
		for(Map.Entry entry : entryList) {
			System.out.println("Key : " + entry.getKey() +" , Value : " + entry.getValue());
		}
		
		ListPagingData<OneMemoDTO> listPagingDate= memoService.selectList(map, req, nowPage);
		
		//데이터 결과 저장
		model.addAttribute("listPagingData", listPagingDate);
		
		//뷰정보반환]
		return "chap10_onememo/bbs/List";
	}
	
	@RequestMapping(value = "Write.do", method = RequestMethod.GET)
	public String write(@ModelAttribute("id") String id,
			@RequestParam Map map,
			Model model) {
		
		
		
		return "chap10_onememo/bbs/Write";
	}
	
	@RequestMapping(value = "Write.do", method = RequestMethod.POST)
	public String writeOK(@ModelAttribute("id") String id,
			@RequestParam Map map) {
		
		map.put("id", id);
		
		try {
			memoService.insert(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//컨트롤러토스
		return "forward:/onememo/bbs/List.do";
	}
	
	
	//상세보기
	@RequestMapping("View.do")
	public String view(@ModelAttribute("id") String id,
			@RequestParam Map map,
			Model model) {
		
		System.out.println(this.getClass().getName()+" | CONTROLLER | view | start ");
		OneMemoDTO dto = memoService.selectOne(map);
		
		dto.setContent(dto.getContent().replace("\r\n", "<br/>"));
		model.addAttribute("record", dto);

		

		System.out.println(this.getClass().getName()+" | CONTROLLER | view | start ");
		return "chap10_onememo/bbs/View";
	}
	
	
	@RequestMapping("Edit.do")
	public String edit(@ModelAttribute("id") String id, @RequestParam Map map, Model model) {
		System.out.println(this.getClass().getName()+" | CONTROLLER | edit | start ");
		
		OneMemoDTO record = memoService.selectOne(map);
		model.addAttribute("record", record);
		System.out.println(this.getClass().getName()+" | CONTROLLER | edit | end ");
		return "chap10_onememo/bbs/Edit";
	}
	
	
	@RequestMapping("EditOK.do")
	public String editOK(@ModelAttribute("id") String id, @RequestParam Map map, Model model) {
		System.out.println(this.getClass().getName()+" | CONTROLLER | editok | start ");
		memoService.update(map);
		System.out.println(this.getClass().getName()+" | CONTROLLER | editok | end ");
		return "forward:/onememo/bbs/View.do";
	}
	
	@RequestMapping("Delete.do")
	public String delete(@ModelAttribute("id") String id, @RequestParam Map map, Model model) {
		System.out.println(this.getClass().getName()+" | CONTROLLER | DELETE | start ");
		System.out.println("NO ? " +map.get("no"));
		memoService.delete(map);
		
		
		System.out.println(this.getClass().getName()+" | CONTROLLER | DELETE | end ");
		return "forward:/onememo/bbs/List.do";
		
	}
	
	
	
	
	
//	@ExceptionHandler({Exception.class})
//	public String error(Model model) {
//		model.addAttribute("NotMember", "로그인 후 이용하세요");
//		
//		return "chap10_onememo/member/Login";
//	}
//	
}
