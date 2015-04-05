package remarema.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.beans.ClientList;
import remarema.web.beans.NetworkList;

/**
 * Servlet implementation class ShowNetworksServlet
 */
@WebServlet("/shownetworks")
public class ShowNetworksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNetworksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NetworkList nl = new NetworkList();
		
		//Current page number
		String currentPageNumber = request.getParameter("page");
		int pageNumber = 0;
		
		try{							//If there is a page number -> parse it
			pageNumber = Integer.parseInt(currentPageNumber);
		}
		catch(NumberFormatException e){	//If there's none: Don't parse it and start the if below
			pageNumber = 0;
		}
		
		nl.setPage(pageNumber);
		
		//Lists clients
		request.setAttribute("networkList", nl.getList(pageNumber));
		
		//Page functions
		request.setAttribute("pageDecrement", nl.getPageDecrement());
		request.setAttribute("pageIncrement", nl.getPageIncrement());
		request.setAttribute("lastPage", nl.getLastPage());
		
		request.getRequestDispatcher("/shownetworks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
