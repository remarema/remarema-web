package remarema.web.networks;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import remarema.api.NetworkDetail;
import remarema.services.network.NetworkServiceBean;

@WebServlet("/networks")
public class NetworksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NetworkServiceBean networkService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<NetworkDetail> networks = networkService.getNetworkDetailForAllNetworks();
		request.setAttribute("networks", networks);
		show(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	private RequestDispatcher getPage(HttpServletRequest request) {
		return request.getRequestDispatcher("/networks.jsp");
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getPage(request);
		dispatcher.forward(request, response);
	}

}
