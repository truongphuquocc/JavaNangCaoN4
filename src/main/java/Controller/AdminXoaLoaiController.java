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
 * Servlet implementation class AdminXoaLoaiController
 */
@WebServlet("/AdminXoaLoaiController")
public class AdminXoaLoaiController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminXoaLoaiController() {
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

        loaibo lbo = new loaibo();
        if (request.getParameter("btnXoa") != null) {
          String ml = request.getParameter("ml");
          lbo.deleteCategory(ml);
          request.setAttribute("tb", "Xoá loại thành công");
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
