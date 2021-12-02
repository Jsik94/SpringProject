package com.kosmo.springapp.basic.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {
	// 현재 클래스가 Person객체 필요
	// setter 또한 주입해서 받아보자 
/*	
 	//way 1
	@Resource(name ="personType")
	private Person personType;
	@Resource(name ="personIndex")
	private Person personProperty;
*/
	
	/*
	 *	공부할때 Qualifier 테스트시 
	 *		ConstructorController 생성자 막아줄것 id값으로 매핑하는 인자생성자가있어서그럼
	 *		com.kosmo.springapp.basic.injection.Person 빈들 id값 다 지워줄 것
	 *			- id="personType"
	 *			- id="personIndex"
	 * 		@Resource(name ="personType")생략
	 */
	
	//way 2 디폴트를 바꿔쓰기 좋음
	private Person personType;
	private Person personProperty;
	

	@Resource(name ="personType")
//	@Autowired
//	@Qualifier("person1")
	public void setPersonType(Person personType) {
		personType.setAge(33);
		this.personType = personType;
		this.personType.setName("이름바꿈!");
	}


	@Resource(name ="personIndex")
//	@Autowired
//	@Qualifier("person2")
	public void setPersonProperty(Person personProperty) {
		this.personProperty = personProperty;
	}


	public SetterController() {
		// TODO Auto-generated constructor stub
		System.out.println("생성자 - PersonType : " + personType);
		System.out.println("생성자 - PersonProperty : " + personProperty);
	
	}
	
	
	@RequestMapping("/Injection/Setter.do")
	public String execute(Map map) {
		System.out.println("요청 메소드 - PersonType : " + personType);
		System.out.println("요청 메소드 - PersonProperty : " + personProperty);
		
		map.put("personInfo", this.personType +"<hr/>" + this.personProperty);
		
		return "chap05_injection/Injection";
	}
	
	
	
	
	
	
}
