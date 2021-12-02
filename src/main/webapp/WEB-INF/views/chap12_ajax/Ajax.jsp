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
			Jquery Ajax<small>스프링에 Ajax로 비동기 요청하기</small>
		</h1>
	</div>
	<!--
	    ajax로 서버에 요청시에는
	    form태그가 의미 없다(왜냐하면 자바스크립트 객체인 XMLHttpRequest가 서버에 요청하기 때문에).
	        단, 전송할 데이타가 많을시에는 form태그 추가시  유리함.
	    -->
	<form id="frm">
		아이디 <input type="text" name="id" /> 비빌번호 <input type="password"
			name="pwd" />
	</form>
	<ul style="list-style-type: upper-roman;">
		<li><input type="button" id="btnNoAjax" value="회원여부(AJAX미사용)" /></li>
		<!--
			   Spring:반환타입을 void로 하거나
			                   반환타입을 String으로하고 @ResponseBody어노테이션 사용
			-->
		<li><a href="#" id="btnAjaxText">회원여부(AJAX사용-TEXT로 응답받기)</a></li>
		<li><input type="button" id="btnAjaxJson"
			value="회원여부(AJAX사용-JSON으로 응답받기)" /></li>
	</ul>
	<hr />
	<span id="lblDisplay"
		style="color: red; font-size: 2em; font-weight: bold">${isLogin}</span>
	<h3>JSON형식(JSON배열타입)</h3>
	<a href="#">목록가져오기</a><br /> <span id="list"></span>
	<h3>Ajax폴링을 이용한 실시간 업데이트 웹 구현</h3>
	<button id="ajaxPolling">실시간 웹 업데이트</button>
	<span id="polling"></span>
	<!--
		    문]
		    닷넷과정 선택시  커리큘럼에
		    <option value="d01">C#</option>
		    <option value="d02">ASP.NET</option>
		    <option value="d03">WPF4</option>
		   사물인터넷과정 선택시  커리큘럼에
		    <option value="i01">라즈베리 파이</option>
		    <option value="i02">파이썬</option>
		    이	 보이도록 AJAX로구현하여라, 단, 서버에서 데이타를 JSON타입으로
		    받아라.
	     -->
	<h3>AJAX 실습하기</h3>
	과정 <select name="course" id="course">
		<option value="java">자바과정</option>
		<option value="dotnet">닷넷과정</option>
		<option value="iot">사물인터넷과정</option>
	</select> 커리큘럼 <select name="curriculum" id="curriculum">
		<option value="j01">자바</option>
		<option value="j02">JSP</option>
		<option value="j03">스프링</option>
	</select>
	<h3>Jackson라이브러리 실습</h3>
	<h4>자바객체를 JSON으로 변환</h4>
	<h5>form태그로 요청</h5>
	<!-- key=value로 데이타 보내기 -->
	<form id="ajaxForm" action="<c:url value="/Ajax/form.do"/>"
		method="post">
		제목 <input type="text" name="title" /> 이름 <input type="text"
			name="name" /> <br /> 내용<br />
		<textarea rows="10" name="content"></textarea>
		<input type="submit" value="확인" />
	</form>

	<button type="button" id="btnAjaxDataKeyValue">AJAX로
		요청(KEY=VALUE)</button>
	<br />
	<button type="button" id="btnAjaxDataJson">AJAX로 요청(JSON)</button>
	<br />
	<button type="button" id="btnAjaxDataArray">JSON배열로 받기</button>
	<br />
	<h4>JSON을 자바객체로 변환</h4>
	<button type="button" id="btnJsonToJava">Map혹은 DTO으로 변환</button>
	<br /> ${formRequestResult}
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp" />
<!-- 푸터 끝 -->


