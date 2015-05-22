package remarema.web.networks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import remarema.api.network.CreateNetwork;
import remarema.api.network.NetworkDetail;
import remarema.api.network.NodeDetail;
import remarema.services.network.NetworkServiceBean;
import remarema.web.util.CookieHelper;

@WebServlet("/networks")
public class NetworksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NetworkServiceBean networkService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 8)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		String message = request.getParameter("message");
		request.setAttribute("message", message);

		List<NetworkDetail> networks = networkService
				.getNetworkDetailForAllNetworks();

		if (networks.isEmpty()) {
			request.setAttribute("root",
					"<input type=\"submit\" value=\"Root-Netzwerk anlegen!\" />");
		} else {
			int pagesize = 5;
			
			if (networks.size() > pagesize) {
				int page = 0;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception e) {
					page = 0;
				} finally {
					int pageIncrement = page + 1;
					if (pageIncrement > networks.size() / pagesize) {
						pageIncrement = (int) Math.ceil(networks.size() / pagesize);
					}

					int pageDecrement = page - 1;
					if (pageDecrement < 0) {
						pageDecrement = 0;
					}
					String buttons = ""
							+ "<form method=\"get\" action=\"/remarema/networks\">"
							+ "<div class=\"row\">"
							+ "<div class=\"3u\"></div>"
							+ "<div class=\"3u\">"
							+ "<input type=\"hidden\" name=\"page\" value=\""
							+ pageDecrement
							+ "\" />"
							+ "<input type=\"submit\" value=\"<\" />"
							+ "</div></form>"
							+ "<form method=\"get\" action=\"/remarema/networks\">"
							+ "<div class=\"3u\">"
							+ "<input type=\"hidden\" name=\"page\" value=\""
							+ pageIncrement + "\" />"
							+ "<input type=\"submit\" value=\">\" />"
							+ "<div class=\"3u\"></div>"
							+ "</div>" + "</div></form>";
					request.setAttribute("buttons", buttons);

					ArrayList<NetworkDetail> networkOutput = new ArrayList<>();					
					int startpage = page * pagesize;
					int endpage = startpage + pagesize;
					
					if(endpage > networks.size()){
						int overflow = networks.size();
						while(overflow > pagesize){ overflow -= pagesize; }
						endpage = startpage + overflow;
					}
					for (int i = startpage; i < endpage; i++) {
						networkOutput.add(networks.get(i));
					}
					request.setAttribute("networks", networkOutput);
				}

			} else {
				request.setAttribute("networks", networks);
			}

		}
		show(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 8)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		String action = request.getParameter("action");
		if (action.equals("suche")) {
			String networkName = request.getParameter("s");

			NetworkDetail networkDetail = new NetworkDetail();
			networkDetail.setNetworkName(networkName);

			List<NetworkDetail> networks = networkService
					.getNetworkDetailForNetworkName(networkDetail);
			request.setAttribute("networks", networks);

			show(request, response);
		}
	}

	private RequestDispatcher getPage(HttpServletRequest request) {
		return request.getRequestDispatcher("/networks.jsp");
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getPage(request);
		dispatcher.forward(request, response);
	}

}
