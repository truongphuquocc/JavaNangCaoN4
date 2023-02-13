<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.giohangbean"%>
<%@page import="Bo.giohangbo"%>
<%@page import="Bean.sachbean"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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

	<form action="HTGioHangController" method="post">
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
									class="text-body" href="SachController?ml=${l.getMaloai()}">
										${l.getTenloai()} </a></li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>
			<div class="col-10">
				<div class="ml-auto mr-auto mt-3"
					style="width: 1200px; height: 1200px;">
					<c:if test="${sessionScope.gio.getall().size() > 0 }">
						<div class="p-3 rounded" style="background: white; height: auto">

							<table class="table table-striped">
								<thead>
									<tr class="text-center text-white" style="background: #cf111a">
										<th class="col-md-1"></th>
										<th class="col-md-1">Mã sách</th>
										<th class="col-md-3">Tên sách</th>
										<th class="col-md-1">Giá</th>
										<th class="col-md-1">Số lượng</th>
										<th class="col-md-2"></th>
										<th class="col-md-2">Thành Tiền</th>
										<th class="col-md-1"></th>
									</tr>
								</thead>
								<%-- 				<%
							giohangbo gh = (giohangbo) session.getAttribute("gio");
							if (gh != null) {
							  for (giohangbean s : gh.ds) {
							%> --%>
								<tbody>

									<c:forEach items="${sessionScope.gio.getall() }" var="item">

										<tr>

											<td class="text-center"><input type="checkbox"
												name="check" value="${item.masach }"
												class="form-check-input"></td>
											<td>${item.masach }</td>
											<td>${item.tensach}</td>
											<td>${item.gia }</td>
											<td>${item.soluong }</td>
											<td class="">


												<div class="input-group">
													<input min="0" name="t${item.masach }" type="number"
														value="${item.soluong }" class="form-control"
														style="width: 60px">
													<button name="btnSua" value="${item.masach }" type="submit"
														class="btn btn-primary">Sửa</button>
												</div>


											</td>
											<td class=" text-right">${item.thanhtien }đ</td>
											<td class=" text-right">

												<button type="submit" value="${item.masach }" name="btnXoa"
													class="btn btn-warning" style="color: white">
													<i class="fa-solid fa-trash"></i>
												</button>

											</td>
										</tr>

									</c:forEach>
								</tbody>
								<%-- 							<%
							}
							}
							%> --%>

								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td class=" text-right">Tổng tiền:
										${sessionScope.gio.Tongtien() } đ</td>
								<tr>
							</table>


						</div>

						<div
							class="d-flex align-items-center justify-content-center rounded mt-3"
							style="background: white;">
							<div class="d-flex">
								<div class="m-3">
									<a href="SachController" class="btn btn-info">Tiếp Tục Mua
										Hàng</a>
								</div>
								<button type="submit" name="btnXoaCheck"
									class="btn btn-warning m-3" style="color: white;">
									<i class="fa-solid fa-trash mr-1"></i>Xoá tất cả
								</button>
								<div class="m-3">
									<button name="btnXoaAll" type="submit" class="btn btn-warning"
										style="color: white">Xoá Tất Cả</button>
								</div>

								<div class="m-3">
									<button formaction="HTGioHangController/confirm"
										formmethod="post" name="buy" type="submit"
										class="btn btn-info" style="background-color: #CF111A">Thanh
										Toán</button>
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
							<p style="font-size: 14px; margin: 20px 0;">Chưa có sản phẩm
								trong giỏ hàng của bạn.</p>
								<div class="m-3">
									<a href="SachController" class="btn btn-danger">Mua sắm ngay</a>
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
