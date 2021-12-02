<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>핸들러 매핑</small></h1>
	</div>
	<fieldset>
		<legend>Handler Mapping <span style="color:red;font-size:1.4em">${message}</span></legend>
		<h2>디폴트(기본) 핸들러 매핑</h2>
		
		<h2>Custom1</h2>
		<ul>
			<li>이름 : ${data1.name }</li>
			<li>나이 : ${data1.age }</li>
			<li>아이디 : ${data1.id }</li>
			<li>주소 : ${data1.addr }</li>
		</ul>
		
		<h2>Custom2</h2>
		<ul>
			<li>이름 : ${data2.name }</li>
			<li>나이 : ${data2.age }</li>
			<li>아이디 : ${data2.id }</li>
			<li>주소 : ${data2.addr }</li>
		</ul>
	
		
	</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

