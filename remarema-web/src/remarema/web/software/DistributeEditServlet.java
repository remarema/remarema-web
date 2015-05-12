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

import remarema.api.DeployDetail;
import remarema.api.NetworkDetail;
import remarema.api.PackageDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.services.software.DeployServiceBean;
import remarema.services.software.SoftwarepackageServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class NodeStatusServlet
 */
@WebServlet("/distribute_edit")
public class DistributeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static List<NetworkDetail> netDetail = new ArrayList<>();

	@Inject
	private DeployServiceBean deployService;

	@Inject
	private SoftwarepackageServiceBean packageService;

	@Inject
	private NetworkServiceBean networkService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DistributeEditServlet() {
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

		loadDeploymentAttributes(request);

		String action = request.getParameter("action");
		if (action != null) {
			
			Integer networkID = new Integer(request.getParameter("networkid"));
			Integer deployID = new Integer(request.getParameter("id"));

			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkID(networkID);

			NetworkDetail nd = networkService
					.getNetworkDetailForNetworkID(networkDetail);

			DeployDetail deployDetail = new DeployDetail();
			deployDetail.setDeployID(deployID);
			DeployDetail dd = deployService
					.getDeployDetailForDeployID(deployDetail);

			
			netDetail = dd.getNetworks();
			System.out.println(netDetail.toString());
			
			if (action.equals("delete")) {
				for (int i = 0; i < netDetail.size(); i++) {
					if (netDetail.get(i).getNetworkID()
							.equals(nd.getNetworkID())) {
						netDetail.remove(i);
						System.out.println(netDetail.toString());
					}
				}
				request.setAttribute("message", "Das Netzwerk wurde entfernt!");
			}
			else if (action.equals("add")) {

				netDetail.add(nd);
				System.out.println(netDetail.toString());
				request.setAttribute("message",
						"Netzwerk erfolgreich hinzugef&uuml;gt!");
			}

			dd.setNetworks(netDetail);
			request.setAttribute("addedNetworks", dd.getNetworks());
		}

		request.getRequestDispatcher("/distribute_edit.jsp").forward(request,
				response);

	}

	private void loadDeploymentAttributes(HttpServletRequest request) {
		int distributeID = Integer.parseInt(request.getParameter("id"));
		DeployDetail deployDetail = new DeployDetail();
		deployDetail.setDeployID(distributeID);
		DeployDetail dd = deployService
				.getDeployDetailForDeployID(deployDetail);

		request.setAttribute("id", dd.getDeployID());
		request.setAttribute("deploy", dd.getDeployDateTime());
		request.setAttribute("installation", dd.getInstallationDateTime());

		request.setAttribute("packageID", dd.getPackageID());
		request.setAttribute("packageName", dd.getPackageName());
		request.setAttribute("softwareID", dd.getSoftwareID());
		request.setAttribute("software", dd.getVersionName());
		request.setAttribute("addedNetworks", dd.getNetworks());

		List<PackageDetail> packageDetail = packageService
				.getPackageDetailForAllPackages();
		String addedNetworksList = "<thead>" + "<tr>" + "<th>ID</th>"
				+ "<th>Name</th>" + "<th></th>" + "</tr>" + "</thead>";
		request.setAttribute("addedNetworksList", addedNetworksList);
		String options = "";
		for (int i = 0; i < packageDetail.size(); i++) {
			if (!packageDetail.get(i).getSoftwarepackageName()
					.equals(dd.getPackageName())) {
				options += "<option value=\""
						+ packageDetail.get(i).getSoftwarepackageID() + "\">"
						+ packageDetail.get(i).getSoftwarepackageName()
						+ "</option>";
			}
		}
		request.setAttribute("options", options);
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
		loadDeploymentAttributes(request);

		Integer deployID = new Integer(request.getParameter("id"));
		String action = request.getParameter("action");

		String searchNetwork = request.getParameter("searchNetwork");
		if (searchNetwork.equals("true")) {
			String networkName = request.getParameter("s");

			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkName(networkName);

			List<NetworkDetail> networks = networkService
					.getNetworkDetailForNetworkName(networkDetail);
			request.setAttribute("networks", networks);
			String search = "<thead>" + "<tr>" + "<th>ID</th>"
					+ "<th>Name</th>" + "<th></th>" + "</tr>" + "</thead>";
			request.setAttribute("search", search);
			request.getRequestDispatcher("/distribute_edit.jsp").forward(
					request, response);
		} else if (action.equals("delete")) {
			DeployDetail deployDetail = new DeployDetail();
			deployDetail.setDeployID(deployID);
			deployService.removeDeploy(deployDetail);

			response.sendRedirect("/remarema/distribute?message=Die Verteilung wurde gelöscht!");

		} else {
			request.getRequestDispatcher("/distribute_edit.jsp").forward(
					request, response);
		}

	}

}
