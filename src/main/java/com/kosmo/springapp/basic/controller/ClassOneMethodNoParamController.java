package com.kosmo.springapp.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClassOneMethodNoParamController {
	
	//변수처리하는 법 : {변수명}, 단 파라미터 변수명과 일치시켜야함 
	@RequestMapping("/Controller/OneMethodNoParam/{path}")
	public String noparam(@PathVariable String path,Map map) {
		//pathVariable은 확장자를 떼고 가져온다.
		System.out.println(path);
		
		switch(path) {
		case "List": map.put("message","3]LIST 입니다."); break;
		case "Edit": map.put("message","3]Edit 입니다."); break;
		case "Delete": map.put("message","3]Delete 입니다."); break;
		default :
			map.put("message","3]View 입니다."); break;
		}
		
		return "chap02_controller/Controller";
	}
}
