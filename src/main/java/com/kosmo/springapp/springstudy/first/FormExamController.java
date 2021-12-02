package com.kosmo.springapp.springstudy.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormExamController {

	@RequestMapping("/formExam.homework")
	public String execute() {
		
		
		return "/WEB-INF/views/study/firstday/FormExam.jsp";
	}
}
