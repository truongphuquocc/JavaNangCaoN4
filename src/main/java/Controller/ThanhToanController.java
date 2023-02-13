package Controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.KhachHangBean;
import Bean.giohangbean;
import Bo.ChiTietHoaDonBo;
import Bo.HoaDonBo;
import Bo.giohangbo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet(urlPatterns = {"/ThanhToanController", "/ThanhToanController/xacnhan"})
public class ThanhToanController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private HoaDonBo HoaDonBo;
  private ChiTietHoaDonBo ChiTietHoaDonBo;

  public void init() throws ServletException {
    HoaDonBo = new HoaDonBo();
    ChiTietHoaDonBo = new ChiTietHoaDonBo();
  }


  /**
   * @see HttpServlet#HttpServlet()
   */
  public ThanhToanController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  protected void getLayout(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher rd = request.getRequestDispatcher("ThanhToan.jsp");
    rd.forward(request, response);
  }

  protected void thanhToan(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    HttpSession session = request.getSession();

    KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");
    giohangbo gh = (giohangbo) session.getAttribute("gio");

    int MaHoaDonVuaTao = HoaDonBo.ThemHoaDon(kh.getMakh(), new Date(), false);

    if (MaHoaDonVuaTao != 0) {
      for (giohangbean item : gh.ds) {
        ChiTietHoaDonBo.ThemCTHD(item.getMasach(), item.getSoluong(), (long) MaHoaDonVuaTao, false);
      }
    }
    gh.XoaALL();

    response.sendRedirect("/JavaNangCaoNhom4/LichSuMuaHangController");


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // HttpSession session = request.getSession();
    // giohangbo gh = (giohangbo) session.getAttribute("gio");
    // try {
    // if (session.getAttribute("hoten") != null) {
    // if (session.getAttribute("gh") != null) {
    //
    // KhachHangBean khbean = (KhachHangBean) session.getAttribute("hoten");
    // // System.out.println(session.getAttribute("hoten"));
    // // System.out.println("123");
    // HoaDonBo hdbo = new HoaDonBo();
    // Date d = new Date();
    //
    // int ThemHD = hdbo.ThemHoaDon(khbean.getMakh(), d, true);
    //
    // if (ThemHD == 1) {
    // ChiTietHoaDonBo cthdbo = new ChiTietHoaDonBo();
    // for (giohangbean s : gh.ds) {
    //
    // int ThemCTHD =
    // cthdbo.ThemCTHD(s.getMasach(), (int) s.getSoluong(), hdbo.GetHoaDon(), true);
    // }
    // session.setAttribute("gio", new giohangbo());
    // response.sendRedirect("GioHangController");
    //
    // }
    // }
    //
    // } else {
    // // response.sendRedirect("DangNhapController");
    // RequestDispatcher rd = request.getRequestDispatcher("DangNhapController");
    // rd.forward(request, response);
    // }
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    String uri = request.getServletPath();

    try {
      if (uri.contains("/xacnhan")) {
        thanhToan(request, response);
      }

      else {
        getLayout(request, response);
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
