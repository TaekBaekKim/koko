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
<form action="updatego" method="post" enctype="multipart/form-data">
<table border="2" width="450px" align="center">

 <tr>
 	<td><input type="hidden" name="num" value="${dto.bnumber }" readonly></td>
 </tr>
 <tr>
 	<th>도서명</th>
 	<td><input type="text" name="bname" value="${dto.bnumber }"></td>
 </tr>
 <tr>
 	<th>저자명</th>
 	<td><input type="text" name="name" value="${dto.name }"></td>
 </tr>
 <tr>
 	<th>출판일자</th>
 	<td><input type="date" name="bdate" value="${dto.bdate }"></td>
 </tr>
 <tr>
 	<th>가격</th>
 	<td><input type="number" name="bprice" value="${dto.bprice }"></td>
 </tr>
 <tr>
 	<th>도서 조회수</th>
 	<td><input type="number" name="bcnt" value="${dto.bcnt }"></td>
 </tr>
 <tr>
 	<th>도서표지</th>
 	<td><input type="file" name="bimage" value="${dto.bimage }">
 		<img src="./image${dto.bimage }" width="50px" height="30px">
 	</td>
 </tr>
 <tr>
	<td>
	<input type="hidden" name="himage" value="${dto.bimage }">
	</td>
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