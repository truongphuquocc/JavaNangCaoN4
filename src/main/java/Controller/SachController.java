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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);

		sachbo sbo = new sachbo();
		ArrayList<sachbean> dssach = sbo.getsach();
		String ml = request.getParameter("ml");
		String key = request.getParameter("txttk");
		if (ml != null)
			dssach = sbo.TimMa(ml);
		else if (key != null)
			dssach = sbo.Tim(key);
		request.setAttribute("dssach", dssach);

		RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
