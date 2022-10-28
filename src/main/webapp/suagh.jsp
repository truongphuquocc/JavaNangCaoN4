<%@page import="Bo.giohangbo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<%
		String msach=request.getParameter("masach");
		String sl=request.getParameter("txtsl");
		

			giohangbo gh=(giohangbo) session.getAttribute("gio");
		if(msach != null ) {
			if(request.getParameter("btnSua")!=null)
			{
				gh.Sua(msach, Long.parseLong(sl));
				session.setAttribute("gio", gh);
				response.sendRedirect("htgio.jsp");

			}
			
			
			
			if (request.getParameter("btnXoa") != null) {
				gh.Xoa(msach);
				session.setAttribute("gio", gh);
				response.sendRedirect("htgio.jsp");
				

			}
			
/* 			if(request.getParameter("btnXoaAll")!=null)
			{
				gh.XoaALL();
				session.setAttribute("gio", gh);
				response.sendRedirect("htgio.jsp");
			} */
			
			
		}
  		else
		{
  		/* 	giohangbo gh=(giohangbo)session.getAttribute("gio"); */
  			gh.XoaALL();
  			session.removeAttribute("gio");
  			response.sendRedirect("sach.jsp");
		} 
			
	%> --%>

	<%
	/*  	Enumeration<String> d = request.getParameterNames();
		while (d.hasMoreElements()) {
			String tendk = d.nextElement();
			if (request.getParameter(tendk) != null) {
		String gt = request.getParameter(tendk);
		out.println(tendk + ":" + gt + "<br>");			
			}
		}
		out.println("<hr>");  */


	giohangbo gh = (giohangbo) session.getAttribute("gio");

	if (request.getParameter("btnSua") != null) {
		String masach = request.getParameter("btnSua");
		String tentb = "t" + masach;
		long sl = Long.parseLong(request.getParameter(tentb));
		if (sl == 0)
			gh.Xoa(masach);
		else
			gh.Sua(masach, sl);
		session.setAttribute("gio", gh);
		response.sendRedirect("htgio.jsp");
	}

	if (request.getParameter("btnXoa") != null) {
		String masach = request.getParameter("btnXoa");
		gh.Xoa(masach);
		if(masach == null) {
			
			response.sendRedirect("sach.jsp");
		}
			session.setAttribute("gio", gh);
			response.sendRedirect("htgio.jsp");
		
		
	}
	
	if (request.getParameter("btnXoaCheck") != null) {
		String[] gtcheck = request.getParameterValues("check");
		if (gtcheck != null) {
			for (String ss : gtcheck)
		gh.Xoa(ss);
		}
		session.setAttribute("gio", gh);
		response.sendRedirect("htgio.jsp");
	}

	if (request.getParameter("btnXoaAll") != null) {
		gh.XoaALL();
		session.setAttribute("gio", gh);
		response.sendRedirect("sach.jsp");
	}


	%>

</body>
</html>