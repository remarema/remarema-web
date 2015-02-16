package remarema.web;

/**
 * Formatting Arrays to display on a web Page.
 * 
 * @author Maik Riedlsperger
 * @version 0.012
 */
public class Web {
	
	/**
	 * Creates a dropdown menu for the options.
	 * 
	 * @param versions A array of the existing versions.
	 * @return Returns a html formatted String.
	 */
	public String versionList(String[] versions){
		String versionString = "";			//Return String
		
		for(int i = 0; i < versions.length; i++){
			versionString = versionString + "<option>" + versions[i] + "</option>";	//Add <option> Tag to every entry
		}
		
		return versionString;
	}
	
	/**
	 * Formats the list of clients.
	 * 
	 * @param client A array of the existing clients + information about the clients (network, credentials...).
	 * @return Returns a html formatted String.
	 */	
	public String clientList(String[][] clients){
		String clientList = "";						//Return String
		
		for(int i = 0; i < clients.length; i++){	//Format String		
			clientList = clientList + "<div class=\"row\"><div class=\"3u\"><input type=\"text\" name=\"client" + i + "\"placeholder=\"" + clients[i][0] + "\" /></div>";
			clientList = clientList + "<div class=\"3u\"><input type=\"text\" name=\"netzwerk" + i + "\" placeholder=\"" + clients[i][1] + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"text\" name=\"version" + i + "\" placeholder=\"" + clients[i][2] + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"verteilen" + i + "\" value=\"true\"></div>";
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"loeschen" + i + "\" value=\"true\"></div></div>";
		}

		
		return clientList;
	}
	
}
