<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"
/>
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

body {
	height: 100vh;
	background: linear-gradient(45deg, #00853e, #50c878);
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Roboto,Arial,Tahoma,Helvetica,Verdana;
}

.modal {
	width: 800px;
	height: auto;
	background-color: #fff;
}

.modal__title {
	width: 100%;
	height: 40px;
	background-color: #1a83d2;
	display: flex;
	justify-content: space-between;
	padding: 10px 10px;
	font-weight: bold;
	font-size: 16px;
}

.modal__title span {
	color: #fff;
}

.modal__title i {
	color: #fff;
	cursor: pointer;
}

.modal__body {
	padding: 15px 15px;
}

.modal__body-title {
	font-size: 16px;
	display: flex;
	align-items: center;
	justify-content: flex-start;
}

.bulle__icon {
	font-size: 7px;
	margin-right: 8px;
}

.login-social {
	display: flex;
	justify-content: space-between;
	padding: 5px 5px;
	margin-left: 3px;
}

.login-social__facebook {
	width: 280px;
	height: 45px;
	background-color: #3c5a9a;
	display: flex;
	align-items: center;
	justify-content: center;
	font-weight: bold;
	font-size: 18px;
	color: #fff;
	overflow: hidden;
	cursor: pointer;
	border-radius: 5px;
	align-items: center;
}

.tips {
	background-color: #f5fbff;
	width: 302px;
	height: 68px;
	border: 1px dashed #01B5E6;
	border-radius: 5px;
	font-size: 12px;
}

.tips li {
	line-height: 20px;
	list-style-type: none;
}

.tips li a {
	text-decoration: none;
	color: #1A83D2;
	font-weight: 600;
}

.authen-form {
	margin-top: 6px;
	font-size: 12px;
}

.authen-form__group {
	margin-bottom: 10px;
}

.mg-t {
	margin-top: 10px;
}

.authen-form__input {
	width: 300px;
	height: 30px;
	padding: 8px 12px;
	margin-right: 10px;
	border: 1px solid #b3b3b3;
	border-radius: 3px;
	outline: none;
	font-size: 16px;
}

.authen-form__option {
	width: 75px;
	height: 30px;
	padding: 4px 8px;
	margin-right: 10px;
	border: 1px solid #b3b3b3;
	border-radius: 3px;
	outline: none;
	font-size: 14px;
}

.authen-form__control {
	display: flex;
	flex-direction: row;
}

.btn {
	width: 80px;
	height: 40px;
	background-color: #5DB1FF;
	outline: none;
	border: none;
	border-radius: 5px;
	color: #fff;
	font-size: 12px;
	border-radius: 8px;
	cursor: pointer;
	font-weight: bold;
}

.authen-form__aside {
	margin-left: 2px;
	display: flex;
	align-items: center;
	justify-content: flex-start;
}

.authen-form__policy--check {
	
}

.authen-form__policy--text a {
	text-decoration: none;
	color: #0080AF;
}

.modal__fotter {
	display: flex;
	justify-content: space-around;
	margin: 10px;
	width: 100%;
}

.footer--list {
	flex-direction: row;
	list-style-type: none;
	font-size: 12px;
	
}

.footer--list li {
	padding-left: 5px;
}

.footer--list:nth-child(2) li {
	border-left: 1px solid #BBD0D7; 
	border-right: 1px solid #BBD0D7; 	
	
}


</style>

<body>
	<div class="modal">
		<div class="modal__title">
			<span>ĐĂNG KÝ</span> <i class="fa-solid fa-xmark"></i>
		</div>
		<div class="modal__body">
			<p class="modal__body-title">
				<i class="bulle__icon fa-solid fa-circle"></i></i> Đăng ký nhanh qua
				Facebook
			</p>
			<div class="login-social">
				<div class="login-social__facebook">
					<a class="login-social__facebook--link"> <i
						class=" fa-brands fa-facebook"
					></i> <span class="authen-form__socials-title"> Kết nối với
							Facebook </span>
					</a>
				</div>
				<div class="tips">
					<ul>
						<li>Thưởng ngay <span class="tips--red">50</span> ePoints khi
							đăng ký mới & <span class="tips--red">5</span> ePoints cho mỗi
							lượt chia sẻ Facebook
						</li>
						<li>Tích lũy nhiều ePoints khi Upload tài liệu <a href="#">>></a>
						</li>
					</ul>
				</div>
			</div>
			<p
				style="font-weight: 700; color: #0080AF; cursor: pointer; padding-left: 6px"
			>Đăng ký mới bằng tài khoản TaiLieu.VN</p>

			<div class="authen-form">
				<div class="auth-form__container">
					<p class="authen-form__header">Bạn cần kích hoạt tài khoản qua
						Email sau khi đăng ký để nhận ngay 50 ePoints thưởng từ TaiLieu.VN</p>
					<div class="authen-form__form">
						<div class="authen-form__group mg-t">
							<input type="text" class="authen-form__input"
								placeholder="Nhập email"
							> <input type="text" class="authen-form__input"
								placeholder="Nhập email"
							>
						</div>
						<div class="authen-form__group">
							<input type="text" class="authen-form__input"
								placeholder="Nhập email"
							> <select id="cars" class="authen-form__option">
								<option value="volvo">Volvo</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select>
						</div>

						<div class="authen-form__group">
							<input type="text" class="authen-form__input"
								placeholder="Nhập email"
							> <select id="cars" class="authen-form__option">
								<option value="volvo">Volvo</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select> <select id="cars" class="authen-form__option">
								<option value="volvo">Volvo</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select> <select id="cars" class="authen-form__option">
								<option value="volvo">Volvo</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select>

						</div>
						<div class="authen-form__group">
							<input type="text" class="authen-form__input"
								placeholder="Nhập email"
							> <select id="cars" class="authen-form__option">
								<option value="volvo">Volvo</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select>
						</div>
					</div>

					<div class="authen-form__control">
						<button class="btn btn--primary">ĐĂNG KÝ</button>
						<div class="authen-form__aside">
							<input class="authen-form__policy--check" type="checkbox"
								name="vehicle1" value="Bike"
							> <span class="authen-form__policy--text">Tôi đồng ý với
								các Chính Sách và Thỏa Thuận Sử Dụng của TaiLieu.VN</span>
						</div>
					</div>
					<span
						style="border-bottom: 1px dashed #cecece; width: 750px; float: left; margin-top: 5px;"
					></span>	

					<p
						style="font-weight: 700; color: #0080AF; cursor: pointer; padding-left: 6px; margin-top: 5px;"
					>Bạn đã có tài khoản TaiLieu.VN? Đăng nhập</p>

					<div class="authen-form__form">
						<div class="authen-form__group mg-t">
							<input type="text" class="authen-form__input"
								placeholder="Nhập email"
							> <input type="text" class="authen-form__input"
								placeholder="Nhập email"
							>
						</div>
					</div>
					
					<div class="authen-form__control">
						<button class="btn btn--primary">Đăng nhập</button>
						<div class="authen-form__aside">
							<input class="authen-form__policy--check" type="checkbox"
								name="vehicle1" value="Bike"
							> <span class="authen-form__policy--text">Nhớ mật khẩu <span>|</span> 
								<a href="#">Quên mật khẩu</a>
							 </span>
						</div>
					</div>
				</div>
			</div>
		<div class="modal__fotter">
			<ul class="footer--list">
				<li>
					<p>Thưởng 50 ePoints khi đăng ký mới</p>
					<p>Tặng 5 ePoints cho mỗi lượt chia sẻ Facebook</p>
				</li>
			</ul>
			<ul class="footer--list">
				<li>
					<p>Xem và Tải trên <span>1 triệu</span> Triệu Tài Liệu miễn phí</p>
					<p>Kết nối <span>5 triệu</span> Thành Viên <a>TaiLieu.VN</a></p>
				</li>
			</ul>			
			<ul class="footer--list">
				<li>
					<p>Kết bạn với <a>TaiLieu.VN</a> trên <a>Facebook</a></p>
					<p>để nhận link download miễn phí <span>100</span> tài liệu <span>HOT</span> mỗi ngày</p>
				</li>
			</ul>			
			
		</div>
		</div>
	</div>
</body>
</html>