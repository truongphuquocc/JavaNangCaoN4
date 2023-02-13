package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.loaibean;
import Bean.sachbean;
import Bo.loaibo;
import Bo.sachbo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SachController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // request.setCharacterEncoding("utf-8");
    // response.setCharacterEncoding("utf-8");
    // String key = request.getParameter("txttk");
    // String ml = request.getParameter("ml");
    //
    // loaibo lbo = new loaibo();
    // ArrayList<loaibean> dsloai = lbo.getloai();
    // request.setAttribute("dsloai", dsloai);
    //
    // sachbo sbo = new sachbo();
    // ArrayList<sachbean> dssach = sbo.getsach();
    //
    // ArrayList<sachbean> dsSachFinal = null;

    // ------
    // int getTotal = 0;
    //
    // int pageSize = 12;
    //
    // int totalPage = 0;
    //
    // String index = request.getParameter("index");
    //
    // if (index == null) {
    // index = "1";
    // }
    // int indexPage = Integer.parseInt(index);
    //
    // if (ml == null && key == null) {
    //
    // getTotal = dssach.size();
    //
    // totalPage = getTotal / pageSize;
    //
    // if (getTotal % pageSize != 0) {
    // totalPage++;
    // }
    //
    // if (indexPage > totalPage) {
    // indexPage = 1;
    // }
    //
    // if (indexPage < 1) {
    // indexPage = totalPage;
    // }
    //
    // int pageSizeFinal = indexPage == totalPage ? dssach.size() : pageSize * indexPage;
    // dsSachFinal =
    // new ArrayList<sachbean>(dssach.subList(pageSize * (indexPage - 1), pageSizeFinal));
    // }
    //
    // if (ml != null) {
    //
    // getTotal = sbo.TimMa(ml).size();
    //
    // totalPage = getTotal / pageSize;
    //
    // if (getTotal % pageSize != 0) {
    // totalPage++;
    // }
    //
    // if (indexPage > totalPage) {
    // indexPage = 1;
    // }
    //
    // if (indexPage < 1) {
    // indexPage = totalPage;
    // }
    //
    // int pageSizeFinal = (indexPage == totalPage || getTotal < pageSize) ? sbo.TimMa(ml).size()
    // : pageSize * indexPage;
    // dsSachFinal =
    // new ArrayList<sachbean>(sbo.TimMa(ml).subList(pageSize * (indexPage - 1), pageSizeFinal));
    // } else if (key != null) {
    // getTotal = sbo.Tim(key).size();
    //
    // totalPage = getTotal / pageSize;
    //
    // if (getTotal % pageSize != 0) {
    // totalPage++;
    // }
    //
    // if (indexPage > totalPage) {
    // indexPage = 1;
    // }
    //
    // if (indexPage < 1) {
    // indexPage = totalPage;
    // }
    //
    // int pageSizeFinal = (indexPage == totalPage || getTotal < pageSize) ? sbo.Tim(key).size()
    // : pageSize * indexPage;
    //
    // dsSachFinal =
    // new ArrayList<sachbean>(sbo.Tim(key).subList(pageSize * (indexPage - 1), pageSizeFinal));
    // }
    // // ------
    //
    // request.setAttribute("dssach", dsSachFinal);
    //
    // request.setAttribute("indexPage", indexPage);
    //
    // request.setAttribute("totalPage", totalPage);
    //
    // request.setAttribute("index", index);
    //
    // request.setAttribute("txttk", key);
    //
    // request.setAttribute("ml", ml);
    //
    // RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
    // rd.forward(request, response);
    // =========================================
    // request.setCharacterEncoding("utf-8");
    // response.setCharacterEncoding("utf-8");
    //
    // String ml = request.getParameter("ml");
    // String key = request.getParameter("txttk");
    //
    // loaibo lbo = new loaibo();
    // sachbo sbo = new sachbo();
    //
    // ArrayList<loaibean> dsloai = lbo.getloai();
    // request.setAttribute("dsloai", dsloai);
    //
    // int totalPage = sbo.getPageNumber();
    // request.setAttribute("PageNumber", totalPage);
    //
    // int pageSize = 8;
    //
    // String index = request.getParameter("index");
    //
    // if (index == null) {
    // index = "1";
    // }
    // int indexPage = Integer.parseInt(index);
    //
    // if (ml == null && key == null) {
    // if (indexPage > totalPage) {
    // indexPage = 1;
    // }
    //
    // if (indexPage < 1) {
    // indexPage = totalPage;
    // }
    //
    // }
    // ArrayList<sachbean> list = null;
    // list = sbo.getPaging(indexPage, pageSize);
    // if (ml != null) {
    // list = sbo.TimMa(ml);
    // if (indexPage > totalPage) {
    // indexPage = 1;
    // }
    // if (indexPage < 1) {
    // indexPage = totalPage;
    // }
    // }
    //
    //
    //
    // request.setAttribute("listP", list);
    // request.setAttribute("indexPage", indexPage);
    //
    //
    //
    // /*
    // * if (ml != null) dssach = sbo.TimMa(ml); else if (key != null) dssach = sbo.Tim(key);
    // * request.setAttribute("dssach", dssach);
    // */
    //
    //
    // RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
    // rd.forward(request, response);
    // ============================================================================================
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String key = request.getParameter("txttk");

    if (request.getParameter("key") != null) {
      key = request.getParameter("key");
    }
    String ml = request.getParameter("ml");

    loaibo lbo = new loaibo();
    ArrayList<loaibean> dsloai = lbo.getloai();
    request.setAttribute("dsloai", dsloai);

    sachbo sbo = new sachbo();

    ArrayList<sachbean> dssach = null;
    int currentPage = 1;
    if (request.getParameter("page") != null) {
      currentPage = Integer.parseInt(request.getParameter("page"));
    }

    int totalSach = sbo.getPageNumber();
    int endPage = totalSach / 12;
    if (totalSach % 12 != 0) {
      endPage++;
    }

    if (ml != null && ml != "") {
      dssach = sbo.getPagingCategories(ml, currentPage);
      totalSach = sbo.getPageNumberCategories(ml);
      System.out.println(totalSach);
      endPage = totalSach / 12;
      if (totalSach % 12 != 0) {
        endPage++;
      }

    } else if (key != null && key != "") {
      // ArrayList<sachbean> dssachTKTD = sbo.Tim(key);
      dssach = sbo.getPagingSearch(key, currentPage);
      // totalSach = dssachTKTD.size();
      // totalSach = dssach.size();
      totalSach = sbo.getPageNumberSearch(key);
      endPage = totalSach / 12;
      if (totalSach % 12 != 0) {
        endPage++;
      }
    } else {
      dssach = sbo.getPaging(currentPage);

    }
    request.setAttribute("dssach", dssach);
    request.setAttribute("endPage", endPage);
    request.setAttribute("currentPage", currentPage);
    request.setAttribute("mloai", ml);
    request.setAttribute("keyTD", key);
    request.setAttribute("totalSach", totalSach);

    RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
    rd.forward(request, response);

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
