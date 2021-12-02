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
		<legend>데이터 베이스<span style="color:red;font-size:1.4em">${message}${param.method }</span></legend>
		<h2></h2>
		<ul>
		
			
		
			<li><a href="<c:url value ="/database/JDBConnection.do?method=JDBC"/>">스프링 JDBC API 사용</a></li>
			<li><a href="<c:url value ="/database/JNDIConnection.do?method=JNDI"/>">스프링 JDNI API 사용</a></li>
		
		</ul>
	
		
	</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

