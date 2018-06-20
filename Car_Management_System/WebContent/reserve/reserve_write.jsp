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
<link href="css/common.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/reserve.css" rel="stylesheet">
<link href="css/segmented-controls.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/rsrv.js?ver=1.1"></script>
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
			<form name = "frm" method = "post" action = "rsrv.do?command=reserve_view_cars">
			<input type = "hidden" name = "isTimeSelected" value = "${s_date ne null}">
			<input type = "hidden" name = "mem_id" value = "${LoginUser.mem_id}">
			<div class = "content_cont-box">
				<p class = "content_title-text">사용 일자</p>
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
					<button type = "button" class = "quiet_btn" onclick = "viewOneDay()">
						<span id = "search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
			</div>
			<div class = "row">
			<div class =  col-md-6 col-sm-12"">
				<div class = "content_cont-box">
				<c:choose>
				<c:when test="${dVoList ne null}">
				<h5>사용 시간 선택</h5>
				<table class  = "table table-bordered">	
				<thead><tr>
					<th>사용 시간</th>
					<th class = "schedule_choice">비고</th>
				</tr></thead>		
				<%
					List<DrivVO> dList = new ArrayList<DrivVO>();
					DrivVO tempVO = new DrivVO();
					MemberVO logSession = (MemberVO)session.getAttribute("LoginUser");
					String mem_id = logSession.getMem_id();
					
					dList = (List<DrivVO>) request.getAttribute("dVoList");					
					
					int hour = 8;
					int hourSub = hour;
					int dif = 0;
					int jp = 0;
					int isAdjust = 0;
					boolean isIn = false;
					for(int i = 0; i < 10; i++) {
						isIn = false;
						dif = 0;
						System.out.println(hour + " " + hourSub);
						if(hour > hourSub) {
							for(int hs = hourSub; hs < hour; hs+=1) {								
								out.print("<tr>");
								out.print("<td class = \"schedule_td\">");
								out.print(hourSub + "시  00분 ~ " +hourSub + "시 59분");
								out.print("</td>");
								out.print("</tr>");
								hourSub += 1;
							}
						}
						if(hourSub >= 18) break;
							out.print("<tr>");
							out.print("<td class = \"schedule_td\">");
							out.print(hourSub + "시  00분 ~ " + hourSub + "시 59분");
							out.print("</td>");
							hourSub += 1;
						
						
						for(int j = jp; j < dList.size(); j++) {
							tempVO = dList.get(j);
							System.out.println(dList.get(j));
							if(hour == tempVO.getS_hour()) {
								isIn = true;
								break;
							}else {				
								isIn = false;
							}
						}
						if(isIn == true) {
							dif = tempVO.getE_hour() - tempVO.getS_hour();								
							
							if(tempVO.getMem_id().equals(mem_id)){ // 위에서 정의함
								out.print("<td class = \"schedule_td btn-in\" rowspan = " + dif + ">");								
								out.print("<button onclick =\"carlogWriteFrm(" + tempVO.getDriv_no() + ")\"  type = \"button\" class = \"rsrv_etc_btn wrt_btn\">일지 작성</button>");
								out.print("<button onclick =\"rsrvDelete(" + tempVO.getDriv_no() + ")\" type = \"button\" class = \"rsrv_etc_btn cnl_btn\">등록 취소</button>");
							}else {
								out.print("<td class = \"schedule_td btn-in\" rowspan = " + dif + ">");								
								out.print("<button class = \"rsrv_etc_btn no-btn\" disabled>이미 예약됨</button>");
							}
							
							out.print("</td>");
							out.print("</tr>");
							hour += dif;
							System.out.println(hour);
							jp++;
						} else {
							if(dif <= 1){
								out.print("<td class = \"schedule_td_selectable\">");
								out.print("<div class=\"segmented-control\" style=\"width: 100%;\">");
								out.print("<input onchange = \"checkboxControl(" + hour + ");\" type = \"checkbox\" name = \"time\" id = \"chk_" + hour + "\" value = \""+ hour +"\">");
								out.print("<label for=\"chk_" + hour + "\" data-value=\"선택됨\">선택</label>");
								out.print("</div>");
								out.print("</td></tr>");
								hour += 1;
							}
						}
						if(hourSub >= 18) break;
					}
				%>
				</table>
				<div class = "form_btn-group">
					<button onclick = "return timeCheck();" type = "submit" class = "long_btn">
					사용 가능한 차량 확인</button>
				</div>
				</c:when>
				<c:otherwise>
					※ 사용 일자를 먼저 선택해주세요
				</c:otherwise>
				</c:choose>	
				</div>
			</div> <!-- class = col -->
			
			<script type="text/javascript">
				/*
				*	시간 선택 후에 모바일 페이지에서는 차량선택화면이
				*	바로 안보여서 이동시켜주는 jQuery문
				*/
				if(document.frm.isTimeSelected.value == "true") {
					$(document).ready(function () {
						$('html, body').animate({
						scrollTop: $('#carSelect').offset().top-100
							}, 'slow');
					});
				}
			</script>	
			
			<div class = " col-md-6 col-sm-12">
				<div id = "carSelect" class = "content_cont-box">
				<c:choose>
				<c:when test = "${cVoList ne null}">
					<fmt:parseDate var="dateString" value="${date}" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${dateString}" type="both" pattern="yyyy년 MM월 dd일(E)"/>
					<h5>${s_date}시 ~ ${e_date}시에 사용 가능한 차량 목록</h5>
					<table class = "table table-hover">				
						<thead><tr>
							<th>차종</th>
							<th>차량등록번호</th>
							<th>차량 선택</th>
						</tr></thead>
						<c:forEach var = "car" items = "${cVoList}">
							<tr>
								<td>${car.car_model}</td>
								<td>${car.car_reg_no}</td>
								<td>
									<button type = "button" onclick = "selectThisCar('${date}', '${s_date}', '${e_date}', '${car.car_reg_no}')">이 차량으로 등록</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					※ 사용 시간을 먼저 선택해주세요
				</c:otherwise>
				</c:choose>
				</div><!-- class=content_cont-box -->
			</div>
			</div> <!-- class=row -->
			</form>
		</section>
	</section>
</body>
</html>