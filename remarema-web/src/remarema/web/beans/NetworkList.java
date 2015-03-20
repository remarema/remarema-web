package remarema.web.beans;

import remarema.web.util.PageHelper;

/**
 * Returns a List of Networks
 * 
 * @author Maik Riedlsperger
 */
public class NetworkList extends PageHelper {
	
	/**
	 * Creates a list of networks (+ their clients) depending on what page you currently are.
	 * 
	 * @param currentPage The page, that should be shown. If there is no page selected the most recent networks get shown.
	 * @param pageEntries The number of networks, that should be displayed
	 * @return A String with some networks, that can be displayed on a web-page
	 */
	public String NetworkList(int currentPage){
		String page = "";
		
		if(currentPage == 0){		//Show the most recent updated networks
			page = "Insert most recently updated networks here";
		}
		else{							//Show a page of networks
			int start;
			int end;
			
			end = currentPage*getPageEntries();
			start = end-getPageEntries();
			end--;
			
			page = "MySQL Query " + start + " | " + end + "<br>Page: " + getPage() + " | " + getLastPage();
		}
		
		return page;
	}

	
}
