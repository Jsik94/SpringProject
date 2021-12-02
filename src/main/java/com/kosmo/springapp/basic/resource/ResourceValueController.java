package com.kosmo.springapp.basic.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 1. 확장자가 .properties인 리소스 파일 src/main/resources 에 생성
 *    (하위 폴더 생성시에는 new->package로 생성)
 * 2. servlet-context.xml파일에 <context:property-placeholde>등록
 * 3. 클래스에서 사용시에는 @Value어노테이션 사용
 *
 */
//하위폴더 생성시에는 pacakage로 생성
//property 파일을 읽어오려면 servlet-context에 <context:property-placeholder> 를 사용한다
// 사용은 @Value 로 씀

@Controller
public class ResourceValueController {

	@Autowired
	private UserCommand uc;
	
	@Value("${name}")
	private String name;
	@Value("${user}")
	private String user;
	@Value("${pass}")
	private String pass;
	
	@RequestMapping("/resource/Resource.do")
	public String execute(Model model) {
		
		model.addAttribute("resource",uc);
		model.addAttribute("value",String.format("[user:%s,name:%s,pass:%s]",user,name,pass));
		
		return "chap08_resource/Resource";
	}
	
}
