package remarema.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class AddSoftwareServlet
 */
@WebServlet("/packages")
public class PackagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackagesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 6)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/packages.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 6)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		String action = request.getParameter("action");
		
		if(action.equals("insert")){
			String name = request.getParameter("name");
	
	
	
			request.setAttribute("message",
					"Package erfolgreich hinzugef&uuml;gt!");
		}

		request.getRequestDispatcher("/packages.jsp").forward(request,
				response);
	}

}
