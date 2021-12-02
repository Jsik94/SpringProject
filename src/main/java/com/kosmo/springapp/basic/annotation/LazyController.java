package com.kosmo.springapp.basic.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * 프로젝트 최초 실행시 스프링이 관리하는 빈은 하나가 생성된다
	즉 해당 빈을 사용할 때가 아닌 프로젝트 최초 실행시에 생성되어
	빈을 사용할때가 아닌 프로젝트 최초 실행시 문제점을파악할 수 있다는
	장점이 있다.
	프로젝트 최초 실행시가 아닌 빈을 사용할때 생성하고자하는 경우(Lazy loading이라한다)
	1. 빈 설정 파일에 빈을 등록하여 생성하는 경우
		lazy-init속성 추가
		default : 스프링의 관리 사이클에 맞게 bean 을 생성한다.(false)
		true : 필요한 시점에 빈 을 생성한다.
		*** 단,lazy-init="true" 로 설정해도 해당 빈이 lazy-init="false" 인 빈에서 참조 된다면
		의존성 관계로 인해 프로젝트 최초 실행시에 생성되게 된다.
	2. 어노테이션으로 빈을 생성하는 경우
	@Lazy 어노테이션 사용.디폴트는 value=true 이다
 * 
 */


@Controller
@Lazy
public class LazyController {

	public LazyController() {
		// TODO Auto-generated constructor stub
		System.out.println("LazyController is constructed ");
	}
	
	
	
	
	@RequestMapping("/Annotation/Lazy.do")
	public String execute (Model model) {
		
		model.addAttribute("message","요청시 LazyController가 생성됩니다.");
		
		return "/chap06_annotation/Annotation";
	}
	
	
}
