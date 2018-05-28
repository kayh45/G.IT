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
<script type = "text/javascript" src="js/car.js"></script>





<title>법인차 조회</title>
</head>
<body>
<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;법인차 조회</p>
</div>
<div class = "popup_body">

		<form name = "frm" method = "post" action = "car.do?command=car_write_check_form">
					차량 등록 번호 &nbsp;
					<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "car_reg_no_ok" value = "1">
			
		<c:if test = "${result==-1}">
		<div class = "popup_box">
		
				<p>'${car_reg_no}'은 등록가능합니다. 
					<button type = "button" onclick = "useCarNo()">사용</button> 
				</p>
		
		</div>			
		</c:if>
		
		<c:if test = "${result==1}">
		
			<div class = "popup_box">
				<p class = "search-result_label">'${car_reg_no}'에 대한 조회 결과입니다.</p>
					<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
						<th>법인차 구분</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carList}">
				<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "carSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
						<td>${car.car_divi}</td>
					</tr>					
					<input type = "hidden" name = "${car.car_reg_no}car_reg_no" value  = "${car.car_reg_no}">
					<input type = "hidden" name = "${car.car_reg_no}car_model" value  = "${car.car_model}">
					<input type = "hidden" name = "${car.car_reg_no}car_divi" value  = "${car.car_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_name" value  = "${car.bo_name}">
					<input type = "hidden" name = "${car.car_reg_no}bo_divi" value  = "${car.bo_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_age" value  = "${car.bo_age}">
					<input type = "hidden" name = "${car.car_reg_no}bo_s_date" value  = "${car.bo_s_date}">
					<input type = "hidden" name = "${car.car_reg_no}bo_e_date" value  = "${car.bo_e_date}">
					<input type = "hidden" name = "${car.car_reg_no}co_name" value  = "${car.co_name}">
					<input type = "hidden" name = "${car.car_reg_no}co_tel" value  = "${car.co_tel}">
					<input type = "hidden" name = "${car.car_reg_no}co_fax" value  = "${car.co_fax}">
					<input type = "hidden" name = "${car.car_reg_no}ct_date" value  = "${car.ct_date}">
					<input type = "hidden" name = "${car.car_reg_no}ep_date" value  = "${car.ep_date}">
				
	
					</c:forEach>
				</table>
			</div>
		</c:if>

		
	
			</form>
		
			<div class = "popup_box">
				<p class = "search-result_label">전체 법인차 리스트</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
						<th>법인차 구분</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carAllList}">
				<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "carSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
						<td>${car.car_divi}</td>
					</tr>					
					<input type = "hidden" name = "${car.car_reg_no}car_reg_no" value  = "${car.car_reg_no}">
					<input type = "hidden" name = "${car.car_reg_no}car_model" value  = "${car.car_model}">
					<input type = "hidden" name = "${car.car_reg_no}car_divi" value  = "${car.car_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_name" value  = "${car.bo_name}">
					<input type = "hidden" name = "${car.car_reg_no}bo_divi" value  = "${car.bo_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_age" value  = "${car.bo_age}">
					<input type = "hidden" name = "${car.car_reg_no}bo_s_date" value  = "${car.bo_s_date}">
					<input type = "hidden" name = "${car.car_reg_no}bo_e_date" value  = "${car.bo_e_date}">
					<input type = "hidden" name = "${car.car_reg_no}co_name" value  = "${car.co_name}">
					<input type = "hidden" name = "${car.car_reg_no}co_tel" value  = "${car.co_tel}">
					<input type = "hidden" name = "${car.car_reg_no}co_fax" value  = "${car.co_fax}">
					<input type = "hidden" name = "${car.car_reg_no}ct_date" value  = "${car.ct_date}">
					<input type = "hidden" name = "${car.car_reg_no}ep_date" value  = "${car.ep_date}">
				
	
					</c:forEach>
				</table>
				
				
				
			</div>
</div>
</body>
</html>














<%-- <body>

<div class = "popup_header">	 
	<p><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;법인차 조회</p>
