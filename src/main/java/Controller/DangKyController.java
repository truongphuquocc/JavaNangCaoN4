package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bo.KhachHangBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DangKyController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    try {
      String UserName = request.getParameter("username");
      String FullName = request.getParameter("fullname");
      String address = request.getParameter("address");
      String phonenumber = request.getParameter("phonenumber");
      String Email = request.getParameter("email");
      String password = request.getParameter("password");
      String confirm = request.getParameter("confirm");
      KhachHangBo khbo = new KhachHangBo();


      if (UserName != null && FullName != null && address != null && phonenumber != null
          && confirm != null && Email != null && password != null) {
        if (password.equals(confirm)) {
          boolean kh = khbo.ktdk(FullName, address, phonenumber, Email, UserName,
              KhachHangBo.convertPassMd5(password));
          if (kh == true) {
            RequestDispatcher rd = request.getRequestDispatcher("DangNhapController");
            rd.forward(request, response);
          }
        } else {
          RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
          rd.forward(request, response);
        }

      } else {// chay lan dau
        RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
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
