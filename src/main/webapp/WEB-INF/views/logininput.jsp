<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#idcheck").click(function() {
        var id = $("#id").val(); // id값을 제대로 가져오려면 #id로 수정해야 합니다.
        $.ajax({
            type: "POST", 
            async: true,  
            url: "idgo",
            data: { "id": id },
            success: function(res) {
                if (res == "ok") { // 조건문을 중괄호로 감쌈
                    alert("사용가능 id");
                } else { // else 구문도 중괄호로 감쌈
                    alert("사용불가 id");
                }
            }
        });
    });
});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<table border="2" width="450px" align="center">
<caption>회원가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="id" id="id">
	<input type="button" value="중복체크" id="idcheck"></td>
</tr>	
<tr>
	<th>패스워드</th>
	<td><input type="text" name="pw" id="pw">
	
	</td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="name"></td>
</tr>
<tr>
	<th>나이</th>
	<td><input type="number" name="age"></td>
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