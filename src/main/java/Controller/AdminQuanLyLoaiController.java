package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.AdminBean;
import Bean.loaibean;
import Bo.loaibo;

/**
 * Servlet implementation class AdminQuanLyLoaiController
 */
@WebServlet("/AdminQuanLyLoaiController")
public class AdminQuanLyLoaiController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminQuanLyLoaiController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  protected void addCategory(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void editCategory(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void deleteCategory(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      response.setCharacterEncoding("utf-8");
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession();
      AdminBean ad = (AdminBean) session.getAttribute("ad");
      if (ad != null) {
        loaibo lbo = new loaibo();
        loaibean lbean = null;
        ArrayList<loaibean> dsloai = null;
        dsloai = lbo.getloai();
        String key = request.getParameter("key");
        String ml = request.getParameter("ml");
        if (key != null)
          dsloai = lbo.Tim(key);
        request.setAttribute("dsloai", dsloai);
        if (request.getParameter("btnAdd") != null) {
          RequestDispatcher rd = request.getRequestDispatcher("Admin/ThemLoai.jsp");
          rd.forward(request, response);
        }
        if (request.getParameter("btnEdit") != null) {
          lbean = lbo.getCategory(ml);
          request.setAttribute("loaibean", lbean);
          RequestDispatcher rd = request.getRequestDispatcher("Admin/SuaLoai.jsp");
          rd.forward(request, response);
        }
        if (request.getParameter("btnDelete") != null) {
          lbean = lbo.getCategory(ml);
          request.setAttribute("loaibean", lbean);
          RequestDispatcher rd = request.getRequestDispatcher("Admin/XoaLoai.jsp");
          rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/QuanLyLoai.jsp");
        rd.forward(request, response);
      } else {
        request.setAttribute("tb", "Bạn cần đăng nhập");
        RequestDispatcher rd = request.getRequestDispatcher("Admin/LoginAdmin.jsp");
        rd.forward(request, response);
      }

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
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
