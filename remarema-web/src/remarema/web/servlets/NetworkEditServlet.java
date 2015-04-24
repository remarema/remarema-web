package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.NetworkDetail;
import remarema.api.NodeDetail;
import remarema.api.UpdateNetwork;
import remarema.api.UpdateNode;
import remarema.services.network.ChildNotEmptyException;
import remarema.services.network.NetworkServiceBean;
import remarema.web.beans.NetworkStatus;

/**
 * Servlet implementation class NetworkStatusServlet
 */
@WebServlet("/network_edit")
public class NetworkEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NetworkServiceBean networkService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NetworkEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer networkID = new Integer(request.getParameter("id"));
		
		NetworkDetail networkDetail = new NetworkDetail();
		networkDetail.setNetworkID(networkID);
		NetworkDetail nwd = networkService.getNetworkDetailForNetworkID(networkDetail);
		
		request.setAttribute("id", nwd.getNetworkID());
		request.setAttribute("name", nwd.getNetworkName());
		request.setAttribute("parentID", nwd.getNetworkParentID());
		request.setAttribute("parentName", nwd.getNetworkParentName());
		
		
		request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = new Integer(request.getParameter("id"));
		String action = request.getParameter("action");
		
		if(action.equals("update")){
			String name = request.getParameter("name");
			String parentID = request.getParameter("parentID");
			String parentName = request.getParameter("parentName");
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
			NetworkDetail nwd = networkService.getNetworkDetailForNetworkID(networkDetail);
			request.setAttribute("parentID", nwd.getNetworkParentID());
			
			request.setAttribute("message", "Änderungen erfolgreich!");
			request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
		}
		else if(action.equals("delete")){
			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkID(id);
			try {
				networkService.removeNetwork(networkDetail);
				response.sendRedirect("/remarema/networks?message=Löschen erfolgreich!");
			} catch (ChildNotEmptyException e) {
				request.setAttribute("message", e.getMessage());
				e.printStackTrace();
				request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
			}
		}
		else{
			request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
		}

		
		
		
	}

}
