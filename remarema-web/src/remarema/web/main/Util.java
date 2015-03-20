package remarema.web.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility Class (for function like Date/Time...)
 * 
 * @author Maik Riedlsperger
 * @version 0.012
 */
public class Util {
	
	/**
	 * Gets the current Date.
	 * 
	 * @return Current Date as String
	 */
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * Gets the current Date and the current Time.
	 * 
	 * @return Current Date + Time as String
	 */
	public String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * This method is used to give the menu point of the current page a special design/background.
	 * 
	 * @return ID activeMenu if the menu point should get a background
	 */
	public String activeMenu(String menu, String current_menu){
		if(menu.equals(current_menu)){
			return "activeMenu";
		}
		else{
			return "null";
		}
	}

}
