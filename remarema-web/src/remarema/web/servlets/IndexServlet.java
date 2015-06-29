package remarema.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remarema.api.UserDetail;
import remarema.services.user.UserNotFoundException;
import remarema.services.user.UserServiceBean;
import remarema.web.util.CookieHelper;

/**
 * Diese Klasse stellt ein <code>Servlet</code> zur Anzeige einer Indexseite dar.
 * Diese wird dargestellt, wenn die Webseite betreten wird. Die Indexseite bietet
 * dem Nutzer die Möglichkeit, sich einzuloggen.
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	public UserServiceBean userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Über die <code>doGet()</code> Methode wird das Ausloggen des Nutzers realisiert.
	 * Hierbei werden mittels des <code>CookieHelpers</code> die zum Nutzer gehörenden 
	 * Cookies gelöscht und ihm die Möglichkeit geboten, sich erneut einzuloggen.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("logout")){
			CookieHelper.deleteCookie(request, response);
			request.setAttribute("message", "Logout erfolgreich!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**
	 * Die <code>doPost()</code> Methode regelt das Einloggen eines Nutzers.
	 * Hierbei wird ein <code>UserDetail</code> Objekt erzeugt, welches
	 * überprüft, ob die eingegebenen log-in Daten korrekt sind. Sollte dies
	 * nicht der Fall sein, wird der Nutzer auf die <code>loginerror.jsp</code>
	 * Seite weitergeleitet, welche ihm eine Fehlermeldung anzeigt.
	 * Bei der korrekten Eingabe der Daten wird über den <code>CookieHelper</code>
	 * ein neues <code>Cookie</code> erzeugt, damit der User eingeloggt bleibt.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDetail usd = new UserDetail();
			
			usd.setUserName(userName);
			usd.setUserPassword(password);
			
			try {
				int right = userService.checkUser(usd);
				Cookie userRight = new Cookie("right",right+"");
				userRight.setMaxAge(60*60*24*7);				//Cookie lasts for 7 days
	            response.addCookie(userRight);
				response.sendRedirect("/remarema/home");
			} catch (UserNotFoundException e) {
				request.setAttribute("message", e.getMessage());
				request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
			}
		}
		

		
	}

}
