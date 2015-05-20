package remarema.web.networks;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.network.CreateNetwork;
import remarema.api.network.CreateNode;
import remarema.api.network.NetworkDetail;
import remarema.api.network.NodeDetail;
import remarema.api.network.UpdateNetwork;
import remarema.api.network.UpdateNode;
import remarema.services.network.ChildNotEmptyException;
import remarema.services.network.IPNotValidException;
import remarema.services.network.NetworkServiceBean;
import remarema.services.network.NodeServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class NetworkStatusServlet
 */
@WebServlet("/network_edit")
public class NetworkEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NetworkServiceBean networkService;

	@Inject
	private NodeServiceBean nodeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NetworkEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 2)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		Integer networkID = new Integer(request.getParameter("id"));

		NetworkDetail networkDetail = new NetworkDetail();
		networkDetail.setNetworkID(networkID);
		NetworkDetail nwd = networkService
				.getNetworkDetailForNetworkID(networkDetail);

		request.setAttribute("id", nwd.getNetworkID());
		request.setAttribute("name", nwd.getNetworkName());
		request.setAttribute("parentID", nwd.getNetworkParentID());
		request.setAttribute("parentName", nwd.getNetworkParentName());

		request.getRequestDispatcher("/network_edit.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 2)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		Integer id = new Integer(request.getParameter("id"));
		String name = request.getParameter("name");
		String parentID = request.getParameter("parentID");
		String parentName = request.getParameter("parentName");
		String action = request.getParameter("action");

		if (action.equals("update")) {
			UpdateNetwork updateNetwork = new UpdateNetwork();
			updateNetwork.setNetworkID(id);
			updateNetwork.setNetworkName(name);
			updateNetwork.setNetworkParentName(parentName);

			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("parentName", parentName);

			networkService.networkUpdate(updateNetwork);

			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkID(id);
			NetworkDetail nwd = networkService
					.getNetworkDetailForNetworkID(networkDetail);
			request.setAttribute("parentID", nwd.getNetworkParentID());

			request.setAttribute("message", "&Auml;nderungen erfolgreich!");
			request.getRequestDispatcher("/network_edit.jsp").forward(request,
					response);
		} else if (action.equals("delete")) {
			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkID(id);
			try {
				networkService.removeNetwork(networkDetail);
				response.sendRedirect("/remarema/networks?message=Löschen erfolgreich!");
			} catch (ChildNotEmptyException e) {
				request.setAttribute("message", e.getMessage());
				e.printStackTrace();
				request.getRequestDispatcher("/network_edit.jsp").forward(
						request, response);
			}
		} else if (action.equals("insertChild")) {
			String childName = request.getParameter("childName");

			CreateNetwork command = new CreateNetwork();
			command.setNetworkName(childName);
			command.setParentNetworkName(name);
			networkService.execute(command);
			request.setAttribute("message", "Child erfolgreich erstellt!");

			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("parentName", parentName);
			request.setAttribute("parentID", parentID);

			request.getRequestDispatcher("/network_edit.jsp").forward(request,
					response);
		} else if (action.equals("insertNode")) {
			String nodeName = request.getParameter("nodeName");
			String nodeIP = request.getParameter("nodeIP");

			CreateNode createNode = new CreateNode();
			createNode.setNodeName(nodeName);
			createNode.setNodeIP(nodeIP);
			createNode.setNodeNetworkName(name);

			try {
				nodeService.execute(createNode);
				request.setAttribute("message", "Client erfolgreich erstellt!");
			} catch (IPNotValidException e) {
				request.setAttribute("message", e.getMessage());
			}

			

			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("parentName", parentName);
			request.setAttribute("parentID", parentID);

			request.getRequestDispatcher("/network_edit.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/network_edit.jsp").forward(request,
					response);
		}

	}

}
