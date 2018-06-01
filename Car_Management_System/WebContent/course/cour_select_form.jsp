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
<script type="text/javascript" src="js/course.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>장소 조회</title>
</head>
<body onload = "frm.place_name.value = <%= request.getParameter("place_name") %> ">

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;경로 조회</p>
</div>
<div class = "popup_body">

		<form name = "frm" method = "post" action = "course.do?command=cour_select&popup=yes">
		<select name="cour_divi">
							<option value="0">전체</option>
							<option value="1">출발지</option>
							<option value="2">도착지</option>
					</select>
					장소명 &nbsp;
					<input type = "text" name = "place_name">
					<button type = "submit" >조회</button>
			
		<%-- <c:if test = "${result==-1}">
		<div class = "popup_box">
		
				<p>'${s_place_name}'은 등록 되어 있지 않습니다. <br> 등록 하시겠습니까? 
					<button type = "button" onclick = "regiPlace()">등록</button> 
				</p>
		
		</div>			
		</c:if>
		
		<c:if test = "${result==1}"> --%>
		
			<div class = "popup_box">
				<%-- <p class = "search-result_label">'${s_place_name}'에 대한 조회 결과입니다.</p> --%>
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th >장소 번호</th>
						<th class = "number_th">출발지</th>
						<th>주소</th>
						<th>장소 번호</th>
						<th>도착지</th>
						<th>주소</th>
					</tr>
					<thead>
					<c:forEach var = "cour" items = "${s_placeList}">
				<tr>
						<td>${cour.s_place_no}</td>
						<td><a onclick = "splaceSelect('${cour.s_place_no}')">${cour.s_place_name}</a></td>		
						<td>${cour.s_place_addr }</td>		
						<td>${cour.e_place_no}</td>
						<td>${cour.e_place_name}</td>		
						<td>${cour.e_place_addr }</td>		
					</tr>	
					
									
					<input type = "hidden" name = "${cour.cour_no}cour_no" value  = "${cour.cour_no}">
					<input type = "hidden" name = "${cour.cour_no}s_place_no" value  = "${cour.s_place_no}">
					<input type = "hidden" name = "${cour.cour_no}s_place_name" value  = "${cour.s_place_name}">
					<input type = "hidden" name = "${cour.cour_no}s_place_addr" value  = "${cour.s_place_addr}">
					<input type = "hidden" name = "${cour.cour_no}e_place_no" value  = "${cour.e_place_no}">
					<input type = "hidden" name = "${cour.cour_no}e_place_name" value  = "${cour.e_place_name}">
					<input type = "hidden" name = "${cour.cour_no}e_place_addr" value  = "${cour.e_place_addr}">
					<input type = "hidden" name = "${cour.cour_no}cour_purpo" value  = "${cour.cour_purpo}">
					<input type = "hidden" name = "${cour.cour_no}distance" value  = "${cour.distance}">
					</c:forEach>
				</table>
			</div>
	<%-- 	</c:if>
 --%>
		
	
			</form>
		
		<%-- 	<div class = "popup_box">
				<p class = "search-result_label">전체 장소 리스트</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th>장소 번호</th>
							<th class = "number_th">장소명</th>
						<th>주소</th>
					</tr>
					<thead>
					<c:forEach var = "place" items = "${placeAllList}">
				<tr>
						<td>${place.place_no}</td>
						<td><a onclick = "splaceSelect('${place.place_no}')">${place.place_name}</a></td>		
						<td>${place.place_addr },${place.place_addr_dtl }</td>		
					</tr>	
					
				   <input type = "hidden" name = "${place.place_no}place_no" value  = "${place.place_no}">
					<input type = "hidden" name = "${place.place_no}place_name" value  = "${place.place_name}">
					<input type = "hidden" name = "${place.place_no}place_addr" value  = "${place.place_addr}">
					</c:forEach>
				</table>
				
				
				
			</div> --%>
</div>
</body>
</html>