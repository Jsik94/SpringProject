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
			한줄 메모게시판 <small>상세보기 페이지 </small>
		</h1>
	</div>
	<!-- 씨큐리티 사용시:사용자 권한 출력 div -->
	<div>
		<div class="col-md-offset-2 col-md-8">
			<ul style="list-style: decimal;">
				<c:forEach items="${authorities }" var="authority">
					<li>${authority }</li>
				</c:forEach>
			</ul>
		</div>
	</div>


	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<table class="table table-bordered table-striped">
				<tr>
					<th class="col-md-2 text-center">번호</th>
					<td>${record.no}</td>
				</tr>
				<tr>
					<th class="text-center">제목</th>
					<td>${record.title}</td>
				</tr>
				<tr>
					<th class="text-center">작성자</th>
					<td>${record.name}</td>
				</tr>
				<tr>
					<th class="text-center">등록일</th>
					<td>${record.postDate}</td>
				</tr>
				<tr>
					<th class="text-center" colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2">${record.content}</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- row -->
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<!-- .center-block 사용시 해당 블락의 크기를 지정하자 -->
			<ul id="pillMenu" class="nav nav-pills center-block"
				style="width: 200px; margin-bottom: 10px">
				<!-- 시큐리티 미사용시 -->
				<c:if test="${sessionScope.id == record.id }">

					<li><a href="<c:url value='/onememo/bbs/Edit.do?no='/>${record.no}"
						class="btn btn-success">수정</a></li>
					<li><a href="javascript:isDelete();" class="btn btn-success">삭제</a></li>
				</c:if>
				<li><a
					href="<c:url value='/onememo/bbs/List.do?nowPage=${param.nowPage}'/>"
					class="btn btn-success">목록</a></li>

			</ul>
		</div>
	</div>

	<!-- row -->
	<div class="row">
		<div class="col-md-12">
			<div class="text-center">
				​
				<!-- 한줄 코멘트 입력 폼-->
				<!-- 마이바티스의 리절트맵 테스트용:<%--${record.comments.size()} --%> -->
				<h2>한줄 댓글 입력 폼</h2>
				<form class="form-inline" id="frm">
					<!-- 씨큐리티 적용:csrf취약점 방어용 -->
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					<input type="hidden" name="no" value="${record.no}" />
					<!-- 수정 및 삭제용 파라미터 -->
					<input type="hidden" name="lno" /> 
					<input placeholder="댓글을 입력하세요" id="title" class="form-control" type="text" size="50" name="linecomment" /> 
					<input class="btn btn-success" id="submit" type="button" value="등록" />
				</form>

				<div class="row">
					<!-- 한줄 코멘트 목록-->
					<!-- ajax로 아래에 코멘트 목록 뿌리기 -->
					<div id="comments" class="col-md-offset-3 col-md-6">
			
			
			<!-- 한번요청으로가져오는방법 -->
				<%--
						<c:if test="${not empty record.comments }">
							<!-- 아래 태그는 마이바티스 resultMap의 collection태그사용시 -->
							<h2>한줄 댓글 목록</h2>
							<table class='table table-bordered'>
								<tr>
									<th class='text-center col-md-2'>작성자</th>
									<th class='text-center'>코멘트</th>
									<th class='text-center col-md-2'>작성일</th>
									<th class='text-center col-md-2'>삭제</th>
								</tr>
								<tbody class="comment-title">

									<c:forEach var="comment" items="${record.comments}">
						
										<tr class="comment${comment.lno}">
											<td>${comment.name}</td>
											<td class="title" title="${comment.lno}">${comment.lineComment }</td>
											<td>${comment.lpostDate }</td>
											<td><c:if test="${comment.id == sessionScope.id }"
													var="res">

													<span href="#" class='commentDelete'>삭제</span>
												</c:if> <c:if test="${!res }">
											
										 삭제불가
										</c:if></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</c:if>
						 --%>
					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->

</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp" />
<!-- 푸터 끝 -->

