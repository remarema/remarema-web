package remarema.web.software;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.software.UpdateVersion;
import remarema.api.software.VersionDetail;
import remarema.services.software.SoftwareversionServiceBean;
import remarema.web.networks.NetworkEditServlet;
import remarema.web.util.CookieHelper;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zum Editieren von Softwarversionen dar.
 * 
 * @see NetworkEditServlet
 */
@WebServlet(name = "software_edit", urlPatterns = { "/software_edit" })
public class SoftwareEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	public SoftwareversionServiceBean softwareService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SoftwareEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see NetworkEditServlet#doGet(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 3)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		Integer versionID = new Integer(request.getParameter("id"));
		String packageID = request.getParameter("packageID");
		VersionDetail versionDetail = new VersionDetail();
		versionDetail.setSoftwareID(versionID);

		VersionDetail software = softwareService
				.getVersionDetailForVersionID(versionDetail);

		request.setAttribute("id", software.getSoftwareID());
		request.setAttribute("name", software.getSoftwareName());
		request.setAttribute("path", software.getSoftwarePath());
		
		request.setAttribute("packageID", software.getSoftwarepackageID());
		request.setAttribute("packageName", software.getSoftwarepackageName());

		request.getRequestDispatcher("/software_edit.jsp").forward(request,
				response);
	}

	/**
	 * @see NetworkEditServlet#doPost(HttpServletRequest, HttpServletResponse)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 3)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}
		Integer versionID = new Integer(request.getParameter("id"));
		String packageID = request.getParameter("packageID");
		String action = request.getParameter("action");
		if (action.equals("update")) {

			String softwareName = request.getParameter("name");
			String softwarePath = request.getParameter("path");
			String packageName = request.getParameter("packageName");

			UpdateVersion updateVersion = new UpdateVersion();
			updateVersion.setSoftwareID(versionID);
			updateVersion.setSoftwareName(softwareName);
			updateVersion.setSoftwarePath(softwarePath);
			updateVersion.setSoftwarepackageName(packageName);

			request.setAttribute("id", versionID);
			request.setAttribute("name", softwareName);
			request.setAttribute("path", softwarePath);
			request.setAttribute("packageName", packageName);

			softwareService.updateVersion(updateVersion);

			VersionDetail versionDetail = new VersionDetail();
			versionDetail.setSoftwareID(versionID);
			VersionDetail software = softwareService
					.getVersionDetailForVersionID(versionDetail);
			request.setAttribute("packageID", software.getSoftwarepackageID());

			request.setAttribute("message", "&Auml;nderungen erfolgreich!");
			request.getRequestDispatcher("/software_edit.jsp").forward(request,
					response);
		} else if (action.equals("delete")) {
			VersionDetail versionDetail = new VersionDetail();
			versionDetail.setSoftwareID(versionID);
			softwareService.removeVersion(versionDetail);
			response.sendRedirect("/remarema/packages?message=Löschen erfolgreich!");

		} else {
			request.getRequestDispatcher("/software_edit.jsp").forward(request,
					response);
		}

	}

}
