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
 * Servlet implementation class IndexServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**
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
				userRight.setMaxAge(30*60);
	            response.addCookie(userRight);
				response.sendRedirect("/remarema/home");
			} catch (UserNotFoundException e) {
				request.setAttribute("message", e.getMessage());
				request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
			}
		}
		else if(action.equals("logout")){
			CookieHelper.deleteCookie(request, response);
			request.setAttribute("message", "Logout erfolgreich!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		
	}

}
