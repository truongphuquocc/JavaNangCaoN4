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
import Bo.AdminSachBo;

/**
 * Servlet implementation class AdminXoaSachController
 */
@WebServlet("/AdminXoaSachController")
public class AdminXoaSachController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminXoaSachController() {
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

        AdminSachBo sach = new AdminSachBo();
        String masach = request.getParameter("ml");
        if (request.getParameter("btnXoa") != null) {
          sach.deleteBook(masach);
          request.setAttribute("tb", "Xoá sách thành công");
          RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLySachController");
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
