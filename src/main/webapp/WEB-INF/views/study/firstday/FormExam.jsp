<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- 상단메뉴 시작 -->
<jsp:include page="/WEB-INF/views/template/Top_.jsp" />
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">

	<div class="page-header">
		<h1>
			스프링 <small>핸들러 매핑</small>
		</h1>
	</div>
	<fieldset>
		<legend>
			Handler Mapping <span style="color: red; font-size: 1.4em">${message}</span>
		</legend>
		<h2>디폴트(기본) 핸들러 매핑</h2>

		<fieldset>
			<form action="/test.homework" method="post">
				<label>아이디를 입력하세요</label> <input type="text" name="id"> <label>비밀번호를
					입력하세요</label> <input type="text" name="pw"> <input type="submit">
			</form>

		</fieldset>
		<fieldset>
			<legend>결과창</legend>
			<label>아이디: ${id }</label>
			<label>비밀번호: ${pw }</label>
		</fieldset>


	</fieldset>

</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp" />
<!-- 푸터 끝 -->



