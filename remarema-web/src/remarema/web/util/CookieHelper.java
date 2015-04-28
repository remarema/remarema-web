package remarema.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {
	
	public CookieHelper(){
		
	}
	
	public static boolean checkCookie(HttpServletRequest request, int neededRight){
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
		for(Cookie cookie : cookies){
		    if(cookie.getName().equals("right")) cookieValue = cookie.getValue();
		    }
	    
			int cookieInt = Integer.parseInt(cookieValue);
		    
			if(cookieInt <= neededRight){
				return false;
			}
		}
		
		return true;
	}
	
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response){
		for (Cookie cookie : request.getCookies()) {
		    cookie.setValue("");
		    cookie.setMaxAge(-1);
		    cookie.setPath("/");

		    response.addCookie(cookie);
		}
	}

}
