package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.AdminBean;
import Bo.loaibo;


/**
 * Servlet implementation class AdminSuaLoaiController
 */
@WebServlet("/AdminSuaLoaiController")
public class AdminSuaLoaiController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminSuaLoaiController() {
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

        loaibo loai = new loaibo();
        String maloai = request.getParameter("txtmaloai");
        String tenloai = request.getParameter("txttenloai");
        if (request.getParameter("btnSave") != null) {
          loai.editcategory(maloai, tenloai);
          request.setAttribute("tb", "Sửa loại thành công");
          RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
          rd.forward(request, response);
        }

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
