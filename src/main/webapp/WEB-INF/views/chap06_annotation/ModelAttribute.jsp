<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>핸들러 매핑</small></h1>
	</div>
	<fieldset>
				<legend>@ModelAttribute어노테이션 결과 페이지</legend>
				
					<table class="table table-bordered" bgcolor="gray" cellspacing="1" width="60%">
						<tr bgcolor="white">
							<td>이름</td>
							<td><input type="text" name="name" value="${name }${com.name}"/></td>
						</tr>
						<tr bgcolor="white">
							<td>나이</td>
							<td><input type="text" name="years" value="${years }${com.years}"/></td>
						</tr>
						<tr bgcolor="white">
							<td>성별</td>
							
							<td><input type="radio" name="gender" value="남자" ${gender =='남자' or com.gender =='남자' ? 'checked' : ''}/>남자
								<input type="radio" name="gender" value="여자" ${gender =='여자' or com.gender =='여자' ? 'checked' : ''}/>여자</td>
						</tr>
						<tr bgcolor="white">
							<td>관심사항</td>
							
							<td>
							<input type="checkbox" name="inters" value="정치" ${fn:contains(inters,'정치') or fn:contains(com.inters,'정치') ? 'checked' : '' } />정치
							<input type="checkbox" name="inters" value="경제" ${fn:contains(inters,'경제') or fn:contains(com.inters,'경제') ?'checked' : ''}  />경제
							<input type="checkbox" name="inters" value="스포츠" ${fn:contains(inters,'스포츠') or fn:contains(com.inters,'스포츠')? 'checked' : ''}  />스포츠
							</td>
						</tr>
						
						<tr bgcolor="white">
							<td>학력</td>
							<td><select name="grade">
									<option value="초등학교" ${fn:contains(grade,'초') or fn:contains(com.grade,'초')  ?'selected' : ''}  >초등학교</option>
									<option value="중학교"  ${fn:contains(grade,'중')or fn:contains(com.grade,'중') ?'selected' : ''}  >중학교</option>
									<option value="고등학교"  ${fn:contains(grade,'고') or fn:contains(com.grade,'고')?'selected' : ''} >고등학교</option>
									<option value="대학교"   ${fn:contains(grade,'대')or fn:contains(com.grade,'대')? 'selected' : ''} >대학교</option>
							</select></td>
						</tr>
						<tr bgcolor="white">
							<td>자기소개</td>
							<td><textarea name="self" cols="30" rows="10">${self } ${com.self }</textarea></td>
						</tr>
						
					</table>
				
			</fieldset>
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->

    