</div>
<div class = "popup_body">
	<c:choose>
	<c:when test="${result==-1}">
		<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=car_write_check_form">
					차량 등록 번호 &nbsp;
					<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
					<button type = "submit">조회</button>
				<input type = "hidden" name = "car_reg_no_ok" value = "1">
				<p>'${car_reg_no}'은 등록가능합니다. 
					<button type = "button" onclick = "useCarNo()">사용</button> 
				</p>
			</form>
		</div>		
		
		
		</c:when>
	<c:when test="${result==1}">
			<div class = "popup_box">
				<form name = "frm" method = "post" action = "car.do?command=car_write_check_form">
					차량 등록 번호 &nbsp;
					<input type = "text" name = "car_reg_no" value = "${car_reg_no}">
					<button type = "submit">조회</button>
					</form>
					</div>
			<div class = "popup_box">
				<p class = "search-result_label">'${car_reg_no}'에 대한 조회 결과입니다.</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
						<th>법인차 구분</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carList}">
				<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "carSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
						<td>${car.car_divi}</td>
					</tr>					
					<input type = "hidden" name = "${car.car_reg_no}car_reg_no" value  = "${car.car_reg_no}">
					<input type = "hidden" name = "${car.car_reg_no}car_model" value  = "${car.car_model}">
					<input type = "hidden" name = "${car.car_reg_no}car_divi" value  = "${car.car_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_name" value  = "${car.bo_name}">
					<input type = "hidden" name = "${car.car_reg_no}bo_divi" value  = "${car.bo_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_age" value  = "${car.bo_age}">
					<input type = "hidden" name = "${car.car_reg_no}bo_s_date" value  = "${car.bo_s_date}">
					<input type = "hidden" name = "${car.car_reg_no}bo_e_date" value  = "${car.bo_e_date}">
					<input type = "hidden" name = "${car.car_reg_no}co_name" value  = "${car.co_name}">
					<input type = "hidden" name = "${car.car_reg_no}co_tel" value  = "${car.co_tel}">
					<input type = "hidden" name = "${car.car_reg_no}co_fax" value  = "${car.co_fax}">
					<input type = "hidden" name = "${car.car_reg_no}ct_date" value  = "${car.ct_date}">
					<input type = "hidden" name = "${car.car_reg_no}ep_date" value  = "${car.ep_date}">
				
	
					</c:forEach>
				</table>
				
				
				
			
			<div class = "popup_box">
				<p class = "search-result_label">전체 법인차 리스트</p>
				<table class = "table table-condensed table-bordered">					
					<thead>
					<tr>
						<th class = "number_th">차량 등록 번호</th>
						<th>차종</th>
						<th>법인차 구분</th>
					</tr>
					<thead>
					<c:forEach var = "car" items = "${carAllList}">
				<tr>
						<td>${car.car_reg_no}</td>
						<td><a onclick = "carSelect('${car.car_reg_no}')">${car.car_model}</a></td>		
						<td>${car.car_divi}</td>
					</tr>					
					<input type = "hidden" name = "${car.car_reg_no}car_reg_no" value  = "${car.car_reg_no}">
					<input type = "hidden" name = "${car.car_reg_no}car_model" value  = "${car.car_model}">
					<input type = "hidden" name = "${car.car_reg_no}car_divi" value  = "${car.car_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_name" value  = "${car.bo_name}">
					<input type = "hidden" name = "${car.car_reg_no}bo_divi" value  = "${car.bo_divi}">
					<input type = "hidden" name = "${car.car_reg_no}bo_age" value  = "${car.bo_age}">
					<input type = "hidden" name = "${car.car_reg_no}bo_s_date" value  = "${car.bo_s_date}">
					<input type = "hidden" name = "${car.car_reg_no}bo_e_date" value  = "${car.bo_e_date}">
					<input type = "hidden" name = "${car.car_reg_no}co_name" value  = "${car.co_name}">
					<input type = "hidden" name = "${car.car_reg_no}co_tel" value  = "${car.co_tel}">
					<input type = "hidden" name = "${car.car_reg_no}co_fax" value  = "${car.co_fax}">
					<input type = "hidden" name = "${car.car_reg_no}ct_date" value  = "${car.ct_date}">
					<input type = "hidden" name = "${car.car_reg_no}ep_date" value  = "${car.ep_date}">
				
	
					</c:forEach>
				</table>
				
				
				
			</div>
		</c:when>
		<c:otherwise>
			<p>잘못된 접근입니다.</p>
		</c:otherwise>
	</c:choose>	
