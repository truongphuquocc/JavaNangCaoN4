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
 * Servlet implementation class AdminThemLoaiController
 */
@WebServlet("/AdminThemLoaiController")
public class AdminThemLoaiController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminThemLoaiController() {
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
        String maloai = request.getParameter("txtmaloai");
        String tenloai = request.getParameter("txttenloai");
        if (maloai != null && tenloai != null) {
          int c = lbo.addCategory(maloai, tenloai);
          if (c == 0) {
            request.setAttribute("tb", "Thêm loại không thành công");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
            rd.forward(request, response);
          } else if (c == 1) {
            request.setAttribute("tb", "Trùng mã loại");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
            rd.forward(request, response);
          } else {
            request.setAttribute("tb", "Thêm loại thành công");
            RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
            rd.forward(request, response);
          }
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/ThemLoai.jsp");
        rd.forward(request, response);
      } else {
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
