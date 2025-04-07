<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th><th>패스워드</th><th>이름</th><th>나이</th>
	</tr>
	<c:forEach items="${list }" var="my">
	<tr>
		<td>${my.id }</td>
		<td>${my.pw }</td>
		<td>${my.name }</td>
		<td>${my.age }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>