package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import remarema.api.*;
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
     * @see HttpServlet#HttpServlet()
     */
    public AddNetworkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addnetwork.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String parent = request.getParameter("parent");
		
		CreateNetwork createNetwork = new CreateNetwork();
		createNetwork.setNetworkName(name);
		createNetwork.setParentNetworkName(parent);
		
		networkService.execute(createNetwork);
		
		request.setAttribute("message", "Netzwerk erfolgreich erstellt!");
		request.getRequestDispatcher("/addnetwork.jsp").forward(request, response);
	}

}
