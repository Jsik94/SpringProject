package com.kosmo.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
[일반 자바클래스 형태 즉 POJO(Plain Old Java Object)]

컴파일러에게 "아래 클래스는 사용자 요청을 처리하는 클래스야" 라고 알려주는 역할]
*/
//컨트롤러 클래스
@Controller
public class IndexController {
	// 컨트롤러 메소드]
	@RequestMapping("/handlermapping.do")
	public String handlerMapping() {
		// 뷰정보 반환]
		return "chap01_handlermapping/HandlerMapping";
	}/////////////// handlerMapping

	@RequestMapping("/controller.do")
	public String controller() {
		// 뷰정보 반환]
		return "chap02_controller/Controller";
	}/////////////// handlerMapping

	@RequestMapping("/viewresolver.do")
	public String viewresolver() {

		return "chap03_viewresolver/ViewResolver";
	}

	@RequestMapping("/returntype.do")
	public String returntype() {

		return "chap04_returntype/ReturnType";
	}

	@RequestMapping("/injection.do")
	public String injection() {

		return "chap05_injection/Injection";
	}

	@RequestMapping("/annotation.do")
	public String annotation() {

		return "chap06_annotation/Annotation";
	}

	@RequestMapping("/database.do")
	public String database() {

		return "chap07_database/Database";
	}

	@RequestMapping("/resource.do")
	public String resource() {

		return "chap08_resource/Resource";
	}

	@RequestMapping("/validation.do")
	public String validation() {

		return "chap09_validation/Validation";
	}

	@RequestMapping("/dynamicsql.do")
	public String dynamic() {

		return "chap11_dynamicsql/DynamicSQL";
	}

	@RequestMapping("/ajax.do")
	public String ajax() {

		return "chap12_ajax/Ajax";
	}

	@RequestMapping("/exception1.do")
	public String exce() {
		return "chap13_exception/ExceptionExam";
	}

}
