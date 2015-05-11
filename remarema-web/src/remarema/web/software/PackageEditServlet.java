package remarema.web.software;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.CreateNode;
import remarema.api.CreateSoftwareversion;
import remarema.api.PackageDetail;
import remarema.api.UpdatePackage;
import remarema.api.VersionDetail;
import remarema.services.network.IPNotValidException;
import remarema.services.software.SoftwarepackageServiceBean;
import remarema.services.software.SoftwareversionServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class PackageEditServlet
 */
@WebServlet("/package_edit")
public class PackageEditServlet extends HttpServlet {

	@Inject
	public SoftwarepackageServiceBean packageService;
	
	@Inject
	public SoftwareversionServiceBean softwareService;
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 3)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		Integer packageID = new Integer(request.getParameter("id"));
		PackageDetail packageDetail = new PackageDetail();
		packageDetail.setSoftwarepackageID(packageID);
		PackageDetail pkg = packageService
				.getPackageDetailForPackageID(packageDetail);

		request.setAttribute("id", pkg.getSoftwarepackageID());
		request.setAttribute("name", pkg.getSoftwarepackageName());		
		
		
		List<VersionDetail> version = softwareService.getVersionDetailForAllVersions(packageDetail);

		request.setAttribute("version", version);
		
		request.getRequestDispatcher("/package_edit.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 3)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		Integer packageID = new Integer(request.getParameter("id"));
		String packageName = request.getParameter("name");

		String action = request.getParameter("action");
		if (action.equals("update")) {

			UpdatePackage updatePackage = new UpdatePackage();
			updatePackage.setSoftwarepackageID(packageID);
			updatePackage.setSoftwarepackageName(packageName);

			request.setAttribute("id", packageID);
			request.setAttribute("name", packageName);
			packageService.updatePackage(updatePackage);

			PackageDetail packageDetail = new PackageDetail();
			packageDetail.setSoftwarepackageID(packageID);
			PackageDetail pkg = packageService
					.getPackageDetailForPackageID(packageDetail);

			request.setAttribute("id", pkg.getSoftwarepackageID());
			request.setAttribute("name", pkg.getSoftwarepackageName());
			request.setAttribute("message", "&Auml;nderungen erfolgreich!");
			request.getRequestDispatcher("/package_edit.jsp").forward(request,
					response);
		} else if (action.equals("delete")) {
			PackageDetail packageDetail = new PackageDetail();
			packageDetail.setSoftwarepackageID(packageID);
			packageService.removePackage(packageDetail);
			response.sendRedirect("/remarema/packages?message=Löschen erfolgreich!");
		} else if (action.equals("addSoftware")) {
			
			String softwareName = request.getParameter("softwareName");
			String softwarePath = request.getParameter("softwarePath");

			CreateSoftwareversion version = new CreateSoftwareversion();
			version.setSoftwareName(softwareName);
			version.setSoftwarePath(softwarePath);
			version.setSoftwarepackageName(packageName);

			softwareService.execute(version);

			request.setAttribute("message",
					"Softwareversion wurde erfolgreich hinzugef&uuml;gt!");
			
			request.setAttribute("id", packageID);
			request.setAttribute("name", packageName);
			request.getRequestDispatcher("/package_edit.jsp").forward(request,
					response);

		} else {
			request.getRequestDispatcher("/package_edit.jsp").forward(request,
					response);
		}

	}

}
