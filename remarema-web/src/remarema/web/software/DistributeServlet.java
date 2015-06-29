package remarema.web.software;

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
import remarema.api.software.CreateDeployment;
import remarema.api.software.DeployDetail;
import remarema.api.software.PackageDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.services.software.DeployServiceBean;
import remarema.services.software.SoftwarepackageServiceBean;
import remarema.services.software.SoftwareversionServiceBean;
import remarema.web.networks.NetworkEditServlet;
import remarema.web.networks.NetworksServlet;
import remarema.web.util.CookieHelper;
import remarema.web.util.Util;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zur Anzeige aller Softwareverteilungen dar.
 * 
 * @see NetworksServlet
 */
@WebServlet("/distribute")
public class DistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	public NetworkServiceBean networkService;

	@Inject
	public DeployServiceBean deployService;
	
	@Inject
	public SoftwarepackageServiceBean packageService;

	@Inject
	public SoftwareversionServiceBean softwareService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DistributeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see NetworkEditServlet#doGet(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 1)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}
		CreateDeployment createDeployment = new CreateDeployment();
		ArrayList<NetworkDetail> liste = createDeployment.getNetworks();
		NetworkDetail nd = null;

		try {
			Integer networkID = new Integer(request.getParameter("id"));
			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkID(networkID);

			nd = networkService.getNetworkDetailForNetworkID(networkDetail);
		} catch (Exception e) {
		}

		String action = request.getParameter("action");

		if (action != null) {

			if (action.equals("delete")) {
				for (int i = 0; i < liste.size(); i++) {
					if (liste.get(i).getNetworkID().equals(nd.getNetworkID())) {
						liste.remove(i);
					}
				}

				request.setAttribute("message", "Das Netzwerk wurde entfernt!");

			} else if (action.equals("add")) {

				liste.add(nd);
				request.setAttribute("message",
						"Netzwerk erfolgreich hinzugef&uuml;gt!");
			}

			createDeployment.setNetworks(liste);
			request.setAttribute("addedNetworks", liste);
			showAddedNetworks(request, liste);
		}

		generalImports(request, response);
	}

	

	/**
	 * @see NetworkEditServlet#doPost(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 1)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		String action = request.getParameter("searchNetwork");
		if (action.equals("true")) {
			String networkName = request.getParameter("s");

			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkName(networkName);

			List<NetworkDetail> networks = networkService
					.getNetworkDetailForNetworkName(networkDetail);
			request.setAttribute("networks", networks);
			String search = "<thead>" + "<tr>" + "<th>ID</th>"
					+ "<th>Name</th>" + "<th></th>" + "</tr>" + "</thead>";
			request.setAttribute("search", search);
		}

		CreateDeployment createDeployment = new CreateDeployment();
		ArrayList<NetworkDetail> liste = createDeployment.getNetworks();
		request.setAttribute("addedNetworks", liste);

		showAddedNetworks(request, liste);

		generalImports(request, response);
	}

	
	/**
	 * Wird ein Netzwerk zur Verteilung hinzugefügt, wird auf der Weboberfläche 
	 * eine Tabelle mit den hinzugefügten Netzwerken dargestellt. 
	 * Die Methode zeigt nur die Spaltennamen!
	 * 
	 * @param request
	 * @param liste Wurde ein Netzwerk zur Liste hinzugefügt wird das "attribute" gesetzt.
	 * Ist die Liste leer, werden die Spaltennamen nicht ausgegeben. 
	 */
	private void showAddedNetworks(HttpServletRequest request,
			ArrayList<NetworkDetail> liste) {
		if (!liste.isEmpty()) {
			String addedNetworksList = "<thead>" + "<tr>" + "<th>ID</th>"
					+ "<th>Name</th>" + "<th></th>" + "</tr>" + "</thead>";
			request.setAttribute("addedNetworksList", addedNetworksList);
		}
	}
	
	/**
	 * Diese Methode erhält eine Liste aller Softwarepackages. Diese werden ausgelesen und 
	 * als Option auf der Weboberfläche angezeigt. Dadurch erhält der Benutzer eine Auswahl aller Packages. 
	 * 
	 * Des Weiteren lädt die Methode alle bevorstehenden Softwareverteilungen aus der Datenbank und zeigt diese
	 * ebenfalls auf der Weboberfläche an. 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void generalImports(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		//Ließt alle Softwarepackages ein und setzt das Attribute "option". 
		//Somit kann auf der Weboberfläche ein Packages für die Verteilung ausgewählt werden.
		List<PackageDetail> packageDetail = packageService.getPackageDetailForAllPackages();
		
		String options = "";
		for(int i = 0; i < packageDetail.size(); i++){
			options += "<option value=\"" + packageDetail.get(i).getSoftwarepackageID() + "\">" + packageDetail.get(i).getSoftwarepackageName() + "</option>";
		}
		request.setAttribute("options", options);
		
		
		//Zeigt bevorstehende Softwareverteilungen an
		List<DeployDetail> deployments = deployService.getDeployDetailForAllDeployments();
		request.setAttribute("deployments", deployments);
		
		Util util = new Util();
		String time = util.getDateTime();
		request.setAttribute("time", time);

		request.getRequestDispatcher("/distribute.jsp").forward(request,
				response);
	}

}
