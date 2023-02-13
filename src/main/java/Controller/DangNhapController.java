package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.KhachHangBean;
import Bo.KhachHangBo;
import Dao.KhachHangDao;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet(urlPatterns = {"/DangNhapController", "/DangNhapController/login"})
public class DangNhapController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DangNhapController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  protected void getlogin(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
    // rd.forward(request, response);
    response.sendRedirect("/JavaNangCaoNhom4/dangnhap.jsp");
  }

  protected void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    String un = request.getParameter("un");
    String pass = request.getParameter("pass");
    session.setAttribute("taikhoan", un);
    String passMD5 = KhachHangDao.getMd5Hash(pass);
    KhachHangBo khbo = new KhachHangBo();
    // KhachHangBean khbean = khbo.ktdn(un, passMD5);
    String backtocart = (String) session.getAttribute("backtocart");

    System.out.printf("countLog", session.getAttribute("countLogin"));

    Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
    request.setCharacterEncoding("UTF-8");
    String answer = request.getParameter("answer");

    int count;

    if (session.getAttribute("countLogin") == null) {
      count = 0;
      session.setAttribute("countLogin", 0);
    } else {
      count = (int) session.getAttribute("countLogin");
    }

    if (un != null && pass != null) {
      KhachHangBean khbean = khbo.ktdn(un, passMD5);

      if (khbean != null) {
        if (count >= 3 && captcha.isCorrect(answer)) {
          count = 0;
          session.setAttribute("countLogin", count);
          session.setAttribute("hoten", khbean);
          if (backtocart != null) {
            response.sendRedirect("/JavaNangCaoNhom4/ThanhToanController");
          } else {
            // RequestDispatcher rd = request.getRequestDispatcher("SachController");
            response.sendRedirect("/JavaNangCaoNhom4/SachController");
            // rd.forward(request, response);
          }
        } else if (count < 3) {
          count = 0;
          session.setAttribute("countLogin", count);
          session.setAttribute("hoten", khbean);
          if (backtocart != null) {
            response.sendRedirect("/JavaNangCaoNhom4/ThanhToanController");
          } else {
            // RequestDispatcher rd = request.getRequestDispatcher("SachController");
            response.sendRedirect("/JavaNangCaoNhom4/SachController");
            // rd.forward(request, response);
          }
        }
      } else {
        response.sendRedirect("/JavaNangCaoNhom4/dangnhap.jsp?kt=1");
        count = count + 1;
        session.setAttribute("countLogin", count);
      }
    }


    getlogin(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      String uri = request.getServletPath();
      if (uri.contains("/login")) {
        login(request, response);
      } else {
        getlogin(request, response);
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
