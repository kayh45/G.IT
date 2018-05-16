<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/popup.css" rel="stylesheet">
<link href="../css/common.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>아이디 중복 체크</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;아이디 중복 체크</p>
</div>
<div class = "popup_body">
	<input type = "text">
	<button>중복 체크</button>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test="${isExist eq 1}">
			<p>"${mem_id}"은 사용가능한 아이디입니다.</p>
		</c:when>
		<c:when test="${isExist eq 0}">
			<p>"${mem_id}"은 이미 존재하는 아이디입니다.</p>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>	
	</c:choose>	
</div>
</body>
</html>