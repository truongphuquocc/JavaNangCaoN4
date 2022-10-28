<%@page import="Bo.sachbo"%>
<%@page import="Bean.loaibean"%>
<%@page import="Bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.loaibo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./Css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<style>
body {
	overflow-x: hidden;
	font-family: 'Montserrat', sans-serif;
	color: #616971;
	background-color: #f5f5f5;
}

.card {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	-ms-flex-direction: column;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 1px solid rgba(0, 0, 0, .125);
	border-radius: .1875rem;
}

.card-img-actions {
	position: relative;
}

.card-body {
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	padding: 1.25rem;
	text-align: center;
}

.card-img {
	width: 350px;
}

.star {
	color: red;
}

.bg-cart {
	background-color: orange;
	color: #fff;
}

.bg-cart:hover {
	color: #fff;
}

.bg-buy {
	background-color: green;
	color: #fff;
	padding-right: 29px;
}

.bg-buy:hover {
	color: #fff;
}

a {
	text-decoration: none !important;
}

.box-primary {
	border-top-color: #3c8dbc !important;
}

.box {
	position: relative;
	margin-bottom: 20px;
	width: 100%;
	box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 1px;
	border-radius: 3px;
	background: rgb(255, 255, 255);
	border-top: 3px solid rgb(210, 214, 222);
}

#navbar2 {
	position: fixed;
	width: 100%;
}

.duoinavbar {
	background-color: #CF111A;
}

h4.card-title {
	font-weight: 400;
	margin-bottom: 4px;
	font-size: 15px;
	height: 35px;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	transition: 0.3s;
}

.ptthanhtoan {
	width: 200px;
}

footer .row a {
	text-decoration: none;
	display: block;
	color: black;
	transition: 0.3s;
	padding-bottom: 5px;
	font-size: 14px;
}

footer .row a:hover {
	color: #F5A623;
}

footer .header {
	font-size: 14px;
	margin-bottom: 13px;
}

ul li {
	list-style-type: none;
}

.list-group-item-action:hover {
	background-color: #CF111A !important;
	text-decoration: none !important;
	color: white !important;
}

a:hover {
	text-decoration: none !important;
	color: white !important;
}

/* .box-body {
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    border-bottom-right-radius: 3px;
    border-bottom-left-radius: 3px;
    padding: 10px;
} */
</style>


<body>
	<%
	String un = request.getParameter("txtun");
	String pass = request.getParameter("txtpass");
	%>
	<nav
		class="navbar navbar_2 navbar-expand-md bg-white navbar-light fixed-top">
		<div class="container">

			<a class="navbar-brand" href="SachController" style="color: #CF111A;"><b>MinhKhai</b></a>

			<div class="collapse navbar-collapse" id="collapsibleNavId">

				<form class="form-inline ml-auto my-2 my-lg-0 mr-3"
					action="SachController" method="get">
					<div class="input-group" style="width: 520px;">
						<input name="txttk" type="text" class="form-control"
							aria-label="Small" placeholder="Nhập sách cần tìm kiếm...">
						<div class="input-group-append">
							<button name="butt" type="submit" class="btn"
								style="background-color: #CF111A; color: white;">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>

				<ul class="navbar-nav mb-1 ml-auto">
					<li class="nav-item"><a
						class="nav-link text-dark text-uppercase"
						href="DangNhapController"> <i
							class="fa-solid fa-right-from-bracket"></i> logout
					</a></li>

					<li class="nav-item account" type="button">
						<%
						if (session.getAttribute("dn") == null) {
						%> <a class="nav-link text-dark text-uppercase"
						href="DangNhapController" style="display: inline-block"> <i
							class="fa fa-user"></i>Login
					</a> <%
 } else {
 %> <a class="nav-link text-dark text-uppercase" href="#"
						style="display: inline-block"> <i class="fa fa-user"></i>Hi: <%=session.getAttribute("dn")%>
					</a> <%
 }
 %>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<nav class="duoinavbar navbar navbar-expand-lg navbar-dark mt-5">


		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-white"
					href="HTGioHangController">GIỎ HÀNG</a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-white" href="#">THANH
						TOÁN</a></li>
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-white" href="#">LỊCH SỬ
						MUA HÀNG</a></li>
			</ul>

			<ul class=" navbar-nav">

			</ul>
		</div>
	</nav>

	<div class="row">
		<div class="col-2">
			<div class="container">
				<div class="row" style="margin-right: -30px;">
					<ul class="list-group list-group-flush w-100 bg-white">
