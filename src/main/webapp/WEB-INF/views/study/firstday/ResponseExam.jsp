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
		
		<h5>데이터만 가져오기 </h5>
			<a href="javascript:send_json()">데이터 가져오기 </a>
			<hr/>
				<!-- Q4-->
			<hr/>
			<h3>미 변화 구간</h3>
		
	</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->


<script>

	var data = {"user" : "ROKMC",
			"no" : "1203"
			"militaryCode": "120321"	
			};
	
	var json = JSON.stringify(data);
	function send_json() {
		$.ajax({
			url:'<c:url value="/ajaxExam.homework"/>',
			method : 'post',
			data : json,
			dataType: "json",
			contentType : "application/json"
		}).done(function(dat) {
		});
	}

</script>

