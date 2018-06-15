<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1~10까지 있는 페이지의 페이징 -->

<c:url var="action" value="/carlog.do?command=carlog_view_form&repa_s_date=${repa_s_date}&repa_e_date=${repa_e_date}&car_reg_no=${car_reg_no}&car_model=${car_model}&mem_name=${mem_name}&mem_id=${mem_id}"/>
<c:if test="${param.prev}">
<a href="${action}&page=1">prev</a>
</c:if>
<c:forEach begin="${param.begin}" end="${param.end}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}&page=${index}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
<a href="${action}?page=11">next</a>
</c:if>

</body>
</html>