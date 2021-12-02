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
	
	<!-- 
		리소스 파일:.properties로 끝나는 파일로, 스프링에서 자원으로 사용하는 파일임
		주석은 #으로 처리
		리소스파일은 이클립스 classpath 하위에 위치하면된다.
		단, 생성할때 newFile로 해라 안그러면 한글인코딩이 깨진다
	 -->
	 <!--
		  리소스파일:.properties로 끝나는 파일로
		  스프링 프레임웍에서 자원으로 사용하는 파일
		  키=값의 쌍으로 자원(상수)을 등록한다.
		  주석처리는 #으로
		
		  리소스 파일은 이클립스의 classpath인
		  src폴더 밑 어디에든 위치하면 된다.
		  (생성시 new->File로 생성.확장자는 .properties 로)
	  	-->
	
	<fieldset>
		<legend>${value }리소스(.properties)${resource }</legend>
		<h2>디폴트(기본) 핸들러 매핑</h2>
		<a href="<c:url value ="/resource/Resource.do"/>">리소스</a>
	
		<h3>\${value } :  ${value }</h3>
		<h3>\${resource } : ${resource }</h3>
	</fieldset>
	
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

