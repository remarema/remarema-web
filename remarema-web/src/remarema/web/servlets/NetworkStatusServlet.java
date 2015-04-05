package remarema.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.beans.NetworkStatus;

/**
 * Servlet implementation class NetworkStatusServlet
 */
@WebServlet("/network_status")
public class NetworkStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NetworkStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NetworkStatus status = new NetworkStatus();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String parentID = request.getParameter("parentID");
		String parentName = request.getParameter("parentName");
		String nodeNames = request.getParameter("nodeName");
		String nodeIDs = request.getParameter("nodeIDs");
		
		status.setNetworkID(Integer.parseInt(id));
		
		request.setAttribute("id", status.getNetworkID());
		request.setAttribute("name", status.getNetworkName());
		request.setAttribute("parentID", status.getNetworkParentID());
		request.setAttribute("parentName", status.getNetworkParentName());
		request.setAttribute("nodeNames", status.getNodeNames().get(0));
		request.setAttribute("nodeIDs", status.getNodeIDs().get(0));
		
		request.getRequestDispatcher("/network_status.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Änderungen erfolgreich!");
		
		NetworkStatus status = new NetworkStatus();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String parentID = request.getParameter("parentID");
		String parentName = request.getParameter("parentName");
		String nodeNames = request.getParameter("nodeName");
		String nodeIDs = request.getParameter("nodeIDs");
		
		status.setNetworkID(Integer.parseInt(id));
		
		request.setAttribute("id", status.getNetworkID());
		request.setAttribute("name", status.getNetworkName());
		request.setAttribute("parentID", status.getNetworkParentID());
		request.setAttribute("parentName", status.getNetworkParentName());
		request.setAttribute("nodeNames", status.getNodeNames().get(0));
		request.setAttribute("nodeIDs", status.getNodeIDs().get(0));
		
		request.getRequestDispatcher("/network_status.jsp").forward(request, response);
	}

}
