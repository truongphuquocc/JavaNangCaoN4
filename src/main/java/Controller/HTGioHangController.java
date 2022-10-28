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

import Bean.loaibean;
import Bean.sachbean;
import Bo.giohangbo;
import Bo.loaibo;
import Bo.sachbo;

/**
 * Servlet implementation class HTGioHangController
 */
@WebServlet("/HTGioHangController")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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
				String masach = request.getParameter("btnSua");
				String tentb = "t" + masach;
				long sl = Long.parseLong(request.getParameter(tentb));
				if (sl == 0)
					gh.Xoa(masach);
				else
					gh.Sua(masach, sl);
			}

			if (request.getParameter("btnXoa") != null) {
				String masach = request.getParameter("btnXoa");
				gh.Xoa(masach);
				if (masach == null) {

					response.sendRedirect("sach.jsp");
				}

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

			if (gh.ds.size() == 0)
				response.sendRedirect("SachController");

			else {
				RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
				rd.forward(request, response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