<%-- 												<%
						ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
						if (dsloai != null) {
						  for (loaibean l : dsloai) {
						%>

						<li class="list-group-item list-group-item-action"><a
							class="text-body" href="SachController?ml=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></li>
						<%
						}
						}
						%> --%>


						<c:forEach var="l" items="${dsloai}">
						<li class="list-group-item list-group-item-action"><a
							class="text-body"
								href="SachController?ml=${l.getMaloai()}">
								${l.getTenloai()}
							</a></li>
						</c:forEach>

					</ul>
				</div>
			</div>
		</div>

		<div class="col-10">

			<div class="row">
				<%
				ArrayList<sachbean> dssach = (ArrayList<sachbean>) request.getAttribute("dssach");
				if (dssach != null) {
				  int n = dssach.size();
				  for (int i = 0; i < n; i++) {
				    sachbean s = dssach.get(i);
				%>
				<div class="col-sm-3 mt-3" style="">

					<div class="card p-3" style="width: 18rem; height: 420px">
						<div class="d-flex justify-content-center">
							<img src="<%=s.getAnh()%>" class="card-img-top w-100" alt="..."
								style="max-width: 200px; max-height: 200px;">
						</div>
						<div class="mt-2" style="height: 140px;">
							<h5 class="card-title"><%=s.getTensacj()%></h5>
							<p class=""><%=s.getTacgia()%></p>
							<p class="" style="color: #CF111A"><%=s.getGia()%>
								đ
							</p>

						</div>
						<div class="d-flex justify-content-center" style="margin: auto">
							<a
								href="GioHangController?ms=<%=s.getMasach()%>&ts=<%=s.getTensacj()%>&gia=<%=s.getGia()%>"
								class="btn btn-primary" style="background: #CF111A">Them vao
								gio hang</a>
						</div>
					</div>

				</div>
				<%
				}
				}
				%>


			</div>
		</div>
	</div>

	<footer style="">
		<div class="container py-4">
			<div class="row">
				<div class="col-md-3 col-xs-6">
					<div class="gioithieu">
						<h3 class="header text-uppercase font-weight-bold">Về
							DealBook</h3>
						<a href="#">Giới thiệu về DealBook</a> <a href="#">Tuyển dụng</a>
						<div class="fb-like"
							data-href="https://www.facebook.com/DealBook-110745443947730/"
							data-width="300px" data-layout="button" data-action="like"
							data-size="small" data-share="true"></div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6">
					<div class="hotrokh">
						<h3 class="header text-uppercase font-weight-bold">HỖ TRỢ
							KHÁCH HÀNG</h3>
						<a href="#">Hướng dẫn đặt hàng</a> <a href="#">Phương thức
							thanh toán</a> <a href="#">Phương thức vận chuyển</a> <a href="#">Chính
							sách đổi trả</a>
					</div>
				</div>
				<div class="col-md-3 col-xs-6">
					<div class="lienket">
						<h3 class="header text-uppercase font-weight-bold">HỢP TÁC VÀ
							LIÊN KẾT</h3>

					</div>
				</div>
				<div class="col-md-3 col-xs-6">
					<div class="ptthanhtoan">
						<h3 class="header text-uppercase font-weight-bold">Phương
							thức thanh toán</h3>


					</div>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>
