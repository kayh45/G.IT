<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*, java.text.*"  %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
String a = new String(request.getParameter("car_reg_no").getBytes("UTF-8"));

java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMM");
String today = formatter.format(new java.util.Date());
response.setHeader("Content-Disposition","attachment;filename="+a+"_"+today+".xls");
response.setHeader("Content-Description", "JSP Generated Data");
%>
<style>
table{
border="1"
}
</style>
</head>
<body>

	<table>					
					<thead>
					<tr>
						<th class = "number_th">일자</th>
						<th>부서</th>
						<th>직책</th>
						<th>성명</th>
						<th>사용목적</th>
						<th>출발지</th>
						<th>도착지</th>
						<th>법인카드 사용금액</th>
						<th>주행전누적거리(km)</th>
						<th>주행거리(km)</th>
						<th>주행후누적거리(km)</th>
						<th>비고</th>
					</tr>
					<thead>
					<c:forEach var = "carlog" items = "${carlogAllList}">
					
				<tr>		               
						<td>${carlog.driv_s_date}</td>
						<td>${carlog.dept_name}</td>
						<td>${carlog.mem_posi}</td>
						<td>${carlog.mem_name}</td>
						<td>${carlog.driv_purpo}</td>
						<td>${carlog.s_place_name}</td>
						<td>${carlog.e_place_name}</td>
						<td>${carlog.total_fee}</td>
						<td>${carlog.befo_dist}</td>
						<td>${carlog.distance}</td>
						<td>${carlog.after_dist}</td>
						<td>${carlog.etc_text}</td>
						
						
					</tr>					
				 <%--    <input type = "hidden" name = "${repa.repa_no}repa_no" value  = "${repa.repa_no}">
					<input type = "hidden" name = "${repa.repa_no}car_reg_no" value  = "${repa.car_reg_no}">
					<input type = "hidden" name = "${repa.repa_no}cent_no" value  = "${repa.cent_no}">
					<input type = "hidden" name = "${repa.cent_name}cent_name" value  = "${repa.cent_name}">
					<input type = "hidden" name = "${repa.repa_no}repa_s_date" value  = "${repa.repa_s_date}">
					<input type = "hidden" name = "${repa.repa_no}repa_e_date" value  = "${repa.repa_e_date}">
					<input type = "hidden" name = "${repa.repa_no}mechanic_name" value  = "${repa.mechanic_name}">
					<input type = "hidden" name = "${repa.repa_no}repa_fee" value  = "${repa.repa_fee}">
					<input type = "hidden" name = "${repa.repa_no}repa_cont" value  = "${repa.repa_cont}">
					<input type = "hidden" name = "${repa.repa_no}repa_divi" value  = "${repa.repa_divi}">
 --%>
					
				
				
				
				
					</c:forEach>
				</table>
</body>
</html>