package com.kosmo.springapp.basic.annotation;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


/*
 * 
 * 	ModelAttribute -> 
 * 
 * 
 * 
 */
/*
@SessionAttributes() 어노테이션]

- 서블릿 API(HttpSession)를 사용하지 않고 세션처리를 하기위한 어노테이션
- 클래스 앞에 붙인다.
- 세션변수(세션 영역에 저장한 속성명)에 값을 저장하려면 
    메소드의 매개변수중 모델계열(Model,Map,ModelMap)
   을 추가하여 add계열("세변변수명",값)으로
   저장하면 그 이름으로
   세션영역에도 저장된다.(리퀘스트 영역뿐만 아니라)

예] @SessionAttributes("세션변수명")
 ※세션변수명이 여러개일때
 @SessionAttributes({"세션변수명1","세션변수명2",...})

-세션영역에서 값 읽어올때

 컨트롤러 메소드(@ModelAttribute(value="세션변수명")  String 세션값방을변수)

-세션해제

컨트롤러 메소드(SessionStatus session){
session.setComplete(); //invalidate()랑 같은 느낌이라고 보면된다. 

}

*/
//types 의 의미  세션영역에 LoginCommand 객체 형태로 저장한다. 즉 key 값이 클래스명이된다
@SessionAttributes(types = {LoginCommand.class})// 모델을쓸때는 위와같이 type 속성으로 사용한다.
//@SessionAttributes({"user","pass"})
@Controller
@RequestMapping("/Annotation")
public class SessionAttributeController {

	/*
	@RequestMapping("SessionAttributeLogin.do")
	public String login(HttpSession session,@RequestParam Map map,Model model) {
		
		if("KIM".equals(map.get("user"))&&"1234".equals(map.get("pass"))) {
			session.setAttribute("user", map.get("user"));
		}else {
			
			model.addAttribute("errorMessage", "아이디와 비번 불일치");
		}
		
		return "chap06_annotation/Annotation";
	}
	
	@RequestMapping("/isLogin.do")
	public String login(HttpSession session,Model model) {
		
		model.addAttribute("isLoginMessage", session.getAttribute("user")==null ? "로그인 하지않았습니다." : "로그인 상태입니다.");
		
		
		return "chap06_annotation/Annotation";
	}
	
	@RequestMapping("/SessionAttributeLogout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "chap06_annotation/Annotation";
	}
	*/
	
	//sessionAttribute 사용
	
	/*
	@RequestMapping("SessionAttributeLogin.do")
	public String login(@RequestParam Map map, Model model) {
		if ("KIM".equals(map.get("user")) && "1234".equals(map.get("pass"))) {
			model.addAllAttributes(map);
		} else {

			model.addAttribute("errorMessage", "아이디와 비번 불일치");
		}

		return "chap06_annotation/Annotation";
		
	}
	
	@RequestMapping("/SessionAttributeLogout.do")
	public String logout(SessionStatus session) {
		
		session.setComplete();
		
		return "chap06_annotation/Annotation";
	}
	
	
	//세션영역에 반드시 값이 있어야한다 아니면 에러남
	@RequestMapping("/isLogin.do")
	public String login(@ModelAttribute("user") String id,Model model) {
		
		model.addAttribute("isLoginMessage","로그인 상태입니다.");
		
		return "chap06_annotation/Annotation";
	}
	
	@ExceptionHandler({Exception.class})
	public String error(Model model) {
		model.addAttribute("isLoginMessage","로그인이 되지 않았습니다.");
		
		return "chap06_annotation/Annotation";
	}
	*/
	
	//command 객체사용시
	//세션status도 같이 넘겨야함
	@RequestMapping("SessionAttributeLogin.do")
	public String login(LoginCommand cmd, Model model,SessionStatus session) {
		
		//type을 사용하는 경우, 맞든 틀리든 일단 세션영역에 저장하게 됨
		//단, 빈 설정파일에 annotation-driven 태그 추가해야됨
		//그러므로, 불일치시 신경을 써야한다. 
		//파라미터에서 해당 클래스 객체를 선언하면 Session에서 해당 클래스 객체를 빼내온것과 같음
		
		
		//자동으로 올라가므로, 틀릴때만지워주면됨
		
		if (!("KIM".equals(cmd.getUser()) && "1234".equals(cmd.getPass()))) {
			model.addAttribute("errorMessage","아이디와 비번 불일치");
			//불일치시 세션영역 초기화한다
			session.setComplete();
		} 

		return "chap06_annotation/Annotation";
		
	}
	
	@RequestMapping("/SessionAttributeLogout.do")
	public String logout(SessionStatus session) {
		
		session.setComplete();
		
		return "chap06_annotation/Annotation";
	}
	
	
	//세션영역에 반드시 값이 있어야한다 아니면 에러남 즉, 잇으면 걍 로그인된거임
	@RequestMapping("/isLogin.do")
	public String login(@ModelAttribute("loginCommand") LoginCommand cmd,Model model,HttpSession session) {
		
		System.out.println("http 세션으로 "+((LoginCommand)session.getAttribute("loginCommand")).getUser());
		model.addAttribute("isLoginMessage","로그인 상태입니다.");
		
		return "chap06_annotation/Annotation";
	}
	
	@ExceptionHandler({Exception.class})
	public String error(Model model) {
		model.addAttribute("isLoginMessage","로그인이 되지 않았습니다.");
		
		return "chap06_annotation/Annotation";
	}
	
	
	
}
