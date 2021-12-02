package com.kosmo.springapp.basic.annotation;

public class LoginCommand {

	private String user;
	private String pass;
	
	
	
	@Override
	public String toString() {
		return "LoginCommand [아이디=" + user + ", 비밀번호=" + pass + "]";
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	 
	
	
}
