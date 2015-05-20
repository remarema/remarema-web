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

import remarema.api.network.NetworkDetail;
import remarema.api.software.CreateDeployment;
import remarema.api.software.UpdateDeploy;
import remarema.services.software.DeployServiceBean;

/**
 * Servlet implementation class UpdateDistributeServlet
 */
@WebServlet(name = "update_distribute", urlPatterns = { "/update_distribute" })
public class UpdateDistributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	public DeployServiceBean deployService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDistributeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Integer deployID = new Integer(request.getParameter("id"));
		String[] addedNetworks = request.getParameterValues("addedNetworks[]");
		int softwareID = Integer.parseInt(request.getParameter("version"));
		String verteilung = request.getParameter("distribution");
		String installation = request.getParameter("installation");
	
		System.out.println(addedNetworks[0]);

		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Date verteilungSoftware = null;
		Date installationVerteilung = null;

		try {
			verteilungSoftware = dateFormat.parse(verteilung);
		} catch (ParseException | NullPointerException e) {
			System.err
					.print("Der Verteilungszeitpunkt konnte nicht korrekt geparsed werden!");
			e.printStackTrace();
		}

		try {
			installationVerteilung = dateFormat.parse(installation);
		} catch (ParseException | NullPointerException e) {
			System.err
					.print("Der Installationszeitpunkt konnte nicht korrekt geparsed werden!");
			e.printStackTrace();
		}

		System.out.println("Installationszeitpunkt: " + installationVerteilung);

		ArrayList<NetworkDetail> networkList = new ArrayList<>();
		for (String networks : addedNetworks) {
			int networkID = Integer.parseInt(networks);
			System.out.println(networkID);
			NetworkDetail nd = new NetworkDetail();
			nd.setNetworkID(networkID);
			networkList.add(nd);
		}

		UpdateDeploy updateDeploy = new UpdateDeploy();
		updateDeploy.setDeployID(deployID);
		updateDeploy.setNetworks(networkList);
		updateDeploy.setSoftwareversionID(softwareID);
		updateDeploy.setDeployDateTime(verteilungSoftware);
		updateDeploy.setInstallationDateTime(installationVerteilung);

		System.out.println(updateDeploy.getDeployID() + ", "
				+ updateDeploy.getDeployDateTime() + ", "
				+ updateDeploy.getInstallationDateTime() + ", "
				+ updateDeploy.getNetworks());
		
		deployService.updateDeploy(updateDeploy);

		request.getRequestDispatcher("/distribute.jsp").forward(request,
				response);
	}

}
