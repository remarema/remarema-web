package remarema.web;

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

}
