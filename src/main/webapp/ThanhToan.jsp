<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.giohangbean"%>
<%@page import="Bo.giohangbo"%>
<%@page import="Bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
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
<base href="/JavaNangCaoNhom4/">
</head>

<style>
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
					<li class="nav-item account"><c:choose>
							<c:when test="${sessionScope.hoten == null }">
								<a class="nav-link text-dark text-uppercase"
									href="DangNhapController" style="display: inline-block"> <i
									class="fa fa-user"></i>Login
								</a>
							</c:when>

							<c:otherwise>
								<a class="nav-link text-dark text-uppercase" href="#"
									style="display: inline-block"> <i class="fa fa-user"></i>Hi:
									${sessionScope.hoten.getHoten() }
								</a>
							</c:otherwise>
						</c:choose></li>
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

	<form action="HTGioHangController" method="post">
		<div class="row">
			<div class="col-12">
				<div class="ml-auto mr-auto mt-3"
					style="width: 1200px; height: 1200px;">
<c:if test="${sessionScope.gio.getall().size() > 0 }">
					<div class="p-3" style="background: white; height: auto">

						<table class="table table-bordered table-striped">
							<thead>
								<tr class="text-center text-white" style="background: #cf111a">

									<th class="col-md-1">Mã sách</th>
									<th class="col-md-3">Tên sách</th>
									<th class="col-md-1">Giá</th>
									<th class="col-md-1">Số lượng</th>
									<th class="col-md-2">Thành Tiền</th>


								</tr>
							</thead>
							<%-- 							<%
							giohangbo gh = (giohangbo) session.getAttribute("gio");
							if (gh != null) {
								for (giohangbean s : gh.ds) {
							%> --%>
							<c:forEach items="${sessionScope.gio.getall() }" var="item">
								<tbody>

									<tr>
										<td>${item.masach }</td>
										<td>${item.tensach }</td>
										<td>${item.gia }</td>
										<td>${item.soluong }</td>
										<td class=" text-right">${item.thanhtien }đ</td>
									</tr>


								</tbody>
							</c:forEach>
							<%-- 					<%
							}
							}
							%> --%>

							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class=" text-right">Tổng tiềng
									${sessionScope.gio.Tongtien() }</td>
							<tr>
						</table>


					</div>

					<div
						class="sticky-bottom d-flex align-items-center justify-content-center rounded mt-3"
						style="background: white;">
						<div class="d-flex">
							<div class="m-3">
								<button formaction="ThanhToanController/xacnhan"
									formmethod="post" type="submit" class="btn btn-info"
									style="background-color: #CF111A">Xác nhận thanh toán</button>
							</div>
						</div>
					</div>
					</c:if>
					<c:if test="${sessionScope.gio.getall().size() == 0 }">
						<div class="cart-empty body-mh-300 p-3 rounded"
							style="justify-content: center; background: white; display: flex; align-items: center;">
							<div style="text-align: center">
								<div class="icon-empty-cart">
									<img
										src="https://cdn0.fahasa.com/skin//frontend/ma_vanese/fahasa/images/checkout_cart/ico_emptycart.svg"
										class="center">
								</div>
								<p style="font-size: 14px; margin: 20px 0;">Chưa có sản phẩm nào để thanh toán.</p>
								<div class="m-3">
									<a href="SachController" class="btn btn-danger">Mua sắm
										ngay</a>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
