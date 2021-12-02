package com.kosmo.springapp.basic.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@Lazy
public class SpringBeanConfig {
/*
 * 
 * 	접근 지정자 : public
 * 	반환 타입 : 컨테이너에 등록하고자하는 빈타입
 * 	메소드 명 : 소문자로 시작하는 클래스명으로 주.로. 쓰임
 * 	이름을 바꾸고 싶으면 @Bean(name="속성명") 으로 아이디를 바꿀순 있다 안써주면 메소드명으로 됨
 * 	해당 빈을 필요로하는 곳에서 Autowried나 @Resource로 자동주입해서 사용
 * 
 * 
 */
	//메소드명이 아이디가 됨
	@Bean
	public ConfigBean configBean() {
		return new ConfigBean();
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		System.out.println(this.getClass().getName()+"Object Mapper 빈 주입");
		return new ObjectMapper();
	}
	
}
