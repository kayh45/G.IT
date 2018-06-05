<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>운행 일지 작성 :: 법인차량관리시스템</title>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="js/member.js?ver=3"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<c:if test="${message ne null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}
		</div>
	</c:if>
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">운행일지 자동작성</p>
	</div>
	<div class = "content_cont-box">
		
	</div>
	
	<div class="form_btn-group">
		<button id = "ins_btn" type = "submit" onclick = "return deptWriteCheck()">등록</button>
					<button id = "mod_btn" type = "submit" onclick = "return deptWriteCheck()" disabled>수정</button>
					<button id = "del_btn" type = "button" onclick = "deptDelete()" disabled>삭제</button>
	</div>
	</section> </section>
</body>
</html>
<!-- 
TODO 
- 이미 저장되어있는 정보 가져오는 부분 만들기 
- 모바일에 맞게 CSS등 수정
-->