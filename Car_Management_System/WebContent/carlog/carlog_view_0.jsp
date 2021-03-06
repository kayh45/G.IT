<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>법인차량관리시스템(사용자용)</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery.schedule.css" rel="stylesheet">
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/segmented-controls.css" rel="stylesheet">
<script type = "text/javascript" src="js/bootstrap.js"></script>
<script type = "text/javascript" src="js/common.js"></script>
<script type = "text/javascript" src="js/rsrv.js"></script>
<script type = "text/javascript" src="js/carlog.js?ver=2"></script>
<style>
.right {
	text-align : right;
}
.box {
	width : 100%;
	height : 100%;
 	text-align : right;
}
div .box button{
	background-color: #368AFF;
}
</style>
<script type="text/javascript">
function goPage(i) {
	 var url = "carlog.do?command=carlog_view_form_0&page="+i;
		document.frm.action=url; 	
		document.frm.submit();
	
}
	</script>


</head>

<body>
	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include file="sideMenu.jsp"%> </aside>
	<script type = "text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
	 <section id="content">
	<form name="frm" method="post" action="carlog.do?command=carlog_view_form_0">
		<div class="content_title-box">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			<p class="content_title-text">운행 일지 조회</p>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*운행 일지 정보</p>
			<table class="table table-bordered" id="form_table">
			<tr>
				<td class="form_label">
					<p class="label">운행 날짜(시작)</p>
					<p class="must">*</p>
				</td>
				<td>				
					<div id = "repa_s_date">
						<input type="text" class="form_textbox" name = "repa_s_date" value="${repa_s_date}">
					</div>
					<script type="text/javascript">
						$('#repa_s_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>	
				
				</td>
				<td class="form_label">
					<p class="label">운행 날짜(종료)</p>
					<p class="must">*</p>
				</td>
				<td class="form_normal-td">
					<div id = "repa_e_date">
						<input type="text" class="form_textbox" name = "repa_e_date" value="${repa_e_date}">
					</div>
					<script type="text/javascript">
						$('#repa_e_date input').datepicker({dateFormat: "yy-mm-dd"});
					</script>										
					</td>
			</tr>
				
				<tr>
					<td class="form_label">
						<p class="label">사원 이름</p>
					</td>
					<td class="form_normal-td" colspan="3"><input type="text"
						class="form_textbox" id="mem_name" name="mem_name" value="${LoginUser.mem_name}" readonly>
						</td>
				</tr>
			</table>
			<div class="form_btn-group1">
		<button id="ins_btn" type="submit" onclick="return carlogDateCheck0()">조회</button>
		</div>
		</div>
			<div class = "content_cont-box"
			id="content_cont-box1" style=display:block;>
				<p class = "search-result_label" >조회 리스트:${count}개</p>

				<table class = "table table-condensed table-bordered" >					
					<thead>
					<tr>
						<th class = "number_th">일자</th>
						<th>사용목적</th>
						<th>출발지</th>
						<th>도착지</th>
						<th>주행거리</th>
						<th>법인카드 사용금액</th>
						 <th>비고</th> 
					</tr>
					<thead>
					<c:forEach var = "carlog" items = "${carlogAllList}">
					
				<tr>		               
						<td>${carlog.driv_year}-${carlog.driv_month}-${carlog.driv_day}</td>
						<td>${carlog.driv_purpo}</td>
						<td>${carlog.s_place_name}</td>
						<td>${carlog.e_place_name}</td>
						<td class="right">${carlog.distance}</td>
						<td class="right">${carlog.total_fee}</td>
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
				
				<c:if test = "${paging.finalPageNo ne null}">
			<div class="paginate">
    <a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a>
    <a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a>
    <span>
        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq paging.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>        
    </span>
    <a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a>
    <a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
</div>
</c:if>
			
			</div>
				
				
			
	</form>
	</section> 
	</section>

		
</body>
</html>