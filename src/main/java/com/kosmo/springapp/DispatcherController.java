package com.kosmo.springapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * 
 * 어노테이션 미사용시 controller 계열 인터페이스나 클래스를 상속받아 제어해야한다. 
 * 
 */

public class DispatcherController implements Controller {

	
	
	//어노테이션을 안주니까 ModelAndView를 직접 던져줘야함 
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		//View 정보와 모델를 전송함 		modelandview : 뷰위치 , key, value
		return new ModelAndView("/WEB-INF/views/home.jsp","dispatcherservlet","또 다른 웹어플리케이션 영역(컨텍스트)");
	}

	
	
}
