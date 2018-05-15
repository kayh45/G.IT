<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<script type = "text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type = "text/javascript" src="js/bootstrap.js"></script>
<title>로그인 :: 법인차량관리시스템</title>
</head>
<body>	
<div class ="login_form">
	<div class = "starter-template">
		<img src = "img/plani_logo.png">
		<h3>법인차량관리시스템</h3>
			<c:if test = "${message ne null}">
			<div class="alert alert-info alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  ${message}
			</div>
			</c:if>	
			<c:if test = "${param.session eq 'no'}">
			<div class="alert alert-warning alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  세션이 만료되었습니다. 다시 로그인해주세요.
			</div>
			</c:if>	
		<p class = "lead">
			<form class="form" name="fm" method=post action = "main.do?command=login">
                   <div class="form-group">
                    <input type="text" class="form-control" id="inputId" name="mem_id" placeholder="아이디">
                    </div>
                    <div class = "form-group">
                    <input type="password" class="form-control" id="inputPw" name="mem_pw" placeholder="비밀번호">
                    </div>
                    
                    <div class = "row">
                	<div class="col-lg-12">
                		<button class="btn btn-primary btn-block btn-lg">로그인</button>	
                	</div>
                	</div>
                	<br>
                	<p>
	                	<a href = "#" data-toggle = "tooltip" 
	                		data-placement = "bottom"
	                		title = "초기 비밀번호 - 생년월일(YYMMDD)">
	                		비밀번호를 잊어버리셨나요?
	                	</a>
	                	<br>
	                	<span>문의 : 042)000-0000 (관리자)</span>
	                	<script>
		                	$(document).ready(function(){
		                	    $('[data-toggle="tooltip"]').tooltip(); 
		                	});
	                	</script>
                	</p>
   	   </form>
	</div>
</div>
</body>
</html>