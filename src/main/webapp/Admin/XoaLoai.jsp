<%@page import="java.util.ArrayList"%>
<%@page import="Bean.XacNhanBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Xoá loại</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="https://cdn0.fahasa.com/media/favicon/default/favicon4.ico" type="image/x-icon" />
<!-- Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

<!-- Icon -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="Assets/sach.css">

</head>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
	height: 100vh;
	font-family: 'Montserrat', sans-serif;
	font-family: 'Poppins', sans-serif !important;
}

button, input, [tabindex] {
	outline: none;
	border: none;
}

.small {
	min-width: 100px;
	padding: 8px 20px;
}

.form-control:focus {
	box-shadow: none;
	border-color: #CF111a;
}

.btn, btn-primary {
	border: none;
}

.btn:focus, .btn-primary:focus {
	box-shadow: none !important;
}

a.text-body:hover {
	text-decoration: none;
	color: #CF111A !important;
	font-weight: bold;
}
</style>
<body>

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
						href="AdminLogoutController"> <i
							class="fa-solid fa-right-from-bracket"></i> logout
					</a></li>

					<li class="nav-item account" type="button"><c:choose>
							<c:when test="${sessionScope.ad == null }">
								<a class="nav-link text-dark text-uppercase"
									href="AdminLoginController" style="display: inline-block">
									<i class="fa fa-user"></i>Login
								</a>
							</c:when>
							<c:otherwise>
								<a class="nav-link text-dark text-uppercase" href="#"
									style="display: inline-block"> <i class="fa fa-user"></i>
									Hi: ${ sessionScope.ad.getTendn() }
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
				class="nav-link font-weight-bold text-white" href="AdminController">TRANG
					CHỦ</a></li>
			<li class="nav-item"><a
				class="nav-link font-weight-bold text-white"
				href="AdminQuanLyLoaiController">QUẢN LÝ LOẠI</a></li>
			<li class="nav-item"><a
				class="nav-link font-weight-bold text-white"
				href="AdminQuanLySachController">QUẢN LÝ SÁCH</a></li>
			<li class="nav-item"><a
				class="nav-link font-weight-bold text-white"
				href="XacNhanController">XÁC NHẬN</a></li>
			<li class="nav-item"><a
				class="nav-link font-weight-bold text-white"
				href="AdminDanhSachChuyenTienController">DANH SÁCH CHUYỂN TIỀN</a></li>
		</ul>

	</nav>


	<div class="row">

		<div class="ml-auto mr-auto mt-3"
			style="width: 600px; height: 1200px;">

			<div class="p-3" style="background: pink; height: auto">

				<form action="AdminXoaLoaiController?ml=${loaibean.getMaloai() }" method="post">
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-2 col-form-label">Mã
							loại</label>
						<div class="col-sm-10">
							<p class="form-control-plaintext">${loaibean.getMaloai() }</p>
						</div>
					</div>
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-2 col-form-label">Tên
							loại</label>
						<div class="col-sm-10">
							<p class="form-control-plaintext">${loaibean.getTenloai() }</p>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" name="btnXoa">
						<i class="fa-solid fa-floppy-disk"></i> Xoá dữ liệu
					</button>
					<button type="submit" class="btn btn-primary">
						<i class="fa-solid fa-circle-left"></i> Quay lại
					</button>
				</form>


			</div>



		</div>
	</div>

</body>
</html>