package remarema.web.display;

import remarema.web.main.Main;

/**
 * Returns stuff of settings Array.
 * 
 * @author Maik Riedlsperger
 * @version 0.020
 */
public class Setting {
	
	/**
	 * Returns the lifetime of a packet.
	 * 
	 * @return Returns lifetime.
	 */
	public int getLifetime(){
		Main m = new Main();
        return m.getSettings().get(0).getLifetime();
    }

}
