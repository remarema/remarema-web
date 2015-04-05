package remarema.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.web.display.Setting;

/**
 * Servlet implementation class PropertiesServlet
 */
@WebServlet("/properties")
public class PropertiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertiesServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Setting s = new Setting();

		String lifetime = request.getParameter("lifetime");
		request.setAttribute("lifetime", s.getLifetime());
		
		request.getRequestDispatcher("/properties.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("message", "Erfolgreich upgedated!");
		
		Setting s = new Setting();
		String lifetime = request.getParameter("lifetime");
		request.setAttribute("lifetime", s.getLifetime());
		
		request.getRequestDispatcher("/properties.jsp").forward(request, response);
	}

}
