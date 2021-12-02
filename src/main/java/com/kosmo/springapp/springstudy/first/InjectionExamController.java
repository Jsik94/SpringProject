package com.kosmo.springapp.springstudy.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InjectionExamController {
//	
//	CustomModel custom1;
//	CustomModel custom2;
//	
//	
//	
//	
//
//	@Autowired
//	public void setCustom2(CustomModel custom) {
//		this.custom2 = custom;
//	}
//





	@RequestMapping("/injectionExam.homework")
	public String excute(ModelAndView mav) {
		
//		mav.addObject("data1", custom1);
//		mav.addObject("data2", custom2);
//		
		return "/WEB-INF/views/study/firstday/Injection.jsp";
	}
}
