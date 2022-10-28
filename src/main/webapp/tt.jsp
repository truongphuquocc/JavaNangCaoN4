<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%String sv = request.getParameter("masv"); 
	if(sv.equals("sv1"))
		out.print("Thong tin cua sv: nguyen van a");
	else if(sv.equals("sv2"))
		out.print("Thong tin cua sv: nguyen van b");
	if(sv.equals("sv3"))
		out.print("Thong tin cua sv: nguyen van c");
	%>
</body>
</html>