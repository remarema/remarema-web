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
@WebServlet("/network_edit")
public class NetworkEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String parentID = request.getParameter("parentID");
		String parentName = request.getParameter("parentName");
		String nodeNames = request.getParameter("nodeName");
		String nodeIDs = request.getParameter("nodeIDs");
		
		
		request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Änderungen erfolgreich!");
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String parentID = request.getParameter("parentID");
		String parentName = request.getParameter("parentName");
		String nodeNames = request.getParameter("nodeName");
		String nodeIDs = request.getParameter("nodeIDs");
		
	
		request.getRequestDispatcher("/network_edit.jsp").forward(request, response);
	}

}