<script>
	//ajax 미사용
	$('#btnNoAjax').click(function() {
		$('#frm').prop({
			"action" : '<c:url value="/Ajax/NoAjax.do"/>',
			"method" : "post"
		})
		$('#frm').submit();

	});
	/*
	 2]AJAX사용-서버로 부터 응답은 TEXT로 받기
	
	   ※POST방식으로 전송시
	   type:"post" 그리고
	   contentType은 디폴트로 즉 설정 불필요
	   ※GET방식(디폴트)으로 전송시
	   type:"get"로
	   contentType는 전송하는 컨텐타입으로(생략가능)...
	  
	   ※전송할 데이타가 여러개인 경우
	   <form>태그로 감싸주고
	  
	   $("form선택자").serialize()함수 사용
	   이름1=값1&이름2=값2&이름3=값3.....쿼리 스트링 형태로 반환
	 */

	$('#btnAjaxText').click(function() {

		console.log("Data:", $('#frm').serialize())

		$.ajax({
			url : '<c:url value="/Ajax/AjaxText.do"/>',
			type : "post",
			data : $('#frm').serialize(), // 쿼리스트링으로 박아줘도 괜차늠 //"id="+$('input[name=id]').val()+"&"+"pw="+$('input[name=pw]').val();
			//{id:$(':input[name=id]').val(),pw:$(':input[name=pw]').val()},
			dataType : "text",
			success : function(data) {
				//status code 가 200 ( 정상응답시) 일때 작동
				/*
					여기 함수안에 받은 데이터를 표시해줄 코드 구현
					서버로 부터 받은 데이터는 매개변수로 전달됨(data)
				 */

				console.log('서버로 부터 받은 데이터 : ', data)
				console.log('서버로 부터 받은 데이터 타입: ', typeof (data));
				//$('#lblDisplay').html(data=='Y' ? $(':input[name=id]').val()+"님 반갑십니다!" : "회원이 아닙니다.");
				$('#lblDisplay').html(data);
			},
			error : function(e) {
				console.log('비 정상적인 응답시')
				console.log('->', e)

			}
		})
	})

	$('#btnAjaxJson').click(function() {
		$.ajax({

			url : '<c:url value="/Ajax/AjaxJson.do"/>',
			type : "post",
			data : $('#frm').serialize(),
			dataType : 'text',
			success : successCallback, // 함수명만!
			error : function(req, stat, err) {
				console.log('응답 코드 %s', req.status)
				console.log('에러 코드 %s', req.responseText)
				console.log('status 코드 %s', status)
				console.log('err 코드 %s', err)
			}
		})

	})

	function successCallback(data) {
		/*
		data는 서버측에서 전송한 데이타(JSON형식)
		data는 dataType:"json"로 지정했기때문에
		JSON데이타 타입(object)임.
		만약 dataType:"text"로 설정하면 data는 string객체 타입임.
		string타입을 JSON타입으로 변환하려면
		JSON.parse(string객체)
		즉 data.키값 으로 value값을 꺼내온다.]
		{isMember:"메시지"}형태로 서버에서 응답
		data=JSON.parse(data);//dataType:"text"일때
		
		※string JSON.stringify(JSON객체 즉 {}):
		 {}타입의 객체를 string타입으로 변환하는 메소드
		 */

		console.log('서버로 부터 받은 데이터 :%s 객체 :%O 타입 :%s', data, data,
				typeof (data));
		//	console.log(data.isLogin)
		//	$('#lblDisplay').html(data.isLogin)

		//텍스트로받을때
		console.log(JSON.parse(data))
		$('#lblDisplay').html(JSON.parse(data).isLogin)
	}

	$('div.container > a').click(function() {
		console.log('클릭!')
		$.ajax({

			url : '<c:url value="/Ajax/AjaxJsonArray.do"/>',
			type : "post",
			data : "start=1&end=10",
			dataType : 'json',
			success : function(data) {
				successAjax(data, 'list');
			}, // 함수명만!
			error : function(req, stat, err) {
				console.log('응답 코드 %s', req.status)
				console.log('에러 코드 %s', req.responseText)
				console.log('status 코드 %s', status)
				console.log('err 코드 %s', err)
			}
		})
	})

	function successAjax(data, type) {
		console.log('서버로 부터 받은 데이터 : %O, 타입 :%s', data, typeof (data));
		var tableStr = "<table class = 'table table-bordered'>";
		tableStr += "<tr>";
		tableStr += "<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>"
		tableStr += "</tr>";


		$.each(data, function(idx, e) {
			tableStr += "<tr>";
			console.log("idx : %s - elements : %s", idx, data[idx]["id"]);
			var no = e["no"]
			var title = e["title"]
			var name = e["name"]
			var postDate = new Date(e["postDate"]);
			console.log("시간정리 : ", postDate.toDateString());

			tableStr += "<td>" + (idx + 1) + "</td><td>" + title + "</td><td>"
					+ name + "</td><td>" + postDate.toDateString() + "</td>";

			tableStr += "</tr>";
		})


		tableStr += "</table>";
		$('#'+type).html(tableStr); 
	}
	
	
	//5]Ajax폴링 구현하기
	$('#ajaxPolling').one('click',function(){
		window.setInterval(function() {
			$.ajax({

				url : '<c:url value="/Ajax/AjaxJsonArray.do"/>',
				type : "post",
				data : "start=1&end=10",
				dataType : 'json',
				success : function(data) {
					successAjax(data, 'polling');
				}, // 함수명만!
				error : function(req, stat, err) {
					console.log('응답 코드 %s', req.status)
					console.log('에러 코드 %s', req.responseText)
					console.log('status 코드 %s', status)
					console.log('err 코드 %s', err)
				}
			})
		}, 500)
	})
	
	
	
	$('#course').change(function() {
		
		var selector = $('#course').val()
		console.log('현재 과정은 ? : ', selector )
		
		$('#curriculum > option').each(function(){
			console.log($(this).remove());
			$(this).remove();
		})

		$.ajax({
			url : '<c:url value="/Ajax/AjaxExam.do"/>',
			type : "post",
			data : {"course" : selector},
			dataType : 'json',
			success : function(data) {
				var StrResult ="";
				console.log('성공함 ! ', data);
				console.log(data["curriculumsVal"].length)
				
				$.each(data["curriculumsVal"],function(idx,item){
					console.log(item);
					console.log(data["curriculumsName"][idx]);
					StrResult+="<option value = '"+item+"'>"+data["curriculumsName"][idx]+"</option>";					
				})
				
				//그냥 새맵에 key value로 박고 each로 구현하면 ㅈㄴ쉬웠음  
			
				
				$('#curriculum').html(StrResult)
				
			}, // 함수명만!
			error : function(req, stat, err) {
				console.log('응답 코드 %s', req.status)
				console.log('에러 코드 %s', req.responseText)
				console.log('status 코드 %s', status)
				console.log('err 코드 %s', err)
			}
		})
		
		
	})
	
	
	$('#btnAjaxDataKeyValue').click(function(){
		$.ajax({
			url : '<c:url value="/Ajax/AjaxDataKeyValue.do"/>',
			data:$('#ajaxForm').serialize(),
			type:'post',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
			
		})
	})
	
	$('#btnAjaxDataJson').click(function(){
		console.log('아아아아');
		var json ={"title":$('input[name=title]').val(),"content": $('textarea[name=content]').val(),
				"name":$('input[name=name]').val()};
		$.ajax({
			url : '<c:url value="/Ajax/AjaxDataJson.do"/>',
			//JSON 형식을 그냥 보내면 415 에러가 발생함 해당형식을 문자로 바꿔줘야함
			data:JSON.stringify(json),
			type:'post',
			dataType:'application/json; charset=UTF-8',
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
			
			
		})
	});
	
	$('#btnAjaxDataArray').click(function(){
		console.log('여기로 보냄!');
		var json ={"title":$('input[name=title]').val(),"content": $('textarea[name=content]').val(),
				"name":$('input[name=name]').val()};
		$.ajax({
			url : '<c:url value="/Ajax/AjaxDataArray.do"/>',
			//JSON 형식을 그냥 보내면 415 에러가 발생함 해당형식을 문자로 바꿔줘야함
			data:JSON.stringify(json),
			type:'post',
			dataType:'application/json; charset=UTF-8',
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
			
			
		})
	});
	
	$('#btnJsonToJava').click(function(){
		console.log('여기로 보냄여! JsonToJava');

		$.ajax({
			url : '<c:url value="/Ajax/AjaxJsonToJava.do"/>',
			//JSON 형식을 그냥 보내면 415 에러가 발생함 해당형식을 문자로 바꿔줘야함
			type:'post',
			dataType:'json',
			success:function(data){
				console.log(data);
			},
			error : function(e){
				console.log(e);
			}
			
			
		})
	});
	
</script>



