package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutowiredController {
	
	
	//@Autowired : 타입 -> id -> Qualifier
	//Autowired는 Setter에도 부착가능하다.
	//필드에 부착
	//@Autowired
	//@Qualifier("fCommand")
	private Command fCommand;
	//@Autowired
	private Command sCommand;
	
	
	//가공이 필요한 경우엔 setter를 통해서
	
	/*
	  ※이때는 Been 설정파일의 id가 속성값이 '파라미터 변수명'과 반드시 같아야한다.
	 	Qualifier와 맞춰도 된다.
	*/
	
	///??????? 이건또 왜되냐 ??
	// Test 조건 : bean에 id값빼고 quali만 뺀상태
	/*
	@Autowired
	@Qualifier("fCommand")
	public void setfCommand(Command b) {
		this.fCommand = b;
	}

	@Autowired
	public void setsCommand(Command sCommand) {
		this.sCommand = sCommand;
	}
	 */
	
	//단 생성자에는 Qualifier 를붙일 수 없다. 
	
	


	@RequestMapping("/Annotation/Autowired.do")
	public String execute(Model model) {
		model.addAttribute("message", String.format("<br/>fCommand : %s <br/>sCommand : %s", fCommand,sCommand));
		
		return "chap06_annotation/Annotation";
	}

	@Autowired
	public AutowiredController(Command fCommand, Command sCommand) {
		super();
		this.fCommand = fCommand;
		this.sCommand = sCommand;
	}
	
}
