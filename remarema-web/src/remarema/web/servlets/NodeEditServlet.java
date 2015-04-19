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
@WebServlet("/node_edit")
public class NodeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	
		String name = request.getParameter("name");
		String ip = request.getParameter("ip");
		String networkName = request.getParameter("networkName");
		String networkID = request.getParameter("networkID");
		
		
		
		
		request.getRequestDispatcher("/node_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Änderungen erfolgreich!");
			
		String name = request.getParameter("name");
		String ip = request.getParameter("ip");
		String networkName = request.getParameter("networkName");
		String networkID = request.getParameter("networkID");
		
		
		request.getRequestDispatcher("/node_edit.jsp").forward(request, response);
	}

}
