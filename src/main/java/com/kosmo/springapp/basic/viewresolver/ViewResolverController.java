package com.kosmo.springapp.basic.viewresolver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ViewResolverController {


/*
	@RequestMapping("/ViewResolver/ViewResolver.do")
	public String execute(Model model) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd MMM EEE a HH:mm:ss");
		model.addAttribute("message",df.format(new Date()));
		
		//1] jsp페이지로 forward(디폴트가 forward임)
//		return "viewresolver03/ViewResolver";
		//2. do로 forward
//		return "/ViewResolver/NotJSP.do"; // 이렇게 반환하면안되는이유
		//return을 하면 디스패쳐에서 prefix 와 suffix를 ㅈㄴ신나게 붙여서 쏴주기때문에 안됨
		//※InternalResourceViewResolver를 통한 접두어/접미어의 영향을 받지않으러면
		//String 반환의 경우 forward: or redirect:를 붙여주면됨 
		//단, redirect:는 ModelAndView 객체로 반환해야함
		
		//접두어의 영향을 받지 않게 사용 - 다른 컨트롤러로 이동시 활용
		//forward case]
		//forward: 디폴트 방식
		//리턴하는 주소앞에 "forward:"를 붙이면 resolver의 bean property 속성을 무시함(즉, 현상태에선 prefix,suffix가안붙음)
//		return "forward:/ViewResolver/NotJSP.do?name=Hello Spring!!";
		
		//redirect case]
		//※리다이렉트시 모델 객체에 저장된 데이터는 쿼리스트링으로 전달이됨
		
		//1. jsp로 redirect 하는 경우
		//redirect특성상 클라이언트에서 재요청을 시도하지만 WEB-INF로는 Client side에서 못들어감
//		return "redirect:/WEB-INF/views/viewresolver03/ViewResolver";//해당경우는 불가능함 client에서 Web파일을 접근 못하기때문
		// redirectview 객체로 보내야됨
//		return "redirect:/ViewResolver/NotJSP.do?name=Hello Spring!!";
		

	}
*/

	//Redirect
	@RequestMapping("/ViewResolver/ViewResolver.do")
	public ModelAndView execute() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd MMM EEE a HH:mm:ss");

		//true는 contextPath 붙임 default false;
		//.jsp로 리다이렉트하기 - 불가능함 >> WEB-INF로 접근해야하므로
//		RedirectView redirectView =new RedirectView("/WEB-INF/views/viewresolver03/ViewResolver.jsp", true);
		
		//.do로 리다이렉트
		RedirectView redirectView =new RedirectView("/ViewResolver/NotJSP.do?name=Hello Spring!!",true);
		ModelAndView mav = new ModelAndView();
		mav.setView(redirectView);
		mav.addObject("message", df.format(new Date()));
		
		return mav;
	}
	
	@RequestMapping("/ViewResolver/NotJSP.do")
	public String notjsp(@RequestParam String name,@RequestParam String message) {
		System.out.println(this.getClass().getName()+ new String().format("| notjsp | ParamCheck - name : %s ,message : %s",name,message));
		return "chap03_viewresolver/ViewResolver";
	}
	
	
	
	
}
