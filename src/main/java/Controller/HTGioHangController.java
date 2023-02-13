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
import Bean.KhachHangBean;
import Bean.loaibean;
import Bean.sachbean;
import Bo.giohangbo;
import Bo.loaibo;
import Bo.sachbo;

/**
 * Servlet implementation class HTGioHangController
 */
@WebServlet(urlPatterns = {"/HTGioHangController", "/HTGioHangController/confirm"})
public class HTGioHangController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HTGioHangController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  protected void GioHang(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String key = request.getParameter("txttk");
    String ml = request.getParameter("ml");

    loaibo lbo = new loaibo();
    ArrayList<loaibean> dsloai = lbo.getloai();
    request.setAttribute("dsloai", dsloai);

    sachbo sbo = new sachbo();
    ArrayList<sachbean> dssach = sbo.getsach();

    if (ml != null) {
      dssach = sbo.TimMa(ml);
    } else if (key != null) {
      dssach = sbo.Tim(key);
    }
    request.setAttribute("dssach", dssach);

    HttpSession session = request.getSession();

    giohangbo gh = (giohangbo) session.getAttribute("gio");
    if (gh != null) {
      if (request.getParameter("btnSua") != null) {
        String msach = request.getParameter("btnSua");
        long sl = Long.parseLong(request.getParameter("t" + msach));
        if (sl == 0) {
          gh.Xoa(msach);
        } else
          gh.Sua(msach, sl);

      }
      if (request.getParameter("btnXoa") != null) {
        String msach = request.getParameter("btnXoa");
        gh.Xoa(msach);

      }
      if (request.getParameter("btnXoaCheck") != null) {
        String[] gtcheck = request.getParameterValues("check");
        if (gtcheck != null) {
          for (String ss : gtcheck)
            gh.Xoa(ss);
        }
      }


      if (request.getParameter("btnXoaAll") != null) {
        gh.XoaALL();
      }
      session.setAttribute("gio", gh);

    }
    // response.sendRedirect("htgio.jsp");
    RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
    rd.forward(request, response);

  }

  protected void checkLogin(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");



    if (kh == null) {

      session.setAttribute("backtocart", "e");
      response.sendRedirect("/JavaNangCaoNhom4/DangNhapController");

      return;
    } else {
      response.sendRedirect("/JavaNangCaoNhom4/ThanhToanController");
      return;
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String uri = request.getServletPath();
    try {
      if (uri.contains("/confirm")) {
        checkLogin(request, response);
      } else {
        GioHang(request, response);
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
