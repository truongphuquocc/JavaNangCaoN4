package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String un  = request.getParameter("un"); 
		String pass  = request.getParameter("pass");
		if(un != null && pass !=null) {
			if(un.equals("abc") && pass.equals("123")){//dang nhap dung
				session.setAttribute("dn", un);
				RequestDispatcher rd = request.getRequestDispatcher("SachController");
				rd.forward(request, response);
			}else {//dang nhap sai
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp?kt=1");
				rd.forward(request, response);
			}
		}
		else {//chay lan dau
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
