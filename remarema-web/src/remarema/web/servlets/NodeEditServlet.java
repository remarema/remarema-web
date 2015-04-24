package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.NodeDetail;
import remarema.api.UpdateNode;
import remarema.services.network.NodeServiceBean;
import remarema.web.beans.NetworkStatus;
import remarema.web.beans.NodeStatus;

/**
 * Servlet implementation class NodeStatusServlet
 */
@WebServlet("/node_edit")
public class NodeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NodeServiceBean nodeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NodeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int nodeID = Integer.parseInt(request.getParameter("id"));
		NodeDetail nodeDetail = new NodeDetail();
		nodeDetail.setNodeID(nodeID);
		NodeDetail nd = nodeService.getNodeDetailForNodeID(nodeDetail);
		
		
		request.setAttribute("id", nd.getNodeID());
		request.setAttribute("name", nd.getNodeName());
		request.setAttribute("ip", nd.getNodeIP());
		request.setAttribute("networkID", nd.getNodeNetworkID());
		request.setAttribute("networkName", nd.getNodeNetworkName());
		request.getRequestDispatcher("/node_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		if(action.equals("update")){
			String name = request.getParameter("name");
			String ip = request.getParameter("ip");
			String networkName = request.getParameter("networkName");
			String networkID = request.getParameter("networkID");
			
			UpdateNode updateNode = new UpdateNode();
			updateNode.setNodeID(id);
			updateNode.setNodeName(name);
			updateNode.setNodeIP(ip);
			updateNode.setNodeNetworkName(networkName);
		
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("ip", ip);
			request.setAttribute("networkName", networkName);
			nodeService.nodeUpdate(updateNode);
			
			NodeDetail nodeDetail = new NodeDetail();
			nodeDetail.setNodeID(id);
			NodeDetail nd = nodeService.getNodeDetailForNodeID(nodeDetail);
			request.setAttribute("networkID", nd.getNodeNetworkID());
			request.setAttribute("message", "�nderungen erfolgreich!");
			request.getRequestDispatcher("/node_edit.jsp").forward(request, response);
		}
		else if(action.equals("delete")){
			NodeDetail nodeDetail = new NodeDetail();
			nodeDetail.setNodeID(id);
			nodeService.removeNode(nodeDetail);
			response.sendRedirect("/remarema/nodes?message=L�schen erfolgreich!");
		}
		else{
			request.getRequestDispatcher("/node_edit.jsp").forward(request, response);
		}
		
		
	}

}
