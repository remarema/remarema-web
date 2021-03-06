package remarema.web.software;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.networks.NetworksServlet;
import remarema.web.util.CookieHelper;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zum Hinzufügen einer neuen Software dar.
 * 
 * @see NetworksServlet
 */
@WebServlet("/addSoftware")
public class AddSoftwareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSoftwareServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see AddNetworkServlet#doGet(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 4)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/package_edit.jsp").forward(request,
				response);
	}

	/**
	 * @see AddNetworkServlet#doPost(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 4)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		request.setAttribute("message",
				"Package erfolgreich ge&auml;ndert!");

		request.getRequestDispatcher("/package_edit.jsp").forward(request,
				response);
	}

}
