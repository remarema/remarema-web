package remarema.web.software;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.software.PackageDetail;
import remarema.api.software.VersionDetail;
import remarema.services.software.SoftwareversionServiceBean;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zur Ermittlung
 * eines Softwarepaketes mittels dessen ID dar. Dies wird
 * benötigt, wenn mittels eines AJAX Aufrufes, das entsprechende
 * Paket benötigt wird.
 */
@WebServlet("/VersionsByPackageIdServlet")
public class VersionsByPackageIdServlet extends HttpServlet {
	
	@Inject 
	public SoftwareversionServiceBean softwareService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VersionsByPackageIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Diese Methode generiert mittels der ID eines Packages einen JSON-String,
	 * welcher alle Softwareversionen des Paketes beinhält. Dieser kann danach
	 * in der entsprechenden <code>.jsp</code> Datei mittels <code>AJAX</code>
	 * und <code>Javascript</code> verwertet werden.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int packageID = Integer.parseInt(request.getParameter("PackageId"));
		
		PackageDetail packageDetail = new PackageDetail();
		packageDetail.setSoftwarepackageID(packageID);
		
		List<VersionDetail> softwareversions = softwareService.getVersionDetailForAllVersions(packageDetail);
		
		ArrayList<String> temp = new ArrayList<>();
		for (VersionDetail i : softwareversions)
		{
			temp.add("{\"Id\": " + i.getSoftwareID() + ",\"Version\": \"" + i.getSoftwareName().replace("\"", "\\\"") + "\"}");
		}
		response.getWriter().write("[" + join(",", temp) + "]");
	}
	
	private String join(String delimiter, List<String> items)
	{
		String temp = "";
		Iterator<String> iterator = items.iterator();
		if (iterator.hasNext())
		{
			temp += iterator.next();
			while (iterator.hasNext())
			{
				temp += delimiter;
				temp += iterator.next();
			}
		}
		return temp;
	}

}
