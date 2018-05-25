<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %>
<%@ page import="com.plani.cms.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>배차 등록 :: 법인차량관리시스템</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/reserve.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/rsrv.js"></script>
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
		<script type = "text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
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
				<p class="content_cont-text">장소 번호</p>
					<c:choose>
						<c:when test="${date eq null}">
							<div id = "date">
								<input type="text" class="form_textbox" name = "date">
							</div>
						</c:when>
						<c:otherwise>
							<div id = "date">
								<input type="text" class="form_textbox" name = "date" value = "${date}">
							</div>
						</c:otherwise>
					</c:choose>
					<script type="text/javascript">
						$('#date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>	
			</div>
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
						<button type = "button" onclick = "viewOneDay('${car.car_reg_no}')">사용</button>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class = "content_cont-box">
			<table class  = "schedule_table">		
				<c:if test="${date ne null}">		
				<%
					List<DrivVO> dList = new ArrayList<DrivVO>();
					DrivVO tempVO = new DrivVO();
					
					dList = (List<DrivVO>) request.getAttribute("dVoList");
					
					
					int hour = 7;
					int dif = 0;
					int jp = 0;
					boolean isIn = false;
					for(int i = 0; i < 8; i++) {
						isIn = false;
						out.print("<tr>");
						out.print("<td>");
						out.print(hour);
						out.print("</td>");
						for(int j = jp; j < dList.size(); j++) {
							tempVO = dList.get(j);
							if(hour == tempVO.getS_hour()) {
								isIn = true;
								break;
							}else {				
								isIn = false;
							}
						}
						if(isIn == true) {
							dif = tempVO.getE_hour() - tempVO.getS_hour();								
							out.print("<td class = \"schedule_td\" rowspan = " + dif/2 + ">");
							out.print(tempVO.getMem_id());
							out.print("</td>");
							out.print("</tr>");
							i += (dif-2);
							hour += 2;
							jp++;
						} else {
							if(dif <= 2){
								out.print("<td class = \"schedule_td\">blank" + hour + "</td></tr>");
								hour += 2;
							}
						}
					}
				%>
				</c:if>
			</table>
			</div>
			</form>
		</section>
	</section>
</body>
</html>