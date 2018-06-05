<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/mypage.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
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
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-home" aria-hidden="true">
				</span>
				<p class = "content_title-text">마이 페이지</p>
			</div>
			<div class = "row">
				<div class = "col-xs-12 col-md-6">
					<div class = "content_cont-box">
						<span class = "mp_title">내 정보</span>
						<ul class = "info_list">
							<li>
								<b>아이디</b>
								<span class = "info_value">${LoginUser.mem_id}</span>	
							</li>
							<li>
								<b>이름</b>	
								<span class = "info_value">${LoginUser.mem_name}</span>
							</li>
							<li>
								<b>부서</b>	
								<span class = "info_value">${LoginUser.dept_name}</span>
							</li>
							<li>
								<b>직책</b>	
								<span class = "info_value">${LoginUser.mem_posi}</span>
							</li>
						</ul>
						<div class = "form_btn-group my-info">
							<button id = "cmm_btn" type = "button" onclick = "location.href='member.do?command=mypage_infoupdate_form'">내 정보 수정</button>
							<button id = "cmm_btn" type = "button" onclick = "location.href='member.do?command=mypage_pwupdate_form'">비밀번호 변경</button>
						</div>
					</div>
				</div>
				<div class = "col-xs-12 col-md-6">		
					<div class = "content_cont-box">
						<span class = "mp_title">내 배차내역</span>
					</div>
				</div>										
			</div>
		</section>
	</section>
</body>
</html>