<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Calendar c= Calendar.getInstance();
  int ngay=c.get(Calendar.DAY_OF_MONTH);
  int thang=c.get(Calendar.MONTH)+1;
  int nam=c.get(Calendar.YEAR);
  int code = (int) Math.floor(((Math.random() * 899999) + 100000));
%>
 <div align="right">
   Hom nay, ngay <%=ngay %> thang <%=thang %> nam <%=nam %>
  </div>
  <hr>

<form action="htkq.jsp" method="get">
   Chon ngay:
    <select name="sngay">
    <%for(int i=1;i<=31;i++){ %>
         <option <%=(ngay==i?"selected":"") %>> <%=i %> </option>
         <%} %>
    </select>
    Chon thang:
    <select name="sthang">
        <%for(int i=1;i<=12;i++){ %>
         <option value="<%=i * i %>" <%=(thang==i?"selected":"") %>> <%=i %> </option>
         <%} %>
    </select>
    Chon nam:
    <select name="snam">
         <%for(int i=nam-10;i<=nam;i++){ %>
         <option <%=(ngay==i?"selected":"") %>> <%=i %> </option>
         <%} %>
    </select>
    <input name="but1" type="submit" value="xem ket qua">
    <%int kq = (int) Math.floor(((Math.random() * 899999) + 100000)); %>
		<%=kq %>
</form>
</body>
</html>


