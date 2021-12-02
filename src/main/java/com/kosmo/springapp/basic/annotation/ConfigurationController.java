package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * 스프링 빈 생성 방법
		1. @Controller(요청을 처리할떄),@Service(비지니스로직을 처리하는 클래스일때),@Repository(DAO 계열 빈),
		@Component(위 3개가아닐때 자동생성을 해야한다면),@Configuration가 붙은 클래스를 스캔 해서 스프링 컨테이너에 빈으로 등록
		빈의 아이디는 카멜 케이스  형태의 클래스명이 된다
		빈의 아이디를 직접 지정시에는 name속성 추가.단,@Component(value="빈 아이디")는 value속성 사용
		2.@Congiguration어노테이션과 @Bean어노테이션  사용해서 자바코드로 내가 생성해서 빈 등록
		@Configuration
		public  class  SpringBeanConfig{
		        @Bean
		         public  OneMemoService  oneMemoService(){
		             return  new  OneMemoService();
		          }
		         public  OneMemoRepository  oneMemoRepository(){
		               return  new  OneMemoRepository();
		         }
		}
		이때 빈의 아이디는 카멜케이스  형태의 메소드명이된다
		혹은 @Bean(name="빈이름")으로 지정한다
		단.@Controller는  요청처리를 하기위한 빈이니까
		@Configuration으로 등록하는 빈에서 제외한다
		
		이제 서비스와 리포지토리에서는 @Service  ,@Repository는 붙이지 않는다
		※생성된 빈은 @Autowired나 @Resource로 주입해서 사용
		
		
		방법3] bean을 직접 등록한다.
 * 
 * 
 * 
 * 
 */

//객체 아이디 값을 바꾸고 싶으면 controller속성에 value 값을 주면 된다.
@Controller()
@Lazy
public class ConfigurationController {

	//ConfigBean을 주입 받을 거임
	@Autowired
	private ConfigBean configBean;
	
	
	
	
	@RequestMapping("/Annotation/Configuration.do")
	public String execute(Model model) {
		System.out.println( configBean.toString());
		model.addAttribute("message", configBean.toString());

		return "/chap06_annotation/Annotation";
	}
}
