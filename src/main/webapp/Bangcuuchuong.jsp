<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String n = request.getParameter("input"); %>
	<form action="Bangcuuchuong.jsp" method="post">
		<input name="submit" type="submit" value="nhap so"> <input
			name="input" type="number" value = <%=n %>>
		<%
		if (n == null)
			out.print("Ban chay dau tien");
		else {
		%>

		<table>

			<%
			for (int i = 1; i <= 10; i++) {
			%>
			<tr>
				<td><%=Integer.parseInt(n)%>x<%=i%>=<%=i * Integer.parseInt(n)%>

				</td>
				<%
				}
				%>
			</tr>

		</table>
		<%
		}
		%>
	</form>
</body>
</html>