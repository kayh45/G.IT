<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>법인차량관리시스템</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<script type = "text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
	<header>
			<%@ include file = "../header.jsp" %>
			<!-- 헤더 -->
	</header>
	<section id = "main">
		<aside id = "side">
			<%@ include file = "../sideMenu.jsp" %>
		</aside>
		<section id = "content">
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true">
				</span>
				<p class = "content_title-text">사원 등록</p>
			</div>
			<div class = "content_cont-box">
				<p class = "content_cont-text">사원 번호</p>
				<input type = "text" class = "form_textbox" readonly>				
			</div>
			<div class = "content_cont-box">
				<p class = "content_cont-text">
					*사원 기본 정보
				</p>
				<table class="table table-bordered">
					<tr>
						<td class = "form_label">
							<p class = "label">사원 아이디</p>
							<p class = "must">*</p>					
						</td>
						<td colspan = "3">
							<input type = "text" class = "form_textbox">
							<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">비밀번호</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input type = "text" class = "form_textbox">
						</td>
						<td class = "form_label">
							<p class = "label">비밀번호 확인</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input type = "text" class = "form_textbox">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">사원 이름</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input type = "text" class = "form_textbox">
						</td>
						<td class = "form_label">
							<p class = "label">주민등록번호</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input type = "text" class = "form_textbox">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">부서</p>
							<p class = "must">*</p>			
						</td>
						<td>
							<input type = "text" class = "form_textbox">
							<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</td>
						<td class = "form_label">
							<p class = "label">직책</p>		
						</td>
						<td>
							<input type = "text" class = "form_textbox">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">휴대전화</p>
							<p class = "must">*</p>					
						</td>
						<td colspan = "3" class = "form_phone-td">
							<input type = "text" class = "form_textbox" size = "6" maxlength="3">
							<p>-</p>
							<input type = "text" class = "form_textbox" size = "6" maxlength="4">
							<p>-</p>
							<input type = "text" class = "form_textbox" size = "6" maxlength="4">
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">우편번호</p>				
						</td>
						<td colspan = "3">
							<input type = "text" size = "13" class = "form_textbox" readonly>
						</td>
					</tr>	
					<tr>
						<td class = "form_label">
							<p class = "label">주소</p>				
						</td>
						<td colspan = "3">
							<input type = "text" id = "form_address" class = "form_textbox" readonly>
							<span id ="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">상세 주소</p>				
						</td>
						<td colspan = "3">
							<input type = "text" id = "form_address-detail" class = "form_textbox">
						</td>
					</tr>
												
				</table>
			</div>
			<div class = "form_btn-group">
				<button>등록</button>
				<button>수정</button>
				<button>삭제</button>
			</div>
		</section>
	</section>
</body>
</html>