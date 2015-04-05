package remarema.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.beans.NetworkStatus;
import remarema.web.beans.NodeStatus;

/**
 * Servlet implementation class NodeStatusServlet
 */
@WebServlet("/node_status")
public class NodeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NodeStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NodeStatus status = new NodeStatus();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ip = request.getParameter("ip");
		String networkName = request.getParameter("networkName");
		String networkID = request.getParameter("networkID");
		
		status.setNodeID(Integer.parseInt(id));
		
		request.setAttribute("id", status.getNodeID());
		request.setAttribute("name", status.getNodeName());
		request.setAttribute("ip", status.getNodeIP());
		request.setAttribute("networkName", status.getNetworkName());
		request.setAttribute("networkID", status.getNetworkID());
		
		request.getRequestDispatcher("/node_status.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Änderungen erfolgreich!");
		
		NodeStatus status = new NodeStatus();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ip = request.getParameter("ip");
		String networkName = request.getParameter("networkName");
		String networkID = request.getParameter("networkID");
		
		status.setNodeID(Integer.parseInt(id));
		
		request.setAttribute("id", status.getNodeID());
		request.setAttribute("name", status.getNodeName());
		request.setAttribute("ip", status.getNodeIP());
		request.setAttribute("networkName", status.getNetworkName());
		request.setAttribute("networkID", status.getNetworkID());
		
		request.getRequestDispatcher("/node_status.jsp").forward(request, response);
	}

}
