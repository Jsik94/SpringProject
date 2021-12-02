<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 스타일 적용:방법1때 -->
<!--  
<link  rel="stylesheet" href="<c:url value="/static/styles/common.css"/>"/>
-->
<!-- 스타일 적용:방법2때 -->
<link  rel="stylesheet" href="<c:url value="/resources/styles/common.css"/>"/>

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>프레임워크</small></h1>
	</div>
	<p>현재 시간 : ${serverTime }</p>

	<fieldset>
		<legend>static resource(정적자원:이미지,동영상,.css,.js등) 표시방법</legend>
		<h4>servlet-context.xml파일에 설정된  resources태그 사용:webapp/resources디렉토리 밑에 리소스를 저장해야한다</h4>		
		<!-- 빈 설정파일  servlet-context.xml의 mappingt속성에 지정한 패턴으로 경로 설정-->
		<img src="<c:url value="/static/images/sumnail.png"/>" alt="매핑경로로..."/>
		<h4>servlet-context.xml파일에 설정된  resources태그 사용:webapp디렉토리 아래에 리소스 저장</h4>
		<img src="<c:url value="/images/big/sumnail.png"/>" alt="큰 이미지"/>
		<img src="<c:url value="/images/small/sumnail.png"/>" alt="작은 이미지"/>
		<h4>&lt;default-servlet-handler/&gt;태그 사용-디렉토리 구조대로 링크</h4>
		<img src="<c:url value="/resources/images/sumnail.png"/>" alt="리소스디렉토리 안"/>
	</fieldset>
	<fieldset>
		<legend>스프링 익히기</legend>
		<ul style="list-style: decimal;">
			
			<li><a href="<c:url value="/dispatcherservlet.kosmo"/>">디스패처 서블릿</a>
				<c:if test="${not empty dispatcherservlet }">: ${dispatcherservlet}</c:if>
			</li>
			<li><a href="<c:url value="/handlermapping.do"/>">핸들러 매핑</a></li>
			
			<li><a href="<c:url value="/controller.do"/>">컨트롤러 이해하기</a></li>
			<li><a href="<c:url value="/viewresolver.do"/>">뷰리졸버 매핑</a></li>
			<li><a href="<c:url value="/returntype.do"/>">컨트롤러 메소드의 반환타입들</a></li>
			<li><a href="<c:url value="/injection.do"/>">D.I (Dependency Injection , 의존성 주입)</a></li>
			<li><a href="<c:url value="/annotation.do"/>">Annotation</a></li>
			<li><a href="<c:url value="/database.do"/>">Database</a></li>
			<li><a href="<c:url value="/resource.do"/>">Resource</a></li>
			<li><a href="<c:url value="/validation.do"/>">Validation</a></li>
			<li><a href="<c:url value="/dynamicsql.do"/>">마이바티스 동적 SQL</a></li>
			<li><a href="<c:url value="/ajax.do"/>">Ajax Study</a></li>
			<li><a href="<c:url value="/exception1.do"/>">Exception</a></li>
			
		</ul>
	
	</fieldset>
	
		<fieldset>
		<legend>같은 컨트롤러에서 다른 요청 처리하기</legend>
		<ul style="list-style: decimal;">
			

			
		</ul>
	
	</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

