package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import remarema.api.CreateNetwork;
import remarema.services.network.NetworkServiceBean;

/**
 * Servlet implementation class AddNetworkServlet
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
		AddNetworkForm form = new AddNetworkForm();
		request.setAttribute("form", form);
		show(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AddNetworkForm form = new AddNetworkForm();
		request.setAttribute("form", form);
		form.update(request);

		if (form.isValid()) {
			CreateNetwork command = new CreateNetwork();
			command.setNetworkName(form.getName());
			command.setParentNetworkName(form.getParent());
			networkService.execute(command);
			request.setAttribute("message", "Netzwerk erfolgreich erstellt!");
		}
		show(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/addnetwork.jsp").forward(request,
				response);
	}

}
