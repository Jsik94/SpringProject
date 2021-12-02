package com.kosmo.springapp.basic.handlermapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationController {
	
	//컨트롤러 메소드
	//파라미터가 데이터를 담을 그릇이라고 보면됨 얘로 다같이씀
	@RequestMapping("/HandlerMapping/Annotattion.do")
	public String handleRequest(Model model) {
		//데이터 저장]
		model.addAttribute("message","[AnnotationComtroller]");
		
		//뷰반환
		return "chap01_handlermapping/HandlerMapping";
	}
	
	
}
