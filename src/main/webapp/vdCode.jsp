<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="width: 100%; font-size: 24px">
   <%for(int i=1;i<=10;i++){ %>
   		<tr>
   		 <%for(int j=1; j<=10;j++){ %>
	   		<td>
	   		    <%=j %>x<%=i %>=<%=i*j %>
	   		    
	   		</td>
	   	<%} %>	
   		</tr>
          
    <%} %>
    </table>
</body>
</html>