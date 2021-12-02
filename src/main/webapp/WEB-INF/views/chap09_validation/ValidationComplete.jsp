<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 태그로 폼을 형성 하는거  -->

<!-- 상단메뉴 시작 -->
<jsp:include page="/WEB-INF/views/template/Top_.jsp" />
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">

	<div class="page-header">
		<h1>
			스프링 <small>Validation</small>
		</h1>
	</div>
	<!-- 
		백엔드쪽에서 유효성검사를 어떻게 하느냐
	
	
	 -->

	<fieldset>
		<legend>
			유효성 검증 완료 페이지
		</legend>
		
		<ul>
			<li>이름 : ${param.name } </li>
			<li>나이 : ${param.years }</li>
			<li>성별 : ${param.gender }</li>
			<li>관심사항 : ${fn:join(requestScope.inters," - ") }</li>
			<li>학력 :${param.grade } </li>
			<li>자기소개 : ${self }</li>
		
		</ul>
		
	</fieldset>

</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp" />
<!-- 푸터 끝 -->



