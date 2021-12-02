package com.kosmo.springapp.springstudy.first;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResponseExamController {
	
	@RequestMapping("/responseExam.homework")
	public String execute() {
		
		return "/WEB-INF/views/study/firstday/InjectionExam.jsp";
	}
	
	@RequestMapping("/ajaxExam.homework")
	public Map sendData(@RequestBody Map map) {
		
		map.put("militaryCode", "7201");
		
		return map;
	}
}
