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
import Bean.XacNhanBean;
import Bo.AdminChiTietDonHangBo;
import Bo.XacNhanBo;

/**
 * Servlet implementation class AdminDanhSachChuyenTienController
 */
@WebServlet("/AdminDanhSachChuyenTienController")
public class AdminDanhSachChuyenTienController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AdminDanhSachChuyenTienController() {
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
        String madh = request.getParameter("madh");
        XacNhanBo donhang = new XacNhanBo();
        ArrayList<XacNhanBean> dsdh = null;
        dsdh = donhang.getlistbuy();
        request.setAttribute("dsdh", dsdh);
        if (madh != null) {
          Integer maDH = Integer.valueOf(madh);

          int c = donhang.countCTHD(maDH);
          System.out.println(c + "count");
          if (request.getParameter("btnDetails") != null) {
            AdminChiTietDonHangBo ctdh = new AdminChiTietDonHangBo();
            ArrayList<AdminChiTietDonHangBean> dsctdh = null;
            dsctdh = ctdh.getdanhsach(maDH);
            request.setAttribute("dsctdh", dsctdh);
            RequestDispatcher rd = request.getRequestDispatcher("Admin/ChiTietChuyenTien.jsp");
            rd.forward(request, response);
          }
        }
        RequestDispatcher rd = request.getRequestDispatcher("Admin/DanhSachChuyenTien.jsp");
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
