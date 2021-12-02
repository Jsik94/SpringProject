package com.kosmo.springapp.basic.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InjectionController {

		@Resource(name="personDefualt")
		private Person personDefault;
		@Resource(name="personArgs")
		private Person personArgs;
		
		@RequestMapping("/Injection/Injection.do")
		public String injection(@RequestParam Map map,Model model) {

			personDefault.setName(map.get("name").toString());
			personDefault.setAddr(map.get("addr").toString());
			personDefault.setAge(Integer.parseInt(map.get("age").toString().isEmpty() ? "0":map.get("age").toString() ));
			
			model.addAttribute("personInfo", personArgs+"<hr/>"+personDefault);
//			model.addAllAttributes(map);

			
			
			return "chap05_injection/Injection";
		}
}
