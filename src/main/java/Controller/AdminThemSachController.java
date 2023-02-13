package Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import Bean.AdminBean;
import Bean.loaibean;
import Bo.AdminSachBo;
import Bo.loaibo;

/**
 * Servlet implementation class AdminThemSachController
 */
@WebServlet("/AdminThemSachController")
public class AdminThemSachController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminThemSachController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
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


          // thêm
          int c = sach.addSach(masach, tensach, tacgia, Long.parseLong(gia),
              Long.parseLong(soluong), anhupload, maloai, ngay, sotap);
          if (c == 0) {
            request.setAttribute("tb", "Thêm sách không thành công");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySachController");
            rd.forward(request, response);
          } else if (c == -1) {
            request.setAttribute("tb", "Trùng mã sách");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySachController");
            rd.forward(request, response);
          } else {
            request.setAttribute("tb", "Thêm sách thành công");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySachController");
            rd.forward(request, response);
          }
        } catch (Exception e) {
          // TODO: handle exception
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/ThemSach.jsp");
        rd.forward(request, response);
      } else {
        request.setAttribute("tb", "Bạn cần đăng nhập");
        RequestDispatcher rd = request.getRequestDispatcher("Admin/LoginAdmin.jsp");
        rd.forward(request, response);
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
