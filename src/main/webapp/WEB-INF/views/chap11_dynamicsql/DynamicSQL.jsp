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
			Mybatis <small>동적 SQL</small>
		</h1>
	</div>
	<fieldset>
		<legend>
			동적 SQL<span style="color: red; font-size: 1.5em">${message}</span>
		</legend>
		<h2>if문</h2>
		<a href="<c:url value="/MyBatis/If1.do?title=자바"/>">WHERE절 일부에 사용
			첫번째</a><br /> <a
			href="<c:url value="/MyBatis/If2.do?title=자바&name=김길동&content=니다"/>">WHERE절
			일부에 사용 두번째</a>
		<h2>choose~when~otherwise</h2>
		<a
			href="<c:url value="/MyBatis/choose.do?title=자바&name=이길동&content=내용"/>">WHERE절
			일부에 사용</a>
		<!-- 아래 3개의 파라미터가 전달 안되도 에러 안남 -->
		<h2>&lt;where&gt;</h2>
		<a
			href="<c:url value="/MyBatis/where.do?title=자바&name=김길동&content=니다"/>">&lt;where&gt;</a>
		<h2>&lt;trim&gt;</h2>
		<!-- 아래 3개의 파라미터가 전달 안되도 에러 안남 -->
		<a
			href="<c:url value="/MyBatis/trim1.do?title=자바&name=김길동&content=니다"/>">&lt;trim&gt;검색문</a><br />
		<a href="<c:url value="/MyBatis/trim2.do?no=12&title=자바용&content=입니당"/>">&lt;trim&gt;수정문</a>
		<h2>&lt;set&gt;</h2>
		<!-- update 하고자 하는 칼럼을 동적으로 포함시키기 위해 사용 -->
		<a href="<c:url value="/MyBatis/set.do?no=12&title=제목"/>">&lt;set&gt;수정문</a>
		<h2>&lt;foreach&gt;</h2>
		<!-- update 하고자 하는 칼럼을 동적으로 포함시키기 위해 사용 -->
		<a href="<c:url value="/MyBatis/foreach.do"/>">&lt;foreach&gt;</a>
		<h3>이메일 삭제</h3>
		<form action="<c:url value="/MyBatis/foreachExam.do"/>" method="post">
			<input type="checkbox" name="email" value="1" />메일1<br /> <input
				type="checkbox" name="email" value="2" />메일2<br /> <input
				type="checkbox" name="email" value="3" />메일3<br /> <input
				type="checkbox" name="email" value="4" />메일4<br /> <input
				type="checkbox" name="email" value="7" />메일7<br /> <input
				type="checkbox" name="email" value="8" />메일8<br /> <input
				type="submit" value="삭제" />
		</form>
	</fieldset>

</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp" />
<!-- 푸터 끝 -->



