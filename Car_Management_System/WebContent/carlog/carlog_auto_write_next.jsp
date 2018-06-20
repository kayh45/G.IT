<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<title>운행 일지 작성 :: 법인차량관리시스템</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="css/carlog.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.js"></script>

<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/member.js?ver=4"></script>
<script type="text/javascript" src="js/car.js?ver=3"></script>
<script type="text/javascript" src="js/carlog.js?ver=2"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>

	<header> <%@ include file="../header.jsp"%>
	<!-- 헤더 --> </header>
	<section id="main"> <aside id="side"> <%@ include
		file="sideMenu.jsp"%> </aside> <section id="content">
	<c:if test="${message ne null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${message}
		</div>
	</c:if>
	<div class="content_title-box">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
		<p class="content_title-text">운행일지 일괄작성</p>
	</div>
	<form name="frm" method="post" action = "carlog.do?command=carlog_auto_write_next">
		<input type = "hidden" name = "demand" value = "id">
		<div class="content_cont-box">
			<p class="content_cont-text">차량 등록 번호</p>
			<input type="text" class="form_textbox" name="car_reg_no"> <input
				type="hidden" name="car_reg_no_ok" class="form_textbox"> <input
				type="hidden" name="car_usable_no">
			<button type="button" onClick="carSearch()" class="quiet_btn"
				id="idCheck">
				<span id="search-button" class="glyphicon glyphicon-search"
					aria-hidden="true"></span>
			</button>
		</div>
		<div class="content_cont-box">
			<p class="content_cont-text">*일지 작성 기본 정보</p>
			<table class="table table-bordered" id="form_table">
				<tr>
					<td class="form_label">
						<p class="label">작성기간</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan="3">
					<select class="form_car_select select_sm" name = "carlog_year">
							<option value="${curYear - 2}">${curYear - 2}년</option>
							<option value="${curYear - 1}">${curYear - 1}년</option>
							<option value="${curYear}" selected>${curYear}년</option>
					</select> 
					<select class="form_car_select select_sm" name = "carlog_month">
							<c:forEach varStatus="month" begin="1" end="12" step="1">
								<option value="${month.count}">${month.count}월</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">운전자</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan = "3">
						<input name="mem_search_name" type="text" class="form_textbox">
						<input name = "mem_name" type = "hidden">
						<input name = "mem_id" type = "hidden">
						<button type="button" onClick="memSearchByName();" class="quiet_btn">
							<span id="search-button" class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">실 주행거리</p>
						<p class="must">*</p>
					</td>
					<td class="form_normal-td" colspan = "3">
						<input name="mem_search_name" type="text" class="form_textbox"> km
					</td>
				</tr>
			</table>
		</div>
		<div class = "content_cont-box">
		<p class="content_cont-text">* 주 이용 (출·퇴근) 경로 정보</p>
			<p class="content_cont-text"></p>
			<input name="cour_no" type="hidden" class="form_textbox">
			<table class="table table-bordered" id="form_table">

				<tr>
					<td class="form_label">
						<p class="label">출발지</p>

					</td>
					<td><input name="s_place_name" type="text"
						class="form_textbox" readonly>
						<button type="button" onClick="carlogCourseSearch();"
							class="quiet_btn" id="idCheck">
							<span id="search-button" class="glyphicon glyphicon-search"
								aria-hidden="true"></span>
						</button></td>
					<td class="form_label">
						<p class="label">도착지</p>
					</td>
					<td class="form_normal-td">
						<input name="e_place_name" type="text" class="form_textbox" readonly>
						<input name = "driv_purpo" type = "hidden">
					</td>
				</tr>
				<tr>
					<td class="form_label">
						<p class="label">주행거리</p>
					</td>
					<td class="form_normal-td" colspan="3"><input name="driv_dist"
						type="text" size="13" class="form_textbox">&nbsp;km</td>
				</tr>
			</table>
		</div>
		
		<script type = "text/javascript">
		$(document).ready(function(){
            // 옵션추가 버튼 클릭시
            $("#addItemBtn").click(function(){
                // item 의 최대번호 구하기
                var lastItemNo = $("#example tr:last").attr("class").replace("item", "");
                var newitem = $("#example tr:eq(1)").clone();
                newitem.removeClass();
                newitem.find("td:eq(0)").attr("rowspan", "1");
                newitem.find("td:eq(3)").children("button").attr("onclick", "carlogCourseSearchAuto('" + (parseInt(lastItemNo)+1) + "')");
                newitem.find("td:eq(3)").children("input").attr("id", "card_course"+(parseInt(lastItemNo)+1))
                newitem.addClass("item"+(parseInt(lastItemNo)+1)); 
 
                $("#example").append(newitem);
            });
            
            $("#example").on("click", ".delBtn", function(){
                var clickedRow = $(this).parent().parent();
                var cls = clickedRow.attr("class");
                
                if (cls != "item1") {
                // 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
                	if( clickedRow.find("td:eq(0)").attr("rowspan") ){
                 	   if( clickedRow.next().hasClass(cls) ){
                   	     clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
                  	  }
              	 	}
	                clickedRow.remove();
                }
 
                // rowspan 조정
                // resizeRowspan(cls);
            });

		})
		</script>
		<div class="content_cont-box">
			법인카드 사용 내역  <button class = "quiet_btn" type = "button" id = "addItemBtn">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
			<table id = "example" class = "table tbl_card">
				<thead><tr>
					<th class = "td_short">일자</th>
					<th>유류비</th>
					<th>교통비</th>
					<th>경로</th>
					<th class = "td_short">비고</th>
				</tr></thead>
				<tbody>
					<tr class = "item1">
						<td><input name = "card_day" class = "form_textbox text_short" maxlength="2" type = text>일</td>
						<td><input name = "card_oil" class = "form_textbox" type = "text">원</td>
						<td><input name = "card_trans" class = "form_textbox" type = "text">원</td>
						<td><input value = "" id = "card_course1" name = "card_course" class = "form_textbox" type = "text" readonly>
						<button type = "button" class = "quiet_btn" onClick="carlogCourseSearchAuto('1');">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button></td>
						<td>
							<button type = "button" class = "delBtn quiet_btn">
								<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<input type = "hidden" name = "canWrites" value = "0">
		<div class = "form_btn-group">
			<button id = "ins_btn" type = "submit" onclick="return carLogAutoNext()" disabled>다음</button>
		</div>
	</form>
	</section> 
	</section>
</body>
</html>