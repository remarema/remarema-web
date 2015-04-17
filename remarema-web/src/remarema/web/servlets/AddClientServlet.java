package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.CreateNode;
import remarema.services.network.NodeServiceBean;

/**
 * Servlet implementation class AddClientServlet
 */
@WebServlet("/addclient")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NodeServiceBean nodeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addclient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Client erfolgreich erstellt!");
		
		String name = request.getParameter("clientName");
		String ip = request.getParameter("clientIP");
		String network = request.getParameter("clientNetwork");
		
		CreateNode createNode = new CreateNode();
		createNode.setNodeName(name);
		createNode.setNodeIP(ip);
		createNode.setNodeNetworkName(network);

		nodeService.execute(createNode);
		

		request.setAttribute("message", "Node erfolgreich erstellt!");
		request.getRequestDispatcher("/addclient.jsp").forward(request, response);
	}

}
