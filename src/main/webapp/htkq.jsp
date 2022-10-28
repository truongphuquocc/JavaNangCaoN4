<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   String ngay=request.getParameter("sngay");
	String thang=request.getParameter("sthang");
	String nam=request.getParameter("snam");
	
%>
Ket qua xo so ngay: <%=ngay %>/<%=thang %>/<%=nam %> 
<hr>
Giai Độc đắc:     <%int kq = (int) Math.floor(((Math.random() * 899999) + 100000)); %>
		<%=kq %>
</body>
</html>
