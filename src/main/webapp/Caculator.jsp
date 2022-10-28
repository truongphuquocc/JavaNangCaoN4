<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <style>
 @import url('https://fonts.googleapis.com/css2?family=Orbitron&display=swap');
 
 
 *{
 	margin: 0;
 	padding: 0;
 	box-sizing: border-box;
 }
 
 html {
 	font-family: 'Orbitron', sans-serif;
 }
 
 body {
 	height: 100vh;
	background: linear-gradient(45deg, #00853e, #50c878);
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Roboto,Arial,Tahoma,Helvetica,Verdana;
 }
 
 .calculator {
	
    padding: 10px;
    border-radius: 1em;
    height: auto;
    width: 500px;
    margin: auto;
    background-color: #191b28;
    box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    position: relative;
    
}

.wrapper {
}

.row1 {
	display: flex;
	justify-content: space-between;
	margin-bottom: 50px;
}

.row {
	display: flex;
	justify-content: space-between;
}

input {
	outline: none;
	border: none;
}

.input {
	width: 235px;
	height: 40px;
	border-radius: 6px;
	font-size: 24px;
	padding-left: 10px; 
	
	
}

input:focus {
	border: 2px solid #4CAF50;
	background-color: #91C1EE;
}

.result {
	width: 100%;
	height: 40px;
	margin: 10px 0;
	border-radius: 6px;
	font-size: 24px;
	padding-left: 10px; 
	cursor: none;
	position: absolute;
	top: 30%;
	width: calc(100% - 20px);
}

.result:disabled {
	background-color: field;
	color: black;
}

.operator {
	width: 114px;
	text-align: center;
	height: 40px;
	border-radius: 6px;
	font-size: 24px;
  	background-color: white; 
  	color: black; 
  	border: 2px solid #4CAF50;
    cursor: pointer;
}

.operator:hover {
	background-color: #4CAF50;
  	color: white;
}

.mg-t {
	margin-top: 10px;
}

.hide {
	display: none;
}
</style>
<body>
		<%String num_1 = request.getParameter("num_1"); %>
		<%String num_2 = request.getParameter("num_2"); %>
		<%String sum = request.getParameter("sum"); %>
		<%double Tong = 0; %>

<div class="calculator">
	<form method="post" class = "wrapper">
		
		<div class="row1">
			<input class="input" name="num_1" type="number" value = <%=num_1 %>>
			<input class="input" name="num_2" type="number" value = <%=num_2 %>>
		</div>
		
		<div class="row mg-t">
			<input name="sum" class="operator" type="submit" value="+">
			<input name="sum" class="operator" type="submit" value="-">
			<input name="sum" class="operator" type="submit" value="*">
			<input name="sum" class="operator" type="submit" value="/">
		</div>

		<!-- <div class="row mg-t">
			<input name="num" class="operator" type="submit" value="1">
			<input name="num" class="operator" type="submit" value="2">
			<input name="num" class="operator" type="submit" value="3">
			<input name="sum" class="operator" type="submit" value="+">
		</div>
		<div class="row mg-t">
			<input name="num" class="operator" type="submit" value="4">
			<input name="num" class="operator" type="submit" value="5">
			<input name="num" class="operator" type="submit" value="6">
			<input name="sum" class="operator" type="submit" value="-">
		</div>
		<div class="row mg-t">
			<input name="num" class="operator" type="submit" value="7">
			<input name="num" class="operator" type="submit" value="8">
			<input name="num" class="operator" type="submit" value="9">
			<input name="sum" class="operator" type="submit" value="*">
		</div>
		<div class="row mg-t">
			<input name="num" class="operator" type="submit" value="+/-">
			<input name="num" class="operator" type="submit" value=".">
			<input name="num" class="operator" type="submit" value="0">
			<input name="sum" class="operator" type="submit" value="/">
		</div> -->
		
		<%
		if (num_1 == null && num_2 == null)
			out.print("");
		else {
			
		%>
		<%if(sum.equals("+"))
			Tong = Integer.parseInt(num_1) + Integer.parseInt(num_2);
		else if(sum.equals("-"))
			Tong = Integer.parseInt(num_1) - Integer.parseInt(num_2);
		else if(sum.equals("*"))
			Tong = Integer.parseInt(num_1) * Integer.parseInt(num_2);
		else
			Tong = Integer.parseInt(num_1) / Integer.parseInt(num_2);
		%>
				
		<%} %>
		
		<input class="result" name = "t1" type = "number" value = <%=Tong %> disabled>
	</form>
			


</div>	
</body>
</html>