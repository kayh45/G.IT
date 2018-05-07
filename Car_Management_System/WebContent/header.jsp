<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<div class = "top-of-top">
	<img src = "img/car.png">
법인차량관리시스템
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
      <a class="navbar-brand" href="main.do?command=main"><img alt="Brand" src="img/plani_logo.png"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">사원 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">부서 등록</a></li>
            <li><a href="member.do?command=member_write_form">사원 등록</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="car.do?command=car_write_form"" role="button" >법인 차 등록 </a>
          <ul class="dropdown-menu" role="menu">
<!--             <li><a href="#">법인 차 등록</a></li>
            <li><a href="#">정비소 등록</a></li>
            <li><a href="#">정비 내역 등록</a></li>
            <li><a href="#">정비 내역 조회</a></li> -->
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">배차 관리 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">장소 등록</a></li>
            <li><a href="#">경로 등록</a></li>
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
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div>
</div>
</body>
</html>