<script type="text/javascript">
	//두번째 방법 
	//ajax way
		
	//console.log('13번쨰 태그의 삭제를 찾아보겠슝');
	//var target = document.getElementsByClassName("comment24");
	//var jquary = document.querySelectorAll('.comment24');
	//console.log(target);
	//console.log(jquary);
	//console.log(target.length);d
	//var lastnode = target.lastChild;
	//console.log(lastnode);
	
	/*
		Ajax 에서의 ㅛ청방식
		
		GET,POST
		form data를 보낼때는 form태그.serialize() 로 한꺼번에 직렬화 해서 보냄
		data:key1=value&ket2=value....
		contentType:"application/x-wwwform-urlencoded"(디폴트)
		스프링에서는 @RequestParam으로 받는다
	
		POST,PUT,DELETE 요청
		data:JSON.stringify
		contentType:"application/json"
		스프링에서는 @RequestBody로 데이터를 받는다.
	*/
	
	
		var data = {"no" : ${record.no}}
		var trans = JSON.stringify(data);
		console.log("보낸 데이터 ! :" ,trans );
	showComments();
	
	function showComments() {
		//contentType  default : 폼과 똑같음 x-www-form-urlencoded
		//post 방식이라 요청바디에 데이터가 key=value형태로 변환되서 전송
		
		$.ajax({
			url:'<c:url value="/onememo/comments/List.do"/>',
			data : {"no" : ${record.no}},
			dataType:'json',
			type:'post',
			success:showComments_,
			error:function(e){
				console.log(e);
			}
		});
		
	}
	
	//실제 목록을 뿌리는 함수
	function showComments_(data) {
		console.log("서버에서 전송 받은 데이터 : " , data);
		var comments ="<h2>한줄 댓글 목록</h2>";
		comments+="<table class='table table-bordered'>";
		comments+="<tr><th class='text-center col-md-2'>작성자</th><th class='text-center'>코멘트</th><th class='text-center col-md-2'>작성일</th><th class='text-center col-md-2'>삭제</th></tr>";
		comments+="<tbody class=\"comment-title\">"
		if(data.length == 0){
			comments+= "<tr><td colspan='4'> 등록한 댓글이 없습니다! </td></tr>"
		}else{
			
			
		}
		
		//- json 객체 리스트의 인덱스 , element - 해당 json
		$.each(data,function(index,element){
			
			comments+="<tr class='comment"+ element["LNO"]+"'><td>"+element["NAME"]+"</td>";
			comments+="<td style='cursor:pointer' class='title' title='"+element["LNO"]+"'>"+element["LINECOMMENT"]+"</td>";
			comments+="<td>"+element["LPOSTDATE"]+"</td>";
			
			if("${sessionScope.id}" == element['ID']){
				comments+="<td><span href=\"#\" style='cursor:pointer' class='delete' title='"+element["LNO"]+"'>삭제</span></td>";
			}else{
				comments+="<td>삭제불가</td><tr/>";
			}
		});
		comments+="</tbody>"
		comments+="</table>";
		$('#comments').html(comments);
		
	}
	
	
	//코멘트 입력 및 수정처리]
	
	var action,type;
	
	$("#submit").click(function() {
		console.log('클릭 이벤트 발생:',$(this).val());
		console.log('파라미터 땡겨오기',$('#frm').serialize());
		
		
		if($(this).val()=='등록'){
			
			action='<c:url value="/onememo/comments/Write.do"/>';
			type ="post";
		}
		else{

			//put 방식
			action='<c:url value="/onememo/comments/Edit.do"/>';
			type ="post";
		}
		
		console.log("한줄 댓글 키값(lno) :", $('input[name=lno]').val());
		//ajax 요청] JSON 형식 아님!!!
		
		$.ajax({
			url:action,
			data: $('#frm').serialize(),
			dataType:"text",
			type:type,
			success:function(data){
				console.log("방식 :",type);
				console.log("서버로 부터 받은 데이터 : " , data);
				console.log("현재 버튼 이름 : " ,$('#submit').val() )
				//showComments() // 이렇게 해도 되긴함 하지만 요청이 더생김그래서 서버에 요청을 안보내는형식으로 보여줄것임
				
				if($('#submit').val()=='등록'){
					var lno = data.split(":")[0];
					var name = data.split(":")[1];
					
					var date = new Date();
					var lpostdate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
					
					var newComment = "<tr class=comment"+lno+"><td>"+name+"</td><td  style='cursor:pointer' class='title' title="+lno+">"+$('#title').val()+"</td><td>"+lpostdate+"</td><td><span href=\"#\" style='cursor:pointer' class='delete' title='"+lno+"'>삭제</span></td></tr>"
					$('.comment-title').prepend(newComment);
					
				}else{
					//lno를 보내줘야겟네 ?
					//수정 포지션 브라우저 로직 
					console.log('수정로직 먹음 해당 위치 : ' , $('input[name=lno]').val());
					$('.title[title='+$('input[name=lno]').val()+']').html($("#title").val());
					//$('.title[title='+data+']').html($("#title").val());
					
					//등록으로 바꿔야함
					$('#submit').val('등록');
					
				}
				
				$('#title').val("");
				$("#title").focus();
				
				
			
				
			},
			error:function(){
				console.log('오류발생!');
			}
			
		}); // ajax
		
	});//sumib
	
	// 코멘트 제목 클릭시 수정처리하기 (UI변경)
	//코멘트 수정 이벤트
	// 반드시 click 이벤트 걸 때  $(document).on ->랜더링되었을때를 의미 
	$(document).on('click','.title',function(){
		console.log('클릭:해봐요오 val : ', $(this).html());
		$('#title').val($(this).html());
		$('#submit').val("수정");
		//name lno를 땡겨오는 코드 
		$('input[name=lno]').val($(this).attr('title'));
		console.log("lno 잘 나오니 ? :",$('input[name=lno]').val() )
	});
	
	$(document).on('click','.delete',function(){
		console.log('클릭:해봐요오 val : ', $(this).html());
		var lno = $(this).attr('title'.split(":")[0]);
		console.log('deleted 클릭이벤트 발생');
		
		if(confirm('정말 삭제하시겠습니까 ? ')){
			$.ajax({
				url : '<c:url value="/onememo/comments/Delete.do"/>',
				type: "post",
				data: "lno="+lno,
				dataType : "text"
				
			}).done(function(data) {
				console.log('데이터를 성공적으로 받았습니다. data : ',data);
				console.log('삭제를 진행합니다.')

				$('.comment'+lno).remove();
			}).fail(function(e){
				console.log('에러발생 ' , e);
			});
		}
		
	});
	
	
	function isDelete() {
		if(confirm("정말로 삭제하시겠습니까 ? ")){
			location.replace('<c:url value="/onememo/bbs/Delete.do?no=${record.no}"/>')
		}
	}
	

	
</script>

