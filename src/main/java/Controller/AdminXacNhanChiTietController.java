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
import Bean.AdminChiTietDonHangBean;
import Bo.AdminChiTietDonHangBo;
import Bo.XacNhanBo;

/**
 * Servlet implementation class AdminXacNhanChiTietController
 */
@WebServlet("/AdminXacNhanChiTietController")
public class AdminXacNhanChiTietController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminXacNhanChiTietController() {
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
        String madh = request.getParameter("mahd");
        String mact = request.getParameter("mact");
        AdminChiTietDonHangBo donhang = new AdminChiTietDonHangBo();
        XacNhanBo xnbo = new XacNhanBo();
        ArrayList<AdminChiTietDonHangBean> dsdh = null;

        request.setAttribute("dsctdh", dsdh);
        if (madh != null) {
          Integer maDH = Integer.valueOf(madh);
          Integer maCT = Integer.valueOf(mact);

          System.out.println(maDH + "madh");
          System.out.println(maCT + "maCT");

          if (request.getParameter("btnChecks") != null) {
            System.out.println(maDH + "madh");
            System.out.println(maCT + "maCT");
            donhang.xacnhanchitiet(maCT);
            xnbo.autoXacNhan(maDH);
            dsdh = donhang.getdanhsach(maDH);
            request.setAttribute("dsctdh", dsdh);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/ChiTietDonHang.jsp");
            rd.forward(request, response);
          }
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/ChiTietDonHang.jsp");
        rd.forward(request, response);
      } else {
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
