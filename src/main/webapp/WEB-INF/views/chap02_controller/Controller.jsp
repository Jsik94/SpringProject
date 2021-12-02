<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>컨트롤러</small></h1>
	</div>
	<fieldset>
		<legend>Handler Mapping <span style="color:red;font-size:1.4em">${requestScope.message}
		<c:if test="${not empty param.paramvar }"> 파라미터가 넘어왔습니다. : ${param.paramvar}</c:if></span></legend>
		
		<h2>하나의 컨트롤러로 여러 요청 처리하기 (요청 수만큼 컨트롤러 메소스 생성)</h2>
		<ul>
			<li><a href="<c:url value ="/Controller/OneClass/List.do"/>">목록 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneClass/Edit.do"/>">수정 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneClass/Delete.do"/>">삭제 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneClass/View.do"/>">상세보기 요청</a></li>
		</ul>
		<h2>하나의 컨트롤러로 여러 요청 처리하기 String[] (요청 메소스 하나 생성)</h2>
		<ul>
			<li><a href="<c:url value ="/Controller/OneMethod/List.do?paramvar=1"/>">목록 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethod/Edit.do?paramvar=2"/>">수정 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethod/Delete.do?paramvar=3"/>">삭제 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethod/View.do?paramvar=4"/>">상세보기 요청</a></li>
		</ul>
		<h2>하나의 컨트롤러로 여러 요청 처리하기 String[] ,@PathVariable 사용/~{변수}</h2>
		<ul>
			<li><a href="<c:url value ="/Controller/OneMethodNoParam/List.do"/>">목록 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethodNoParam/Edit.do"/>">수정 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethodNoParam/Delete.do"/>">삭제 요청</a></li>
			<li><a href="<c:url value ="/Controller/OneMethodNoParam/View.do"/>">상세보기 요청</a></li>
		</ul>
	
		
	</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

