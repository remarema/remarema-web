package remarema.web.networks;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import remarema.api.network.CreateNetwork;
import remarema.services.network.NetworkServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zum Hinzufügen von Netzwerken dar.
 */
@WebServlet("/addnetwork")
public class AddNetworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NetworkServiceBean networkService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		show(request, response);
	}

	/**
	 * Nach einem erfolgreichen POST-Aufruf, wird aus dem mitgegebenen
	 * Namen ein neues <code>CreateNetwork</code> Objekt generiert,
	 * welches dazu dient, der Datenbank ein Netzwerk hinzuzufügen.
	 * 
	 * Wurde das Netzwerk erfolgreich hinzugefügt, wird zur Netzwerkübersicht
	 * weitergeleitet. Weiters wird durch eine Nachricht dargestellt, dass
	 * das Netzwerk erfolgreich angelegt wurde.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(CookieHelper.checkCookie(request, 5)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

		String networkname = request.getParameter("name");

		CreateNetwork command = new CreateNetwork();
		command.setNetworkName(networkname);
		networkService.execute(command);
		request.setAttribute("message", "Root-Netzwerk erfolgreich erstellt!");

		response.sendRedirect("/remarema/networks");
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(CookieHelper.checkCookie(request, 5)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/addnetwork.jsp").forward(request,
				response);
	}

}
