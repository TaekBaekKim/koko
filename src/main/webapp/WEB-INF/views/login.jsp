<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="home" method="post">
<table border="2" width="450px" align="center">
<caption>회원가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="id" id="id">
	</td>
</tr>	
<tr>
	<th>패스워드</th>
	<td><input type="text" name="pw" id="pw">
	
	</td>
</tr>
<tr style="text-align: center;">
	<td colspan="2"><input type="submit" value="전송" >
					<input type="reset" value="취소" >
	</td>
</tr>
</table>
</form>
</body>
</html>