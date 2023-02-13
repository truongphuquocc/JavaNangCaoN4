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
import Bean.LichSuMuaHangBean;
import Bo.LichSuMuaHangBo;

/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHangController")
public class LichSuMuaHangController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LichSuMuaHangController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    HttpSession session = request.getSession();

    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");


    LichSuMuaHangBo lsmhbo = new LichSuMuaHangBo();
    KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");

    // ArrayList<LichSuMuaHangBean> dslichsu = null;
    try {
      ArrayList<LichSuMuaHangBean> dslichsu = lsmhbo.getLichSuMuaHang(kh.getMakh());

      request.setAttribute("dslichsu", dslichsu);

      RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      // TODO Auto-generated catch block
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
