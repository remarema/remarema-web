package remarema.web;

/*
 * Formatiert Arrays für die Webausgabe
 */
public class Web {
	
	public String versionenList(String[] versionen){
		String versionenString = "";			//String zur Rückgabe
		
		for(int i = 0; i < versionen.length; i++){
			versionenString = versionenString + "<option>" + versionen[i] + "</option>";	//Jede Version als <option> zurückgeben
		}
		
		return versionenString;
	}
	
	public String clientList(String[][] clients){
		String clientList = "";					//String zur Rückgabe
		
		for(int i = 0; i < clients.length; i++){		
			clientList = clientList + "<div class=\"row\"><div class=\"3u\"><input type=\"text\" name=\"client" + i + "\"placeholder=\"" + clients[i][0] + "\" /></div>";
			clientList = clientList + "<div class=\"3u\"><input type=\"text\" name=\"netzwerk" + i + "\" placeholder=\"" + clients[i][1] + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"text\" name=\"version" + i + "\" placeholder=\"" + clients[i][2] + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"verteilen" + i + "\" value=\"true\"></div>";
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"loeschen" + i + "\" value=\"true\"></div></div>";
		}

		
		return clientList;
	}
	
}
