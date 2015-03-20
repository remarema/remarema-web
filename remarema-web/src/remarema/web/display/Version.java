package remarema.web.display;

import remarema.web.main.Main;

/**
 * Returns stuff of versions Array.
 * 
 * @author Maik Riedlsperger
 * @version 0.020
 */
public class Version {
	
	/**
	 * Creates a dropdown menu to choose the version.
	 * 
	 * @param versions A array of the existing versions.
	 * @return Returns a html formatted String.
	 */
	public String versionList(){
		String versionString = "";			//Return String
		Main m = new Main();
        
		versionString = versionString + "<option>Wähle Softwareversion</option>";	//Add <option> Tag
		for(int i = 0; i < m.getVersions().size(); i++){
			versionString = versionString + "<option>" + m.getVersions().get(i).getVersionName(i) + "</option>";	//Add <option> Tag to every entry
		}
		
		return versionString;
	}
	
	/**
	 * Creates a dropdown menu to choose the packets.
	 * 
	 * @param versions A array of the existing packets.
	 * @return Returns a html formatted String.
	 */
	public String packetList(){
		String packetString = "";			//Return String
		Main m = new Main();
        
		
		for(int i = 0; i < m.getVersions().size(); i++){
			packetString = packetString + "<option>" + m.getVersions().get(i).getPacketName(i) + "</option>";	//Add <option> Tag to every entry
		}
		
		return packetString;
	}
	
}
