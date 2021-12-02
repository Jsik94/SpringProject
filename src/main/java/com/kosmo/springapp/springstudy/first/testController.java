package com.kosmo.springapp.springstudy.first;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	
	@RequestMapping("/test.homework")
	public String excute(Map<String, String> map,Model model) {
		
		model.addAllAttributes(map);
		return "/WEB-INF/views/study/first/FormExam.jsp";
		
	}
}
