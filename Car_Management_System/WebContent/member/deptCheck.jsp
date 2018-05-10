<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/popup.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>부서 이름으로 검색</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;부서 이름으로 검색</p>
</div>
<div class = "popup_body">
	<input type = "text">
	<button>검색</button>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test = "${isExist eq 'no'}">
			<p>'${deptName}'은 등록가능합니다.</p>
		</c:when>
		<c:when test = "${isExist eq 'yes'}">
			<table class = "deptList">
					<tr id = "sub">
						<td>No.</td>
						<td>부서명</td>
					</tr>
					<c:forEach var = "dept" items = "${deptList}">
					<tr>
						<td>${dept.dept_no}</td>
						<td>${dept.dept_name}</td>		
					</tr>
					</c:forEach>
				</table>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>
	</c:choose>	
</div>
</body>
</html>