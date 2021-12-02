package com.kosmo.springapp.basic.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

/*
 * 	annotation을 이용하거나 Controller 계열을 인터페이스나 클래스 구현으로 확장해야함
 * 
 * 
 */


public class BeanNameUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//요처을 받고 분석
		
		//2] 비지니스로직 호출 / 결과값 받기
		
		//3] 필요한 값을 리퀘스트 영역에 저장하거나 ModelAndView에 저장
		
		ModelAndView mav = new ModelAndView();
		//4] 데이터 저장
		mav.addObject("message","[BeanNameUrlHandlerMapping]");
		//5] 뷰정보 저장
		//mav.setViewName("/chap01_handlermapping/HandlerMapping");
		//풀경로를써줘야한다!!
		mav.setView(new InternalResourceView("/WEB-INF/views/chap01_handlermapping/HandlerMapping.jsp"));
		//디스패쳐서블릿에 반환
		
		return mav;
	}

}
