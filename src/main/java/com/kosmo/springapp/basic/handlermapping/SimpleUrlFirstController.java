package com.kosmo.springapp.basic.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.AbstractController;

public class SimpleUrlFirstController extends AbstractController {

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("이거됨 ??");
		
		//SimpleUrlHandlerMapping
		return new ModelAndView("/chap01_handlermapping/HandlerMapping", "message", "[SimpleUrlFirst.do]");
	}

}
