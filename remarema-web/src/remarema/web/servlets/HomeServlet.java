package remarema.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.network.NetworkDetail;
import remarema.api.network.NodeDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.services.network.NodeServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NetworkServiceBean networkService;
	
	@Inject
	private NodeServiceBean nodeService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 10)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
				
		List<NetworkDetail> networks = networkService
				.getNetworkDetailForAllNetworks();
		List<NodeDetail> nodes = nodeService
				.getNodeDetailForAllNodes();
		
		ArrayList<String> stats = new ArrayList<>();
		stats.add("Netzwerke </td><td>" + networks.size());
		stats.add("Clients </td><td>" + nodes.size());
		
		
		ArrayList<String> rights = new ArrayList<>();
		ArrayList<String> rightValues = new ArrayList<>();
		
		for(int i = 0; i <= 10; i++){
			if(!CookieHelper.checkCookie(request, i)){
				rightValues.add("<b><font color=\"#007700\">True</font></b>");
			}
			else{
				rightValues.add("<font color=\"#770000\">False</font>");
			}
		}
		
		rights.add("Client&uuml;bersicht </td><td>" + rightValues.get(9));
		rights.add("Netzwerk&uuml;bersicht </td><td>" + rightValues.get(8));
		rights.add("Package&uuml;bersicht </td><td>" + rightValues.get(7));
		
		rights.add("Clients, Netzwerke, Packages hinzuf&uuml;gen/bearbeiten </td><td>" + rightValues.get(5));
		
		rights.add("Verteilungs&uuml;bersicht, Verteilungen hinzuf&uuml;gen/bearbeiten  </td><td>" + rightValues.get(1));
		
		
		
		
		request.setAttribute("stats", stats);
		request.setAttribute("rights", rights);
		
		
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
