package remarema.web.networks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.network.NetworkDetail;
import remarema.api.network.NodeDetail;
import remarema.services.network.NodeServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Servlet implementation class NodesServlet
 */
@WebServlet("/nodes")
public class NodesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NodeServiceBean nodeService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 9)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		List<NodeDetail> nodes = nodeService.getNodeDetailForAllNodes();
		
		int pagesize = 5;

		if (nodes.size() > pagesize) {
			int page = 0;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				page = 0;
			} finally {
				int pageIncrement = page + 1;
				if (pageIncrement > nodes.size() / pagesize) {
					pageIncrement = (int) Math.ceil(nodes.size() / pagesize);
				}

				int pageDecrement = page - 1;
				if (pageDecrement < 0) {
					pageDecrement = 0;
				}
				String buttons = ""
						+ "<form method=\"get\" action=\"/remarema/nodes\">"
						+ "<div class=\"row\">"
						+ "<div class=\"3u\"></div>"
						+ "<div class=\"3u\">"
						+ "<input type=\"hidden\" name=\"page\" value=\""
						+ pageDecrement + "\" />"
						+ "<input type=\"submit\" value=\"<\" />"
						+ "</div></form>"
						+ "<form method=\"get\" action=\"/remarema/nodes\">"
						+ "<div class=\"6u\">"
						+ "<input type=\"hidden\" name=\"page\" value=\""
						+ pageIncrement + "\" />"
						+ "<input type=\"submit\" value=\">\" />" + "</div>"
						+ "<div class=\"3u\"></div>"
						+ "</div></form>";
				request.setAttribute("buttons", buttons);

				ArrayList<NodeDetail> nodeOutput = new ArrayList<>();
				int startpage = page * pagesize;
				int endpage = startpage + pagesize;

				if (endpage > nodes.size()) {
					int overflow = nodes.size();
					while (overflow > pagesize) {
						overflow -= 100;
					}
					endpage = startpage + overflow;
				}
				for (int i = startpage; i < endpage; i++) {
					nodeOutput.add(nodes.get(i));
				}
				request.setAttribute("nodes", nodeOutput);
			}
		} else {
			request.setAttribute("nodes", nodes);
		}

		String message = request.getParameter("message");
		request.setAttribute("message", message);

		show(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (CookieHelper.checkCookie(request, 9)) {
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}

		String action = request.getParameter("action");
		if (action.equals("suche")) {
			String nodeName = request.getParameter("s");

			NodeDetail nodeDetail = new NodeDetail();
			nodeDetail.setNodeName(nodeName);

			List<NodeDetail> nodes = nodeService
					.getNodeDetailForNodeName(nodeDetail);
			request.setAttribute("nodes", nodes);

			show(request, response);
		}

	}

	private RequestDispatcher getPage(HttpServletRequest request) {
		return request.getRequestDispatcher("/nodes.jsp");
	}

	private void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getPage(request);
		dispatcher.forward(request, response);
	}
}
