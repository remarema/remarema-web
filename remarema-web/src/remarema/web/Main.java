package remarema.web;

/*
 * Stuff I will need from the Database
 */
public class Main {

	public String test(){
        return "Hello World!";
    }

	public int getLebenszeit(){
        return 30;
    }
	
	public String[] getVersionen(){
		int versionAnzahl = 5;								//Soll aus Datenbank ausgelesen werden
		String[] versionen = new String[versionAnzahl];
		
		//Zukünftig Dynamisch durch Datenbank
			versionen[0] = "1.0";
			versionen[1] = "1.1";
			versionen[2] = "1.2";
			versionen[3] = "1.21";
			versionen[4] = "2.0";
		
        return versionen;
    }
	
	public String[][] getClients(){	
		int clientAnzahl = 2;								//Soll aus Datenbank ausgelesen werden
		
		String[][] clients = new String[clientAnzahl][3];
		
		//Zukünftig Dynamisch durch Datenbank
			clients[0][0] = "Client 01 Name";
			clients[0][1] = "Client 01 Netzwerk";
			clients[0][2] = "Client 01 Version";
			
			clients[1][0] = "Client 02 Name";
			clients[1][1] = "Client 02 Netzwerk";
			clients[1][2] = "Client 02 Version";
		
		return clients;
	}
}
