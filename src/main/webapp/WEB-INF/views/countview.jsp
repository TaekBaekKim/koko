<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="top.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="450px" align="center">
	<tr>
		<th>도서명</th><th>이미지</th>
	</tr>
	<c:forEach items="${list2 }" var="my">
	<tr>
		<td>${my.bname }</td>
		<td><img src="./image/${my.bimage }"></td>
	</tr>
	</c:forEach>	
</table>
</body>
</html>