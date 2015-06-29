package remarema.web.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Diese Klasse bietet Hilfsfunktionen, um die aktuelle Zeit zu ermitteln.
 * Weiters stellt sie fest, bei welchem Menüpunkt sich der Nutzer befindet.
 */
public class Util {
	
	/**
	 * Diese Methode gibt das heutige Datum in Form eines Strings zurück.
	 * 
	 * @return Heutiges Datum als String
	 */
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * Diese Methode gibt das heutige Datum, sowie die derzeitige Uhrzeit,
	 * in Form eines Strings zurück.
	 * 
	 * @return Heutiges Datum, sowie Uhrzeit, als String
	 * @see Util#getDate()
	 */
	public String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * Diese Methode dient zur Überprüfung, auf welchem Menüpunkt sich der
	 * Nutzer derzeit befindet. Dieser wird farblich hervorgehoben
	 * 
	 * @return activeMenu: Wird zurückgegeben, wenn der Menüpunkt, auf dem sich
	 * der Nutzer befindet, derzeit aktiv ist.
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
