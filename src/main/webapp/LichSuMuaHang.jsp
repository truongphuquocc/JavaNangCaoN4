<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.LichSuMuaHangBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.giohangbean"%>
<%@page import="Bo.giohangbo"%>
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

			<div class="ml-auto mr-auto mt-3"
				style="width: 1200px; height: 1200px;">

				<div class="p-3" style="background: white; height: auto">

					<table class="table table-bordered table-striped">
						<thead>
							<tr class="text-center text-white" style="background: #cf111a">

								<th>Mã hoá đơn</th>
								<th>Tên sách</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<th>Ngày mua</th>
								<th>Thành tiền</th>
								<th>Trạng Thái</th>

							</tr>
						</thead>
						<%-- 						<%
						ArrayList<LichSuMuaHangBean> dslichsu = (ArrayList<LichSuMuaHangBean>) request.getAttribute("dslichsu");
						if (dslichsu != null) {
						  int n = dslichsu.size();
						  for (int i = 0; i < n; i++) {
						    LichSuMuaHangBean s = dslichsu.get(i);
						%> --%>
						<c:forEach items="${dslichsu }" var="item">
							<tbody>
								<tr>

									<%-- 									<td class="text-center"><input type="checkbox"
										name="check" value="<%=s.getMasach()%>"
										class="form-check-input"></td> --%>
									<td class="text-center">${item.maHoaDon }</td>
									<td class="text-center">${item.tensach }</td>
									<td class="text-center">${item.soLuongMua }</td>
									<td class="text-center">${item.gia }</td>
									<td class="text-center">${item.ngayMua }</td>
									<td class="text-center">${item.thanhTien }</td>
									<td class="text-center"><c:choose>
											<c:when test="${item.damua == false }">
												<p class="text-warning">Chưa Xác Nhận</p>
											</c:when>
											<c:otherwise>
												<p class="text-success">Đã Xác Nhận</p>
											</c:otherwise>
										</c:choose></td>
								</tr>


							</tbody>
						</c:forEach>
						<%-- 						<%
						}
						}
						%>
 --%>

					</table>


				</div>



			</div>
		</div>

	</form>
</body>
</html>