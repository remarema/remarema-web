package remarema.web.software;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.CreateDeployment;
import remarema.api.NetworkDetail;
import remarema.services.software.DeployServiceBean;
/**
 * Servlet implementation class AddDistributeServlet
 */
@WebServlet(name = "add_distribute", urlPatterns = { "/add_distribute" })
public class AddDistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	public DeployServiceBean deployService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDistributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] addedNetworks = request.getParameterValues("addedNetworks[]");
		int softwareID = Integer.parseInt(request.getParameter("version"));
		String verteilung = request.getParameter("distribution");
		String installation = request.getParameter("installation");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date verteilungSoftware = null;
		Date installationVerteilung = null;
		
		try {
			verteilungSoftware = dateFormat.parse(verteilung);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			installationVerteilung = dateFormat.parse(installation);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<NetworkDetail> networkList = new ArrayList<>();
		for(String networks : addedNetworks){
			int id = Integer.parseInt(networks);
			NetworkDetail nd = new NetworkDetail();
			nd.setNetworkID(id);
			networkList.add(nd);
		}
		
		CreateDeployment deployment = new CreateDeployment();
		deployment.setNetworks(networkList);
		deployment.setSoftwareversionID(softwareID);
		deployment.setDeployDateTime(verteilungSoftware);
		deployment.setInstallationDateTime(installationVerteilung);
		
		
		deployService.execute(deployment);
		
		request.setAttribute("message", "Die Verteilung wurde erfolgreich angelegt!");
		request.getRequestDispatcher("/distribute.jsp").forward(request,
				response);
		
	}

}
