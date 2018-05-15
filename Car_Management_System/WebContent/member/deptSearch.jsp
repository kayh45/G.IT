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
<script type = "text/javascript" src="js/member.js"></script>
<title>부서 조회</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;부서 조회</p>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test = "${isLike eq 'no'}">
		<div class = "popup_box">
				<form name = "frm" method = "post" action = "member.do?command=dept_search&popup=yes">
					부서명 &nbsp;
					<input type = "text" name = "dept_name" value = "${deptName}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "dept_name_ok" value = "1">
		<div class = "popup_box">
			<p class = "search-result_label">'${deptName}'에 대한 조회결과가 없습니다.</p>
		</div>		
			</form>
		</div>			
		</c:when>
		<c:when test = "${isLike eq 'yes'}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "member.do?command=dept_search&popup=yes">
						<input type = "text" name = "dept_name" value = "${deptName}">
						<button type = "submit">조회</button>
				</form>
			</div>
			<div class = "popup_box">
				<p class = "search-result_label">'${deptName}'에 대한 조회 결과입니다.</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">부서 번호</th>
						<th>부서 이름</th>
					</tr>
					<thead>
					<c:forEach var = "dept" items = "${deptList}">
					<tr>
						<td>${dept.dept_no}</td>
						<td><a onclick = "memWriteDeptSelect(${dept.dept_no}, '${dept.dept_name}')">${dept.dept_name}</a></td>		
					</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>
	</c:choose>	
</div>
</body>
</html>