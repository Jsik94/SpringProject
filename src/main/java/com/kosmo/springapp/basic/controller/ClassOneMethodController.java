package com.kosmo.springapp.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClassOneMethodController {

	@RequestMapping({ "/Controller/OneMethod/List.do", "/Controller/OneMethod/Edit.do",
			"/Controller/OneMethod/Delete.do", "/Controller/OneMethod/View.do" })
	public String parameter(@RequestParam int paramvar, Map map) {
		
		switch (paramvar) {
		case 1:
			map.put("message","Reqeust List");
			break;
		case 2:
			map.put("message","Reqeust Edit");
			break;
		case 3:
			map.put("message","Reqeust Delete");
			break;

		default:
			map.put("message","Reqeust View");
			break;
		}
		
		return "chap02_controller/Controller";
	}
}
