package com.kosmo.springapp.basic.dynamicsql;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/MyBatis")
public class DynamicSqlController {

	@Autowired
	DynamicSqlDAO dao ;
	
	
	@RequestMapping("/If1.do")
	public String if1(@RequestParam Map map,Model model) {
		List list = dao.if1(map);
		model.addAttribute("message","총 검색된 글 수 :" +list.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
	@RequestMapping("/If2.do")
	public String if2(@RequestParam Map map,Model model) {
		List list = dao.if2(map);
		model.addAttribute("message","총 검색된 글 수 :" +list.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}
	

	
	@RequestMapping("/choose.do")
	public String choose(@RequestParam Map map,Model model) {
		List list = dao.choose(map);
		model.addAttribute("message","총 검색된 글 수 :" +list.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
	@RequestMapping("/where.do")
	public String where(@RequestParam Map map,Model model) {
		
		List list = dao.where(map);
		model.addAttribute("message","총 검색된 글 수 :" +list.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
	@RequestMapping("/trim1.do")
	public String trim1(@RequestParam Map map,Model model) {
		
		List list = dao.trim1(map);
		model.addAttribute("message","총 검색된 글 수 :" +list.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}	
	
	@RequestMapping("/trim2.do")
	public String trim2(@RequestParam Map map,Model model) {
		System.out.println("map : "+ map.get("no"));
		System.out.println("map : "+ map.get("title"));
		System.out.println("map : "+ map.get("content"));
		int affectecd = dao.trim2(map);
		model.addAttribute("message","총 수정된 글 수 :" +affectecd);
		return"/chap11_dynamicsql/DynamicSQL";
	}	
	
	@RequestMapping("/set.do")
	public String set(@RequestParam Map map,Model model) {
		int affectecd=0;
		if(map.get("title") !=null || map.get("content") !=null) {

			affectecd = dao.set(map);
		}
		
		
		model.addAttribute("message","총 수정된 글 수 :" +affectecd);
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
	
	@RequestMapping("/foreach.do")
	public String foreach(Model model) {
		
		List list = Arrays.asList(2,7,8,12);
		//1. Map 인 경우
		Map map = new HashMap<>();
		map.put("keyno", list);
		System.out.println("list 삽입 확인 : " + list.toString());
		List result = dao.foreach(map);
		
		model.addAttribute("message", "검색된 총 글 수:" + result.size());
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
	@RequestMapping("/foreachExam.do")
	public String foreachExam(@RequestParam int[] email,Model model) {
		
		int affected = dao.foreachExam(email);
		
		return"/chap11_dynamicsql/DynamicSQL";
	}
	
}
