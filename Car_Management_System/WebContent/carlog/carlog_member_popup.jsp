<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<link href="css/popup.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type = "text/javascript" src="js/carlog.js?ver=1.2"></script>
<title>사원 검색</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;사원 검색</p>
</div>
<div class = "popup_body">
	<c:choose>
		<c:when test = "${isLike eq 'no'}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "carlog.do?command=carlog_member_search&popup=yes">
					사원 이름 &nbsp;
					<input type = "text" name = "mem_name" value = "${memName}">
					<button type = "submit">조회</button>
				</form>
			</div>		
			<div class = "popup_box">
				<p class = "search-result_label">'${memName}'에 대한 조회결과가 없습니다.</p>
			</div>		
		</c:when>
		<c:when test = "${isLike eq 'yes'}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "carlog.do?command=carlog_member_search&popup=yes">
					사원 이름 &nbsp;
					<input type = "text" name = "mem_name" value = "${memName}">
					<button type = "submit">조회</button>
				</form>
			</div>
			<div class = "popup_box">
				<p class = "search-result_label">'${memName}'에 대한 조회 결과입니다.</p>
				<form name = "info">
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>부서</th>
						<th>직책</th>
					</tr>
					</thead>
					<c:forEach var = "mem" items = "${memList}">
					<tr>
						<td>${mem.mem_id}</td>
						<td><a onclick = "carlogMemSelect('${mem.mem_id}','${mem.mem_name}')">${mem.mem_name}</a></td>		
						<td>${mem.dept_name}</td>
						<td>${mem.mem_posi}</td>
					</tr>					
					<input type = "hidden" name = "${mem.mem_id}mem_id" value  = "${mem.mem_id}">
					<input type = "hidden" name = "${mem.mem_id}mem_name" value  = "${mem.mem_name}">
					<input type = "hidden" name = "${mem.mem_id}mem_jumin" value  = "${mem.mem_jumin}">
					<input type = "hidden" name = "${mem.mem_id}mem_hp" value  = "${mem.mem_hp}">
					<input type = "hidden" name = "${mem.mem_id}mem_posi" value  = "${mem.mem_posi}">
					<input type = "hidden" name = "${mem.mem_id}mem_p_no" value  = "${mem.mem_p_no}">
					<input type = "hidden" name = "${mem.mem_id}mem_addr" value  = "${mem.mem_addr}">
					<input type = "hidden" name = "${mem.mem_id}mem_addr_dtl" value  = "${mem.mem_addr_dtl}">
					<input type = "hidden" name = "${mem.mem_id}mem_auth" value  = "${mem.mem_auth}">
					<input type = "hidden" name = "${mem.mem_id}dept_no" value  = "${mem.dept_no}">
					<input type = "hidden" name = "${mem.mem_id}dept_name" value  = "${mem.dept_name}">
					</c:forEach>
				</table>
					</form>
			</div>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>
	</c:choose>	
</div>
</body>
</html>