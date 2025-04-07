<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="top.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="600px" align="center">
	<tr>
		<th>도서번호</th><th>도서명</th><th>저자명</th><th>출판일자</th><th>가격</th><th>도서표지</th><th>조회수</th><th>비고</th>
	</tr>
	
		<c:forEach items="${list }" var="my">
			<tr>
			<td>${my.bnumber }</td>
			<td>
			<a href="contup?num=${my.bnumber }">${my.bname }
			</a></td>
			<td>${my.name }</td>
			<td><fmt:formatDate value="${my.bdate}" pattern="yyyy-MM-dd (E)"/> </td>
			<td><fmt:formatNumber value="${my.bprice}" pattern="#,##0" ></fmt:formatNumber>원</td>
			<td><img src="./image/${my.bimage }" width="50px" height="30px"></td>
			<td>${my.bcnt}</td>
			<td><a href="update?num=${my.bnumber }&bimage=${my.bimage }">수정
				<a href="delete?num=${my.bnumber }">|삭제</a></a></td>
				
			</tr>
		</c:forEach>
<!-- 페이징처리 555555-->
<tr style="border-left: none;border-right: none;border-bottom: none">
   <td colspan="8" style="text-align: center;">
   
   <c:if test="${paging.startPage!=1 }">
      <a href="out?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}"></a>
   </c:if>   
      <c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="p"> 
         <c:choose>
            <c:when test="${p == paging.nowPage }">
               <b><span style="color: red;">${p}</span></b>
            </c:when>   
            <c:when test="${p != paging.nowPage }">
               <a href="out?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
            </c:when>   
         </c:choose>
      </c:forEach>      
      <c:if test="${paging.endPage != paging.lastPage}">
   <a href="out?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">  </a>
   </c:if>   
   </td>
</tr>
<!-- 페이징처리 5555555-->	
</table>
</body>
</html>