</div>
</body>
</html>



	<form method="post" action="HECE_SystemServlet" name="frm">
		<input type="hidden" name="command" value="engin_check_list">
		기술자명 <input type="text" name="enginname" value="${enginname}">
		<input type="submit" value="검색">
	<input type="button" value="사용" onclick="enginNameOk('${enginname}')"><br>
	</form>
	<c:if test="${result==-1}">
		<br>
		<script type="text/javascript">
			opener.document.frm.enginname.value == "";
		</script>
	${enginname}의 검색결과가 없습니다.
	</c:if>
	<c:if test="${result==1}">
		<h4>검색된 기술자명</h4>
		<table>
			<tr>
				<th>기술자 번호</th>
				<th>기술자명</th>
				<th>직급</th>
				<th>전공 기술</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>기술료 번호</th>
				<th>기술료명</th>
				<th>기술료</th>
			</tr>
			<tr>
				<c:forEach var='EnginList' items="${EnginList}" varStatus="status">
					<tr>
						<td>${EnginList.enginnum}</td>
						<td><a href="#" onclick="frmlinkchk('${EnginList.enginnum}','${EnginList.enginname}','${EnginList.enginjob}','${EnginList.enginmajor}','${EnginList.enginphone1}','${EnginList.enginphone2}','${EnginList.enginphone3}','${EnginList.enginemail1}','${EnginList.enginemail2}','${EnginList.enginpost}','${EnginList.enginaddr1}','${EnginList.enginaddr2}','${techfeeList[status.index].feenum }','${techfeeList[status.index].feename }','${techfeeList[status.index].fee }')">${EnginList.enginname}</a>
							</td>
							<td>${EnginList.enginjob }</td>
							<td>${EnginList.enginmajor }</td>
							<td>${EnginList.enginphone1 }-${EnginList.enginphone2 }-${EnginList.enginphone3 }</td>
							<td>${EnginList.enginemail1 }@${EnginList.enginemail2 }</td>
							<td>${EnginList.enginpost }</td>
							<td>${EnginList.enginaddr1 }${EnginList.enginaddr2 }</td>
							<td>${techfeeList[status.index].feenum }</td>
							<td>${techfeeList[status.index].feename }</td>
							<td>${techfeeList[status.index].fee }</td>
					</tr>
				</c:forEach>
		</table>
	</c:if>
	<h4>기술자 전체 리스트</h4>
		<table>
			<tr>
				<th>기술자 번호</th>
				<th>기술자명</th>
				<th>직급</th>
				<th>전공 기술</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>기술료 번호</th>
				<th>기술료명</th>
				<th>기술료</th>
			</tr>
			<tr>
				<c:forEach var='EnginList' items="${EnginAllList}" varStatus="status">
					<tr>
						<td>${EnginList.enginnum}</td>
						<td><a href="#" onclick="frmlinkchk('${EnginList.enginnum}','${EnginList.enginname}','${EnginList.enginjob}','${EnginList.enginmajor}','${EnginList.enginphone1}','${EnginList.enginphone2}','${EnginList.enginphone3}','${EnginList.enginemail1}','${EnginList.enginemail2}','${EnginList.enginpost}','${EnginList.enginaddr1}','${EnginList.enginaddr2}','${techfeeAllList[status.index].feenum }','${techfeeAllList[status.index].feename }','${techfeeAllList[status.index].fee }')">${EnginList.enginname}</a>
							</td>
							<td>${EnginList.enginjob }</td>
							<td>${EnginList.enginmajor }</td>
							<td>${EnginList.enginphone1 }-${EnginList.enginphone2 }-${EnginList.enginphone3 }</td>
							<td>${EnginList.enginemail1 }@${EnginList.enginemail2 }</td>
							<td>${EnginList.enginpost }</td>
							<td>${EnginList.enginaddr1 }${EnginList.enginaddr2 }</td>
							<td>${techfeeAllList[status.index].feenum }</td>
							<td>${techfeeAllList[status.index].feename }</td>
							<td>${techfeeAllList[status.index].fee }</td>
					</tr>
				</c:forEach>
		</table>
</body>
</html> --%>