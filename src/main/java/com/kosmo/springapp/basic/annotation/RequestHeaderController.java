package com.kosmo.springapp.basic.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

	
	@RequestMapping("/Annotation/RequestHeader.do")
	public String excute(@RequestHeader(value="user-agent",required = false,defaultValue = "존재하지 않습니다.") String userAgent,Model model) {
		
		
		model.addAttribute("referer", userAgent);
		
		
		return "chap06_annotation/Annotation";
	}
	
}
