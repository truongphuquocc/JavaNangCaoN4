<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
		<%String un = request.getParameter("un"); %>
		<%String pass = request.getParameter("pass"); %>
<form method="post" action="DangNhapController">
		
	<div class="row1"> 
		<input class="input" name="un" type="text">
		<input class="input" name="pass" type="password">
		<input class="name" name="but1" type="submit" value="login">
		<%
			if(request.getParameter("kt") != null) {
				out.print("dang nhap sai");
		}%>
	</div>	
</form>	
</body>
</html>