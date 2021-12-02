package com.kosmo.springapp.basic.injection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConstructorController {

	
	/*
	 * 	의존성을 낮추기 위해 객체를 직접 설정하지 않고 설정파일을 통해 생성자로 주입
	 * 
	 * 	1] 멤버변수 선언
	 * 	2] 인자 생성자를 정의
	 *  3] 
	 *  
	 */
	
//	@Autowired
//	@Qualifier("person1")
	private Person personType;
	private Person personIndex;
	
	//wiring 의 개념 설정파일에 등록된 bean을 통해서 주입하는 방법을 말함
	//아래의 생성자에는 @Autowried 가 생략되어있음
	//@Autowired //생략가능
	
	//id값과 파라미터 값을 일치시키자
	public ConstructorController(Person personType, Person personIndex) {
		super();
		this.personType = personType;
		this.personIndex = personIndex;
		System.out.println("ConstructController의 인자 생성자");
	}


	@RequestMapping("/Injection/Constructor.do")
	public String execute(Map map) {
		
		map.put("personInfo", this.personType +"<hr/>" + this.personIndex);
		
		
		
		return "chap05_injection/Injection";
	}
}
