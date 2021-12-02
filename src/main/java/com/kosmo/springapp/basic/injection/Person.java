package com.kosmo.springapp.basic.injection;


public class Person {

	private String name;
	private String addr;
	private int age ;
	
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("기본 생성자 ON");
	}
	
	

	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
		System.out.println("인자 생성자 ON");
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String().format("[이름 : %s 주소 : %s 나이 : %s]", name,addr,age);
	}
	
	
	
	
	
}
