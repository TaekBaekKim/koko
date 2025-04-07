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
<form action="save" method="post" enctype="multipart/form-data">
<table border="2" width="450px" align="center">
 <tr>
 	<th>도서명</th>
 	<td><input type="text" name="bname"></td>
 </tr>
 <tr>
 	<th>저자명</th>
 	<td><input type="text" name="name"></td>
 </tr>
 <tr>
 	<th>출판일자</th>
 	<td><input type="date" name="bdate"></td>
 </tr>
 <tr>
 	<th>가격</th>
 	<td><input type="number" name="bprice"></td>
 </tr>
 <tr>
 	<th>도서표지</th>
 	<td><input type="file" name="bimage"></td>
 </tr>
 <tr style="text-align: center;">
 	<td><input type="submit" value ="전송">
 		<input type="reset" value ="취소">
 	</td>
 </tr>
</table>
</form>
</body>
</html>