<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utfoưi-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<style>

body{
background: url(Login_bg_lg.png) repeat-x;
    background-color: #006EB7;
    height: 100vh;
    overflow: hidden;
	
}

html {
	font-family: sans-serif;
}

*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	
}

.homepage {
	display: flex;
	justify-content: center;	
	margin: auto;
	
	
}

.homepage__image{

}

.homepage__image-logo{

}

.homepage__image-logo img{
	width: 112px;
	height: 112px;
	margin-top: 50px;
}

.homepage__image-des img{
	margin-top: 70px;
}

.authen-form {
	width: 350px;
	
}

.authen-form__logo {
    position: absolute;
	border: 5px solid #fff;
    border-radius: 50%;
    top: -30px;
    right: 20px;
}

.authen-form__signin {
	width: 320px;
    border: 5px solid #6bb9f0;
    background: #f7f7f7;
    padding: 15px;
    height: 370px;
    margin-left: 118px;
    margin-top: 205px;
    position: relative;
}

.authen-form__header {
	text-decoration: none;
	font-size: 25px;
	font-weight: bold;
	color: #006eb7;
	margin: 30px 0;
}

.authen-form__group{
  display: flex;
  margin-bottom: 16px;
  flex-direction: column;
}

.authen-form__lable{
	margin-bottom: 5px;
	font-weight: bold;	
}

.authen-form__input{
  height: 40px;
  padding: 8px 12px;
  border: 1px solid #b3b3b3;
  border-radius: 3px;
  outline: none;
  font-size: 16px;
}

.authen-form__input:focus {
	border-color: #66afe9;
    box-shadow: inset 0 1px 1px rgb(0 0 0 / 8%), 0 0 8px rgb(102 175 233 / 60%);
}

.authen-form__submit {
  outline: none;
  background-color: #337ab7;
  margin-top: 12px;
  padding: 12px 16px;
  border: none;
  width: 100%;
  color: #fff;
  font-size: 16px;
  border-radius: 8px;
  cursor: pointer;	
}

.authen-form__submit:hover {
	background-color: #7fbbe4;
	cusor: poiter;
}
.fotter {
	padding-top: 50px;
	
}

.fotter__text {
	display: flex;
	flex-direction: column;
	text-align: center;
	font-size: 16px;
}

.fotter__text p {
	margin: 5px 0;
	color: #fff;
}

.fotter__text p a {
	text-decoration: none;
	color: #fff;
}


</style>
<body>
	<div class="homepage">
		<div class="homepage__image">
			<div class="homepage__image-logo">
				<a>
					<img alt="" src="logo.png">
				</a>
			</div>
			<div class="homepage__image-des">
				<img src="image1.png">
			</div>
		</div>
		<div class="authen-form">
			<form class="authen-form__signin">
				<div class="authen-form__logo">
					<img alt="" src="logo-small.png">
				</div>
				<h2 class="authen-form__header">SINH VIÊN</h2>
				<div class="authen-form__group">
					<lable class="authen-form__lable">
						Mã sinh viên
					</lable>
     				<input id="masinhvien" name="masinhvien" type="text" placeholder="Mã sinh viên" class="authen-form__input">
				</div>
				<div class="authen-form__group">
					<lable class="authen-form__lable">
						Mật khẩu:
					</lable>
     				<input id="password" name="password" type="password" placeholder="Mật khẩu" class="authen-form__input">
				</div>
				<button class="authen-form__submit">Đăng nhập</button>
			</form>
		</div>
	</div>
	<footer class="fotter">
		<div class="fotter__text">
			<p>
				<a href="#">
					Trường Đại học Khoa học, Đại học Huế
				</a>
			</p>
			<p>
 				77 Nguyễn Huệ, Thành phố Huế, Tỉnh Thừa Thiên Huế, Việt Nam
			</p>
			<p>
				Điện thoại: (+84) 0234.3823290 – Fax: (+84) 0234.3824901
			</p>			
		</div>
	</footer>
</body>
</html>