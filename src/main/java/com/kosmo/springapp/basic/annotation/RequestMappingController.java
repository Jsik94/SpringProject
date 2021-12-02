package com.kosmo.springapp.basic.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//[컨트롤러 클래스]

@Controller
public class RequestMappingController {

	// 컨트롤러 메소드]
	/*
	 * @RequestMapping("/요청URL") -주로 요청을 처리하는 메소드 앞에 단다 -컨텍스트 루트를 제외한 /로 시작하는 요청 URL
	 * -GET 방식 및 포스트 방식 둘다 처리 가능
	 * 
	 */
/*
//	@RequestMapping("/Annotation/RequestMappingBoth.do")
//	@PostMapping("/Annotation/RequestMappingBoth.do")
//	@GetMapping("/Annotation/RequestMappingBoth.do")
	public String requestBoth(HttpServletRequest req) {
		String loginInfo = String.format("[%s요청] - [아이디 : %s 비밀번호 : %s]", req.getMethod(),
				req.getParameter("UserID") == null ? req.getParameter("user") : req.getParameter("UserID"),
				req.getParameter("UserPWD") == null ? req.getParameter("pass") : req.getParameter("UserPWD"));
		req.setAttribute("loginInfo", loginInfo);

		return "chap06_annotation/Annotation";
	}
	
	
	//method =RequestMethod.GET
	//method = {RequestMethod.GET,RequestMethod.POST}
	@RequestMapping(value = "/Annotation/RequestMappingOne.do",method =RequestMethod.GET)
	public String requestOne(HttpServletRequest req) {

		return requestBoth(req);
	}
	*/
	
	//경로중에 중간만 바뀌는 경우 
	/*ex)
	 * 		/members/일번/list.do
	 * 		/members/이번/list.do
	 * 		/members/삼번/list.do
	 */
	/*
	@RequestMapping({"/Annotation/RequestMappingBoth.do","/Annotation/RequestMappingOne.do"})
	public String multi(@RequestParam Map<String,String> map,Model model) {
		String id = map.get("UserID") == null ? map.get("user") : map.get("UserID");
		String pw = map.get("UserPWD") == null ? map.get("pass") : map.get("UserPWD");
		model.addAttribute("loginInfo", String.format("[아이디 : %s 비밀번호 : %s]", id,pw));
		
		return "chap06_annotation/Annotation";
	}
	*/
	
	
	//Mapping에 들어간 변수와 파라미터에 들어간 변수가 일치해야함
	//path에는 확장자가 제거되므로 반드시 확장자는 제거한다.
	@RequestMapping("/Annotation/{path}")
	public String path(@PathVariable String path,@RequestParam Map<String,String> map,Model model) {
		
		String id,pw;
		switch (path) {
		case "RequestMappingBoth":
				id=map.get("UserID");
				pw=map.get("UserPW");
			break;
			
			// "RequestMappingOne"
		default:
			id=map.get("user");
			pw=map.get("pass");
			
			break;
		}
		model.addAttribute("loginInfo", String.format("[아이디 : %s 비밀번호 : %s]", id,pw));
		return "chap06_annotation/Annotation";
	}

}/////
