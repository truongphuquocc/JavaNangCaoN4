<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
  <table width="1000" border="1" align="center">
     <tr>
     	<td colspan="3" bgcolor="red"> Menu ngang </td>
     </tr>
     <tr>
     	<td valign="top" width="200"> 
     	    <a href="ht.jsp"> Trang chủ</a> <hr>
            <a href="http://docbao.vn"> Đọc báo</a><hr>
            <a href="tam.docx"> Tải bài giảng</a> <hr>
     	</td>
     	<td width="600">
     	    <img src="1.jpg" width="200">
     	    Noi dung <hr>Noi dung <hr>Noi dung <hr>Noi dung <hr>Noi dung <hr>Noi dung <hr> </td>
     	<td width="200"> <form action="ht.jsp" method="post"> 
     	  		 Ten dang nhap: <input name="txtun" type="text"> <br>
     			Mật khẩu: <input name="txtun1" type="password"> <br>
     			Tai anh: <input name="txtun2" type="file"> <br>
<input name="but1" type="submit" value="Đăng ký"> 
     			Comment<br>
     		<textarea rows="6" cols="10">
     		   Noi dung
     		</textarea> <br>
     		<select name="s1">
     		    <option> VN </option>
     		     <option selected="selected"> lAO </option>
     		      <option> TQ </option>
     		</select>
     	</form> </td>
     </tr>
 	 <tr>
     	<td colspan="3"> Ban quyen: .....</td>
     </tr>
  </table>
</body>
</html>

