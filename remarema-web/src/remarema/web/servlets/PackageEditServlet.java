package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.NodeDetail;
import remarema.api.PackageDetail;
import remarema.api.UpdateNode;
import remarema.api.UpdatePackage;
import remarema.services.software.SoftwarepackageServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class PackageEditServlet
 */
@WebServlet("/package_edit")
public class PackageEditServlet extends HttpServlet {
	
	@Inject
	public SoftwarepackageServiceBean packageService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 3)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		Integer packageID = new Integer(request.getParameter("id"));
		PackageDetail packageDetail = new PackageDetail();
		packageDetail.setSoftwarepackageID(packageID);
		PackageDetail pkg = packageService.getPackageDetailForPackageID(packageDetail);
		
		
		request.setAttribute("id", pkg.getSoftwarepackageID());
		request.setAttribute("name", pkg.getSoftwarepackageName());
		request.getRequestDispatcher("/package_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(CookieHelper.checkCookie(request, 3)){
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		Integer packageID = new Integer(request.getParameter("id"));
		
		String action = request.getParameter("action");
		if(action.equals("update")){
			String name = request.getParameter("name");
			
			UpdatePackage updatePackage = new UpdatePackage();
			updatePackage.setSoftwarepackageID(packageID);
			updatePackage.setSoftwarepackageName(name);
			
			request.setAttribute("id", packageID);
			request.setAttribute("name", name);
			packageService.updatePackage(updatePackage);
			
			PackageDetail packageDetail = new PackageDetail();
			packageDetail.setSoftwarepackageID(packageID);
			PackageDetail pkg = packageService.getPackageDetailForPackageID(packageDetail);
			
			request.setAttribute("id", pkg.getSoftwarepackageID());
			request.setAttribute("name", pkg.getSoftwarepackageName());
			request.setAttribute("message", "&Auml;nderungen erfolgreich!");
			request.getRequestDispatcher("/package_edit.jsp").forward(request, response);
		}
		else if(action.equals("delete")){
			PackageDetail packageDetail = new PackageDetail();
			packageDetail.setSoftwarepackageID(packageID);
			packageService.removePackage(packageDetail);
			response.sendRedirect("/remarema/packages?message=Löschen erfolgreich!");
		}
		else{
			request.getRequestDispatcher("/package_edit.jsp").forward(request, response);
		}
		
	}

}
