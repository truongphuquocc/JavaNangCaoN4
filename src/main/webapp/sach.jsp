<%@page import="Bean.KhachHangBean"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bean.loaibean"%>
<%@page import="Bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.loaibo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

</head>

<style>
body {
	font-family: 'Montserrat', sans-serif;
	font-family: 'Poppins', sans-serif!important;
}
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
						href="DangXuatController"> <i
							class="fa-solid fa-right-from-bracket"></i> logout
					</a></li>

					<li class="nav-item account" type="button">
						<%
						if (session.getAttribute("hoten") == null) {
						%> <a class="nav-link text-dark text-uppercase"
						href="DangNhapController" style="display: inline-block"> <i
							class="fa fa-user"></i>Login
					</a> <%
 } else {
 KhachHangBean khbean = (KhachHangBean) session.getAttribute("hoten");
 %> <a class="nav-link text-dark text-uppercase" href="#"
						style="display: inline-block"> <i class="fa fa-user"></i>Hi: <%=khbean.getHoten()%>
					</a> <%
 }
 %>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<nav class="navbar navbar-expand-lg navbar-dark mt-5"
		style="background-color: #CF111A">
		<ul class="navbar-nav" style="margin-top: 10px;">
			<li class="nav-item d-flex align-items-center"><a
				class="nav-link font-weight-bold text-white"
				href="HTGioHangController">GIỎ HÀNG</a></li>
			<li class="nav-item"><a
				class="nav-link font-weight-bold text-white"
				href="ThanhToanController">THANH TOÁN</a></li>
			<c:if test="${sessionScope['hoten'] != null }">
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-white"
					href="LichSuMuaHangController">LỊCH SỬ MUA HÀNG</a></li>
			</c:if>
		</ul>

	</nav>

	<div class="row">

		<div class="col-2">
			<div style="margin-right: 0px;">
				<ul class="list-group list-group-flush w-100 bg-white">
					<c:forEach var="l" items="${dsloai}">
						<li class="list-group-item" style="padding-left: 40px"><a
							class="text-body" href="SachController?ml=${l.getMaloai()}">
								${l.getTenloai()} </a></li>
					</c:forEach>

				</ul>
			</div>
		</div>

		<div class="col-10">
			<div class="row">
				<c:forEach items="${dssach }" var="item">
					<div class="col-sm-3 mt-2" style="">

						<div class="card p-2" style="width: 18rem; height: 400px">
							<div class="d-flex justify-content-center">
								<img src="${item.anh }" class="card-img-top w-100" alt="..."
									style="max-width: 200px; max-height: 200px;">
							</div>
							<div class="mt-2" style="height: 100px;">
								<h6 class="card-title">${item.tensacj }</h6>
								<p class="">${item.tacgia }</p>

							</div>
							<span class="" style="color: #CF111A">${item.gia } vnđ</span>
							<div class="d-flex justify-content-center" style="margin: auto">
								<a
									href="GioHangController?ms=${item.masach }&ts=${item.tensacj }&gia=${item.gia }"
									class="btn btn-primary d-felx " style="background: #CF111A">
									<i class="fa-solid fa-cart-plus"></i> Thêm Vào Giỏ Hàng
								</a>
							</div>
						</div>

					</div>
				</c:forEach>



			</div>


			<c:if test="${endPage > 1 }">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="SachController?page=${Integer.parseInt(currentPage)-1}&ml=${mloai}&key=${keyTD}">Previous</a></li>
						<c:forEach begin="1" end="${endPage }" var="i">
							<li class="page-item ${i == currentPage ? 'active' : '' }"><a
								class="page-link"
								href="SachController?page=${i}&ml=${mloai}&key=${keyTD}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="SachController?page=${Integer.parseInt(currentPage)+1}&ml=${mloai}&key=${keyTD}">Next</a></li>
					</ul>
				</nav>
			</c:if>
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
							<h3 class="header text-uppercase font-weight-bold">HỢP TÁC
								VÀ LIÊN KẾT</h3>

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
