<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test.jsp" method="post">
 <input name="txttk" type="text"> <br>
  <input name="butt" type="submit" value="Tong">
</form>
<%
	String nn = request.getParameter("txttk");

	if(session.getAttribute("ss") == null)
		session.setAttribute("ss", (int) 0);
	if(nn != null) {
		int n = Integer.parseInt(nn);
		
		int s = (int) session.getAttribute("ss");
		
		s = s + n;
		session.setAttribute("ss", s);
		out.print("Tong: "+s);
	}
%>
</body>
</html>