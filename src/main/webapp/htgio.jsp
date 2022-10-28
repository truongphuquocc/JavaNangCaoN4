<%@page import="Bean.giohangbean"%>
<%@page import="Bo.giohangbo"%>
<%@page import="Bean.sachbean"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.loaibo"%>
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

			<a class="navbar-brand" href="sach.jsp" style="color: #CF111A;"><b>MinhKhai</b></a>

			<div class="collapse navbar-collapse" id="collapsibleNavId">

				<form class="form-inline ml-auto my-2 my-lg-0 mr-3"
					action="SachController" method="post"">
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
						class="nav-link text-dark text-uppercase" href="dangnhap.jsp">
							<i class="fa-solid fa-right-from-bracket"></i> logout
					</a></li>

					<li class="nav-item account" type="button">
						<%
						if (session.getAttribute("dn") == null) {
						%> <a class="nav-link text-dark text-uppercase"
						href="dangnhap.jsp" style="display: inline-block"> <i
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


		<div class="collapse navbar-collapse d-flex align-items-center">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a
					class="nav-link font-weight-bold text-white" href="htgio.jsp">GIỎ
						HÀNG</a></li>
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

	<form action="HTGioHangController" method="post">
		<div class="row">
			<div class="col-2">
				<div class="container">
					<div class="row" style="margin-right: -30px;">
						<ul class="list-group list-group-flush w-100 bg-white">
							<%
							ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
							if (dsloai != null) {
								for (loaibean l : dsloai) {
							%>

							<li class="list-group-item list-group-item-action"><a
								class="text-body" href="SachController?ml=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></li>
							<%
							}
							}
							%>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-10">
				<div class="ml-auto mr-auto mt-3"
					style="width: 1200px; height: 1200px;">

					<div class="p-3" style="background: white; height: auto">

						<table class="table table-bordered table-striped">
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
							<%
							giohangbo gh = (giohangbo) session.getAttribute("gio");
							if (gh != null) {
								for (giohangbean s : gh.ds) {
							%>
							<tbody>

								<tr>

									<td class="text-center"><input type="checkbox"
										name="check" value="<%=s.getMasach()%>"
										class="form-check-input"></td>
									<td><%=s.getMasach()%></td>
									<td><%=s.getTensach()%></td>
									<td><%=s.getGia()%></td>
									<td><%=s.getSoluong()%></td>
									<td class="">


										<div class="form-inlne">
											<input min="0" name="t<%=s.getMasach()%>" type="number"
												value="<%=s.getSoluong()%>" style="width: 60px">
											<button name="btnSua" value="<%=s.getMasach()%>"
												type="submit" class="btn btn-info">Sửa</button>
										</div>


									</td>
									<td class=" text-right"><%=s.getThanhtien()%>đ</td>
									<td class=" text-right">

										<button type="submit" value="<%=s.getMasach()%>" name="btnXoa"
											class="btn btn-info">
											<i class="fa-solid fa-trash"></i>
										</button>

									</td>
								</tr>


							</tbody>
							<%
							}
							}
							%>

							<tr>
								<td>
									<button type="submit" name="btnXoaCheck" class="btn btn-info">
										<i class="fa-solid fa-trash"></i>
									</button>
								</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class=" text-right">Tổng tiền: <%=gh.Tongtien()%> đ
								</td>
							<tr>
						</table>


					</div>

					<div
						class="sticky-bottom d-flex align-items-center justify-content-center rounded mt-3"
						style="background: white;">
						<div class="d-flex">
							<div class="m-3">
								<button name="btnXoaAll" type="submit" class="btn btn-info">Xoa
									tat ca</button>
							</div>
							<div class="m-3">
								<a href="SachController" class="btn btn-info">Tiep tuc mua
									hang</a>
							</div>
							<div class="m-3">
								<a class="btn btn-info"
									style="background: #cf111a; border: none">Thanh Toan</a>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</form>
</body>
</html>
