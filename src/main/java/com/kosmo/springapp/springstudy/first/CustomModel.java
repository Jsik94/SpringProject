package com.kosmo.springapp.springstudy.first;

public class CustomModel {
	private String name;
	private String age;
	private String id;
	private String addr;
	
	@Override
	public String toString() {
		return "CustomModel [name=" + name + ", age=" + age + ", id=" + id + ", addr=" + addr + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
