package remarema.web.software;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.util.CookieHelper;
import remarema.web.util.Util;

/**
 * Servlet implementation class DistributeServlet
 */
@WebServlet("/distribute")
public class DistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 1)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		Util util = new Util();
		String time = util.getDateTime();
		
		request.setAttribute("time", time);
		
		request.getRequestDispatcher("/distribute.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 1)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		request.setAttribute("message", "Verteilung erfolgreich angelegt!");
		
		String typ = request.getParameter("typ");
		String version = request.getParameter("version");
		String distribution = request.getParameter("distribution");
		String installation = request.getParameter("installation");

		request.setAttribute("typ", typ);
		request.setAttribute("version", version);
		request.setAttribute("distribution", distribution);
		request.setAttribute("installation", installation);

		
		request.getRequestDispatcher("/distribute.jsp").forward(request, response);
	}

}
