<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>헤더</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<script type = "text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/main.js"></script>
</head>
<body>

	<c:if test = "${LoginUser == null}">
	<!-- 세션 없을 시 무조건 로그인 화면으로 강제 이동 -->
		<% 
			response.sendRedirect("main.do?command=loginForm&session=no"); 	
		%>
	</c:if>

<div class = "top-of-top">
	<img src = "img/car.png">
<span>법인차량관리시스템</span>
<span class = "loginfo"> 
	<b>${LoginUser.mem_name} 님 반갑습니다.</b>
	<button type = "button" class = "logout" onclick = "logout();">로그아웃</button>
</span>
</div>
<nav class="navbar navbar-default">
  <div class="container-fluid"  id = "navbar">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="main.do"><img alt="Brand" src="img/plani_logo.png"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">법인 차 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="car.do?command=car_write_form">법인 차 등록</a></li>
            <li><a href="#">정비소 등록</a></li>
            <li><a href="#">정비 내역 등록</a></li>
            <li><a href="#">정비 내역 조회</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">배차 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="place.do?command=place_write_form" role="button">장소 등록</a></li>
            <li><a href="course.do?command=course_write_form" role="button">경로 등록</a></li>
            <li><a href="#">배차 등록</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">운행일지 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">운행 일지 작성</a></li>
            <li><a href="#">운행 일지 조회</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기초 정보 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="member.do?command=dept_write_form">부서 등록</a></li>
            <li><a href="member.do?command=member_write_form">사원 등록</a></li>
          </ul>
        </li>
      </ul>      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div>
</div>
</body>
</html>