<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>비밀번호 수정 :: 법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/member.js"></script>
</head>
<body>
	<header>
			<%@ include file = "../header.jsp" %>
			<!-- 헤더 -->
	</header>
	<section id = "main">
		<aside id = "side">
			<%@ include file = "sideMenu.jsp" %>
		</aside>
		<section id = "content">
			<c:if test = "${message ne null}">
			<div class="alert alert-${msgType} alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  ${message}
			</div>
			</c:if>			
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true">
				</span>
				<p class = "content_title-text">비밀번호 수정</p>
			</div>
			<form method = "post" action = "member.do?command=mypage_pwupdate" name = "frm">
			<div class = "content_cont-box">
				<p class = "content_cont-text">사원 아이디</p>
				<input name = "mem_id" type = "text" class = "form_textbox" value = "${LoginUser.mem_id}" readonly>				
			</div>
			<div class = "content_cont-box">			
			<p class = "content_cont-text">
				</p>				
				<table class="table table-bordered" id = "form_table">
					<tr>
						<td class = "form_label">
							<p class = "label">현재 비밀번호</p>
							<p class = "must">*</p>					
						</td>
						<td class = "form_normal-td" colspan = "3">
							<input name = "currPass" type = "password" class = "form_textbox">
							<!-- 위에 있는거 나중에 js파일로 처리 -->
						</td>
					</tr>
					<tr>
						<td class = "form_label">
							<p class = "label">변경할 비밀번호</p>
							<p class = "must">*</p>			
						</td>
						<td class = "form_normal-td"  colspan = "1">
							<input name = "modiPass" type = "password" class = "form_textbox">
						</td>
						<td class = "form_label">
							<p class = "label">비밀번호 확인</p>
							<p class = "must">*</p>			
						</td>
						<td class = "form_normal-td"  colspan = "1">
							<input name = "modiPassOk" type = "password" class = "form_textbox">
						</td>								
					</tr>
				</table>
			</div>
			<div class = "form_btn-group">
				<button id = "ins_btn" type = "submit" onclick = "return passCheck()">수정</button>
			</div>
			</form>
	</section>
</body>
</html>