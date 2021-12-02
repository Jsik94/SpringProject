package com.kosmo.springapp.basic.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {

	//@Resource
	//필드와 세터에만 붙일 수 있다. 
	//얘는 required 속성이 없음 따라서 무조건 빈속성이 있어야함
	//아무것도 지정안하면 type기반으로 찾게된다.
	
	//@Resource(name = "fCommand")
	private Command fCmd;
	//@Resource(name = "sCommand")
	private Command sCmd;
	
	
	
	
	@Resource(name = "fCommand")
	public void setfCmd(Command fCmd) {
		this.fCmd = fCmd;
	}
	@Resource(name = "sCommand")
	public void setsCmd(Command sCmd) {
		sCmd.setYears("52");
		this.sCmd = sCmd;
	}





	@RequestMapping("/Annotation/Resource.do")
	public String execute(Model model) {
		model.addAttribute("message", String.format("<br/>fCommand : %s <br/>sCommand : %s", fCmd, sCmd));

		return "chap06_annotation/Annotation";
	}
	
	
	
	
}
