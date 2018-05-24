<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>배차 등록 :: 법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<script type = "text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type = "text/javascript" src="js/jquery-ui.js"></script>
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
			<%@ include file = "../place/sideMenu.jsp" %>
		</aside>
		<section id = "content">
			<c:if test = "${message ne null}">
			<div class="alert alert-success alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  ${message}
			</div>
			</c:if>			
			<div class = "content_title-box">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true">
				</span>
				<p class = "content_title-text">배차 등록</p>
			</div>
			<form name = "frm" method = "post" action = "member.do?command=dept_write">
			<div class = "content_cont-box">			
				<table class = "table table-hover">				
					<thead><tr>
						<th>차종</th>
						<th>차량등록번호</th>
						<th>상태</th>
						<th>비고</th>
					</tr></thead>
					<c:forEach var = "car" items = "${CarList}">
					<tr>
						<td>${car.car_model}</td>
						<td>${car.car_reg_no}</td>
						<td>
						<c:choose>
							<c:when test="${car.isUsing eq 1}">
								현재 사용 중
							</c:when>
							<c:when test="${car.canUse eq 1}">
								바로 사용 가능
							</c:when>
							<c:otherwise>
								특이 사항 없음
							</c:otherwise>
						</c:choose>
						</td>
						<td>
						<button type = "button">사용</button>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class = "content_cont-box">
				<div class="container">
			        <div class="row">
			            <div class="col">
			                <div id="schedule" class="jqs-demo mb-3"></div>
			            </div>
			    	</div>
			    </div>
			    <script type = "text/javascript" src="js/jquery.schedule.js"></script>
			    <script>
					$(function () {
						$('#schedule').jqs({
							days: ['월', '화', '수', '목', '금'],
							hour : 12,
						});						
					});
					
					
				</script>
			</div>
			</form>
		</section>
	</section>
</body>
</html>