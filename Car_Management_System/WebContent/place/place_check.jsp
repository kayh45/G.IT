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
<script type="text/javascript" src="js/place.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>장소 조회</title>
</head>
<body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;장소 조회</p>
</div>
<div class = "popup_body">

		<form name = "frm" method = "post" action = "place.do?command=place_write_check_form&popup=yes">
					장소명 &nbsp;
					<input type = "text" name = "place_name" value = "${place_name}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "place_name_ok" value = "1">
			
		<c:if test = "${result==-1}">
		<div class = "popup_box">
		
				<p>'${place_name}'은 등록가능합니다. 
					<button type = "button" onclick = "usePlaceName()">사용</button> 
				</p>
		
		</div>	 	
		</c:if>
		
		<c:if test = "${result==1}">
		
			<div class = "popup_box">
				<p class = "search-result_label">'${place_name}'에 대한 조회 결과입니다.</p>
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th >장소 번호</th>
						<th class = "number_th">장소명</th>
						<th>주소</th>
					</tr>
					<thead>
					<c:forEach var = "place" items = "${placeList}">
				<tr>
						<td>${place.place_no}</td>
						<td><a onclick = "placeSelect('${place.place_no}')">${place.place_name}</a></td>		
						<td>${place.place_addr },${place.place_addr_dtl }</td>		
					</tr>	
					
									
					<input type = "hidden" name = "${place.place_no}place_no" value  = "${place.place_no}">
					<input type = "hidden" name = "${place.place_no}place_name" value  = "${place.place_name}">
					<input type = "hidden" name = "${place.place_no}place_p_no" value  = "${place.place_p_no}">
					<input type = "hidden" name = "${place.place_no}place_addr" value  = "${place.place_addr}">
					<input type = "hidden" name = "${place.place_no}place_addr_dtl" value  = "${place.place_addr_dtl}">
					</c:forEach>
				</table>
			</div>
		</c:if>

		
	
			</form>
		
			<div class = "popup_box">
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
						<td><a onclick = "placeSelect('${place.place_no}')">${place.place_name}</a></td>		
						<td>${place.place_addr },${place.place_addr_dtl }</td>		
					</tr>	
					
									
					<input type = "hidden" name = "${place.place_no}place_no" value  = "${place.place_no}">
					<input type = "hidden" name = "${place.place_no}place_name" value  = "${place.place_name}">
					<input type = "hidden" name = "${place.place_no}place_p_no" value  = "${place.place_p_no}">
					<input type = "hidden" name = "${place.place_no}place_addr" value  = "${place.place_addr}">
					<input type = "hidden" name = "${place.place_no}place_addr_dtl" value  = "${place.place_addr_dtl}">
					</c:forEach>
				</table>
				
				
				
			</div>
</div>
</body>
</html>