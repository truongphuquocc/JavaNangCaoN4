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
import Bean.AdminSachBean;
import Bean.loaibean;
import Bo.AdminSachBo;
import Bo.loaibo;


/**
 * Servlet implementation class AdminQuanLySachController
 */
@WebServlet("/AdminQuanLySachController")
public class AdminQuanLySachController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminQuanLySachController() {
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
        ArrayList<AdminSachBean> dssach;
        AdminSachBean sachbean;
        dssach = sach.getsach();
        String key = request.getParameter("key");
        String ms = request.getParameter("ms");
        if (key != null)
          dssach = sach.Tim(key);
        request.setAttribute("dssach", dssach);
        if (request.getParameter("btnAdd") != null) {
          RequestDispatcher rd = request.getRequestDispatcher("AdminThemSachController");
          rd.forward(request, response);
        }
        if (request.getParameter("btnDelete") != null) {
          loaibo loai = new loaibo();
          ArrayList<loaibean> dsloai = null;
          dsloai = loai.getloai();
          request.setAttribute("dsloai", dsloai);
          sachbean = sach.getBook(ms);
          request.setAttribute("sachbean", sachbean);
          RequestDispatcher rd = request.getRequestDispatcher("Admin/XoaSach.jsp");
          rd.forward(request, response);
        }
        if (request.getParameter("btnEdit") != null) {
          loaibo loai = new loaibo();
          ArrayList<loaibean> dsloai = null;
          dsloai = loai.getloai();
          request.setAttribute("dsloai", dsloai);
          sachbean = sach.getBook(ms);
          request.setAttribute("sachbean", sachbean);
          RequestDispatcher rd = request.getRequestDispatcher("Admin/SuaSach.jsp");
          rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/QuanLySach.jsp");
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
