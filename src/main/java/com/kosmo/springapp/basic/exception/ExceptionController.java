package com.kosmo.springapp.basic.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController {
	
	/*
	 * 	방법1] 스프링 API 미사용. try~catch절로 예외 처리
	 * 
	 * 
	 */
	/*
	@RequestMapping("/HandlerMapping/BeanNameUrl.do")
	public String exec(@RequestParam String years,Model model) {
		
		try {

			model.addAttribute("message","[당신의 10년후 나이는 :" + (Integer.parseInt(years)+10)+ "]");
		}catch(NumberFormatException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg","나이는 숫자만....");
		}
		
		
		return "chap13_exception/Exception";
	}
	
	*/
	
	
	//@ExceptionHandler의 단점. 해당 컨트롤러에서만 잡기때문에 다른 컨트롤러의 exception을 못잡음 즉, 컨트롤마다 걸어줘야함
	
	/*@RequestMapping("/HandlerMapping/BeanNameUrl.do")
	public String exec(@RequestParam int years,Model model) {
		
		try {

			model.addAttribute("message","[당신의 10년후 나이는 :" + years+10+ "]");
		}catch(NumberFormatException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg","나이는 숫자만....");
		}
		
		
		return "chap13_exception/ExceptionExam";
	}
	*/
	
	@ExceptionHandler(Exception.class)
	public String err(Model model) {
		//이러면 저거 안나옴
		model.addAttribute("errorMsg", "숫자만 입력하세요");
		return "chap13_exception/ExceptionExam";
	}
	
	
	
}
