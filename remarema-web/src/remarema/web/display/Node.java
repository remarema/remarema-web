package remarema.web.display;

import remarema.web.main.Main;

/**
 * Formatting client Array to display on the web Page.
 * 
 * @author Maik Riedlsperger
 * @version 0.020
 */
public class Node {

	/**
	 * Formats the list of clients.
	 * 
	 * @param client A array of the existing clients + information about the clients (network, credentials...).
	 * @return Returns a html formatted String.
	 */	
	public String nodeList(){
		String clientList = "";						//Return String
		Main m = new Main();
		
		for(int i = 0; i < m.getNodes().size(); i++){	//Format String		
			clientList = clientList + "<div class=\"row\"><div class=\"3u\"><input type=\"text\" name=\"node" + i + "\"placeholder=\"" + m.getNodes().get(i).getNodeName(i) + "\" /></div>";
			clientList = clientList + "<div class=\"3u\"><input type=\"text\" name=\"netzwerk" + i + "\" placeholder=\"" + m.getNodes().get(i).getNetworkName(i) + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"text\" name=\"version" + i + "\" placeholder=\"" + m.getNodes().get(i).getVersionName(i) + "\" /></div>";	
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"verteilen" + i + "\" value=\"true\"></div>";
			clientList = clientList + "<div class=\"2u\"><input type=\"checkbox\" name=\"loeschen" + i + "\" value=\"true\"></div></div>";
		}

		
		return clientList;
	}
	
}
