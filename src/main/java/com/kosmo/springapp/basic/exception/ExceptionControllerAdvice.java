package com.kosmo.springapp.basic.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 	모든 컨트롤러의 Exception을 잡을 수 잇음
 * 	단, 그렇기 때문에 
 * 
 */


@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
public String err(Model model,Exception e) {
		e.printStackTrace();
		model.addAttribute("errors", "으갸갸갸갸갸");
		return "chap13_exception/Error";
	}
	
}
