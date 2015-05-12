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

import remarema.api.CreateDeployment;
import remarema.api.DeployDetail;
import remarema.api.NetworkDetail;
import remarema.api.PackageDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.services.software.DeployServiceBean;
import remarema.services.software.SoftwarepackageServiceBean;
import remarema.services.software.SoftwareversionServiceBean;
import remarema.web.util.CookieHelper;
import remarema.web.util.Util;

/**
 * Servlet implementation class DistributeServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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

		methodEnd(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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

		methodEnd(request, response);
	}

	private void showAddedNetworks(HttpServletRequest request,
			ArrayList<NetworkDetail> liste) {
		if (!liste.isEmpty()) {
			String addedNetworksList = "<thead>" + "<tr>" + "<th>ID</th>"
					+ "<th>Name</th>" + "<th></th>" + "</tr>" + "</thead>";
			request.setAttribute("addedNetworksList", addedNetworksList);
		}
	}
	private void methodEnd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<PackageDetail> packageDetail = packageService.getPackageDetailForAllPackages();
		
		String options = "";
		for(int i = 0; i < packageDetail.size(); i++){
			options += "<option value=\"" + packageDetail.get(i).getSoftwarepackageID() + "\">" + packageDetail.get(i).getSoftwarepackageName() + "</option>";
		}
		request.setAttribute("options", options);
		
		List<DeployDetail> deployments = deployService.getDeployDetailForAllDeployments();
		
		request.setAttribute("deployments", deployments);
		
		Util util = new Util();
		String time = util.getDateTime();
		request.setAttribute("time", time);

		request.getRequestDispatcher("/distribute.jsp").forward(request,
				response);
	}

}
