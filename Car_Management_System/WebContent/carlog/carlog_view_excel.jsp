
<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*, java.text.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("UTF-8");
String car_reg_no = new String(request.getParameter("car_reg_no").getBytes("8859_1"),"UTF-8");
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMM");
String today = formatter.format(new java.util.Date());
response.setHeader("Content-Disposition","attachment;filename="+car_reg_no+"_"+today+".xls");
response.setHeader("Content-Description", "JSP Generated Data");
%>
<style>
table{
 border: 1px solid #fff;
}
</style>
</head>
<body>
<h3> 차량운행일지 </h3>
<table>					
					<thead>
					<tr>
						<th class = "number_th">년도</th>
						<th>월</th>
						<th>일</th>
						<th>부서</th>
						<th>성명</th>
						<th>구분</th>
						<th>분류(출)</th>
						<th>출발지 명</th>
						<th>주소</th>
						<th>분류(도)</th>
						<th>도착지명</th>
						<th>주소</th>
						<th>주행Km</th>
						<th>비고</th>
					</tr>
					<thead>
					<c:forEach var = "carlog" items = "${carlogAllList}">
					
				<tr>
						<td>${carlog.driv_year}</td>
						<td>${carlog.driv_month}</td>
						<td>${carlog.driv_day}</td>
						<td>${carlog.dept_name}</td>
						<td>${carlog.mem_name}</td>
						<td>${carlog.driv_divi}</td>
						<td>${carlog.place_s_divi}</td>
						<td>${carlog.s_place_name}</td>
						<td>${carlog.s_place_addr}</td>
						<td>${carlog.place_e_divi}</td>
						<td>${carlog.e_place_name}</td>
						<td>${carlog.e_place_addr}</td>
						<td>${carlog.distance}</td>
						<td>${carlog.driv_purpo}</td>
						<td>
						<c:choose>
						<c:when test="${carlog.card_divi eq '미사용'}">
							-
						</c:when>
						<c:when test="${carlog.card_divi eq '개인카드'}">
						${carlog.card_divi}->유류비:${carlog.oil_fee}원+교통비:${carlog.trans_fee}원+${carlog.etc_text}:${carlog.etc_fee}
						</c:when>
						<c:when test="${carlog.card_divi eq '법인카드'}">
						${carlog.card_divi}->유류비:${carlog.oil_fee}원+교통비:${carlog.trans_fee}원+${carlog.etc_text}:${carlog.etc_fee}
						</c:when>
						</c:choose>
						</td>
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
