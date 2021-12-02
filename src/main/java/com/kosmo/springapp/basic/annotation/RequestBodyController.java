package com.kosmo.springapp.basic.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController // 주로 데이터를 보낼때
//@Controller // 주로 페이지를 보낼때

//@Controller
@RestController
public class RequestBodyController {

	//****************************************************************
	//@RequestBody :JSON 형식 데이터를 받을 때 사용, 스프링 부트는 내장되어있음(jackson 라이브러리)
	//스프링 메이븐(레거시)는 내장되어있지 않음!!
	
	
	//JACKSON LIB : 자바 DTO객체를 JSON 형식으로 , JSON을 반대로 DTO 로 파싱해주는 객체
	//단 포스트 방식으로 
	/* [Client]         [Command]
	 *  JSON     <-->    커맨드 객체 
	*/
	
	//Requestbody에서 받아온것을 응답바디로 넘긴다는뜻 -> jackson lib에 의해 json으로 변환되어 브라우저로 전송된다.
	//jackson lib가 없으면 응답헤더에 보낼때 걍깨져버림
	//반대로 RequestBody 가 붙으면 Form에서 못쓰니 주의할것
	
	@RequestMapping("/Annotation/RequestBody.do")
	//@ResponseBody
	public LoginCommand execute(@RequestBody LoginCommand cmd) {
		System.out.println("아이디 : " +cmd.getUser()) ;
		System.out.println("비밀번호 : " +cmd.getPass()) ;
		
		//커맨드객체로 보내도 jackson lib가 변환시켜줌 
		return cmd;
	}
	
	
}
