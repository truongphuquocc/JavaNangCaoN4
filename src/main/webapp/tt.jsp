<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%String sv = request.getParameter("masv"); 
	if(sv.equals("sv1"))
		out.print("Thong tin cua sv: nguyen van a");
	else if(sv.equals("sv2"))
		out.print("Thong tin cua sv: nguyen van b");
	if(sv.equals("sv3"))
		out.print("Thong tin cua sv: nguyen van c");
	%>
	 try {
      response.setCharacterEncoding("utf-8");
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession();
      AdminBean ad = (AdminBean) session.getAttribute("ad");
      if (ad != null) {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        AdminSachBo sach = new AdminSachBo();
        loaibo loai = new loaibo();
        ArrayList<loaibean> dsloai = null;
        dsloai = loai.getloai();
        request.setAttribute("dsloai", dsloai);
        try {
          String masach = null, tensach = null, tacgia = null, maloai = null, soluong = null,
              gia = null, anhupload = null, sotap = null;
          Date ngay = new java.util.Date();


          List<FileItem> fileItems = upload.parseRequest(request);
          for (FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
              String nameimg = fileItem.getName();
              if (!nameimg.equals("")) {
                String dirUrl = request.getServletContext().getRealPath("") + "image_sach";
                File dir = new File(dirUrl);
                if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
                  dir.mkdir();
                }
                String fileImg = dirUrl + File.separator + nameimg;
                File file = new File(fileImg);// tạo file
                try {
                  fileItem.write(file);// ghi file
                  anhupload = "image_sach/" + nameimg;
                  System.out.println(anhupload);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            } else {
              String tentk = fileItem.getFieldName();
              if (tentk.equals("txtmasach"))
                masach = fileItem.getString("UTF-8");
              if (tentk.equals("txttensach"))
                tensach = fileItem.getString("UTF-8");
              if (tentk.equals("txttacgia"))
                tacgia = fileItem.getString("UTF-8");
              if (tentk.equals("maloai"))
                maloai = fileItem.getString("UTF-8");
              if (tentk.equals("txtsoluong"))
                soluong = fileItem.getString("UTF-8");
              if (tentk.equals("txtgia"))
                gia = fileItem.getString("UTF-8");
              if (tentk.equals("txtsotap"))
                sotap = fileItem.getString("UTF-8");
              if (tentk.equals("txtngaynhap")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                ngay = format.parse(fileItem.getString());
              }
            }
          }

          if (request.getParameter("btnSave") != null) {
            sach.editBook(masach, tensach, tacgia, Long.parseLong(gia), Long.parseLong(soluong),
                maloai, ngay, sotap, anhupload);
            request.setAttribute("tb", "Sửa sách thành công");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySachController");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
        }
        // RequestDispatcher rd = request.getRequestDispatcher("Admin/SuaSach.jsp");
        // rd.forward(request, response);
      } else {
        request.setAttribute("tb", "Bạn cần đăng nhập");
        RequestDispatcher rd = request.getRequestDispatcher("Admin/LoginAdmin.jsp");
        rd.forward(request, response);
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
</body>
</html>