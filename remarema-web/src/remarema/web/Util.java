package remarema.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Utility Class (for function like Date/Time...)
 */
public class Util {
	
	/*
	 * Gets the current Date
	 */
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/*
	 * Gets the current Date and the current Time
	 */
	public String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
