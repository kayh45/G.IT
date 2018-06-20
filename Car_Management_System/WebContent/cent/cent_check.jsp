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
<script type = "text/javascript" src="js/cent.js?ver=4"></script>





<title>정비소 조회</title>
</head>
<body>
<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;정비소 조회</p>
</div>
<div class = "popup_body">

		<form name = "frm" method = "post" action = "cent.do?command=cent_write_check_form&popup=yes">
					정비소명 &nbsp;
					<input type = "text" name = "cent_name" value = "${cent_name}">
						<button type = "submit">조회</button>
					<input type = "hidden" name = "cent_name_ok" value = "1">
			
		<c:if test = "${result==-1}">
		<div class = "popup_box">
		
				<p>'${cent_name}'은 등록가능합니다. 
					<button type = "button" onclick = "useCentName()">사용</button> 
				</p>
		
		</div>			
		</c:if>
		
		<c:if test = "${result==1}">
		
			<div class = "popup_box">
				<p class = "search-result_label">'${cent_name}'에 대한 조회 결과입니다.</p>
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">정비소 번호</th>
						<th>정비소 이름</th>
						<th>대표자</th>
					</tr>
					<thead>
					<c:forEach var = "cent" items = "${centList}">
					<tr>
						<td>${cent.cent_no}</td>
						<td><a onclick = "centSelect('${cent.cent_no}')">${cent.cent_name}</a></td>		
						<td>${cent.ceo_name}</td>
					</tr>	
							<input type = "hidden" name = "${cent.cent_no}cent_no" value  = "${cent.cent_no}">
               				<input type = "hidden" name = "${cent.cent_no}cent_name" value  = "${cent.cent_name}">
              				<input type = "hidden" name = "${cent.cent_no}ceo_name" value  = "${cent.ceo_name}">
               				<input type = "hidden" name = "${cent.cent_no}cent_tell" value  = "${cent.cent_tell}">
             				<input type = "hidden" name = "${cent.cent_no}cent_fax" value  = "${cent.cent_fax}">
             				<input type = "hidden" name = "${cent.cent_no}cent_p_no" value  = "${cent.cent_p_no}">
             				<input type = "hidden" name = "${cent.cent_no}cent_addr" value  = "${cent.cent_addr}">
             			  	<input type = "hidden" name = "${cent.cent_no}cent_addr_dtl" value  = "${cent.cent_addr_dtl}">
						
		</c:forEach>
				</table>
			</div>
		</c:if>
			</form>		
			<div class = "popup_box">
				<p class = "search-result_label">전체 정비소 리스트</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">정비소 번호</th>
						<th>정비소 이름</th>
						<th>대표자</th>
					</tr>
					<thead>
					<c:forEach var = "cent" items = "${centAllList}">
					<tr>
						<td>${cent.cent_no}</td>
						<td><a onclick = "centSelect('${cent.cent_no}')">${cent.cent_name}</a></td>		
						<td>${cent.ceo_name}</td>
					</tr>			
							<input type = "hidden" name = "${cent.cent_no}cent_no" value  = "${cent.cent_no}">
               				<input type = "hidden" name = "${cent.cent_no}cent_name" value  = "${cent.cent_name}">
              				<input type = "hidden" name = "${cent.cent_no}ceo_name" value  = "${cent.ceo_name}">
               				<input type = "hidden" name = "${cent.cent_no}cent_tell" value  = "${cent.cent_tell}">
             				<input type = "hidden" name = "${cent.cent_no}cent_fax" value  = "${cent.cent_fax}">
             				<input type = "hidden" name = "${cent.cent_no}cent_p_no" value  = "${cent.cent_p_no}">
             				<input type = "hidden" name = "${cent.cent_no}cent_addr" value  = "${cent.cent_addr}">
             			  	<input type = "hidden" name = "${cent.cent_no}cent_addr_dtl" value  = "${cent.cent_addr_dtl}">
					</c:forEach>
				</table>
				
				
				
			</div>
</div>

</body>
</html>