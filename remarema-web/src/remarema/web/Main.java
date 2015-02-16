package remarema.web;

/*
 * Stuff I will need from the Database
 */
public class Main {

	/*
	 * Just some testing method
	 * 
	 * @return Hello World! :3
	 */
	public String test(){
        return "Hello World!";								
    }
	
	/*
	 * Returns the lifetime of a packet
	 * 
	 * @return Returns lifetime
	 */
	public int getLifetime(){
        return 30;
    }
	
	/*
	 * Returns a String of all existing versions
	 * 
	 * @return Returns versions
	 */
	public String[] getVersions(){
		int versionAnzahl = 5;								//Debug values - Will get the real ones from database
		String[] versionen = new String[versionAnzahl];
		
		//Will be read out of a database in the future
			versionen[0] = "1.0";
			versionen[1] = "1.1";
			versionen[2] = "1.2";
			versionen[3] = "1.21";
			versionen[4] = "2.0";
		
        return versionen;
    }
	
	/*
	 * Returns a String of all existing clients
	 * 
	 * @return Returns clients
	 */
	public String[][] getClients(){	
		int clientAnzahl = 2;								//Debug values - Will get the real ones from database
		
		String[][] clients = new String[clientAnzahl][3];
		
		//Will be read out of a database in the future
			clients[0][0] = "Client 01 Name";
			clients[0][1] = "Client 01 Netzwerk";
			clients[0][2] = "Client 01 Version";
			
			clients[1][0] = "Client 02 Name";
			clients[1][1] = "Client 02 Netzwerk";
			clients[1][2] = "Client 02 Version";
		
		return clients;
	}
}
