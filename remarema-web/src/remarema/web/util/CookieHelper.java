package remarema.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Diese Klasse stellt Möglichkeiten, die Rechte eines Nutzers zu überprüfen,
 * sowie ein gesetztes Cookie zu löschen.
 */
public class CookieHelper {
	
	public CookieHelper(){
		
	}
	
	/**
	 * Diese Methode dient zur Überprüfung, ob ein Nutzer genug Rechte hat, eine
	 * bestimmte Seite anzuzeigen. Hierbei muss mitgegeben werden, welche
	 * Rechte für die jeweilige Page benötigt werden. Aus dem Cookie, welches
	 * nach einem erfolgreichen Log-In des Nutzers gesetzt wird, können die
	 * Rechte, welche der Nutzer besitzt, ausgelesen werden.
	 * 
	 * @param request
	 * @param neededRight Gibt an, welche Rechte benötigt werden, um eine bestimmte Seite anzeigen zu dürfen.
	 * @return Gibt <code>true</code> zurück, wenn der Nutzer die entsprechenden Rechte besitzt.
	 */
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
	
	/**
	 * Hier wird das Cookie, welches nach dem Einloggen eines Nutzers gesetzt wird,
	 * wieder gelöscht. Dies dient zum Ausloggen des Users.
	 * 
	 * @param request
	 * @param response
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie("right", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
	}

}
