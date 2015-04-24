package remarema.web.networks;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.NetworkDetail;
import remarema.api.NodeDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.services.network.NodeServiceBean;

/**
 * Servlet implementation class NodesServlet
 */
@WebServlet("/nodes")
public class NodesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NodeServiceBean nodeService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		request.setAttribute("message", message);
		
		List<NodeDetail> nodes = nodeService.getNodeDetailForAllNodes();
		request.setAttribute("nodes", nodes);
		show(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	private RequestDispatcher getPage(HttpServletRequest request) {
		return request.getRequestDispatcher("/nodes.jsp");
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getPage(request);
		dispatcher.forward(request, response);
	}
}
