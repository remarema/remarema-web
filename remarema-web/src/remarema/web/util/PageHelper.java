package remarema.web.util;

public class PageHelper {

	private int page = 0;
	private int pageEntries = 25;
	
	public int getPage() {
		return page;
	}
	
	public int getPageIncrement() {
		int page = this.page + 1;
		
		int lastPage = getLastPage();
		
		if(page > lastPage){					//There is no page greater than the last one
			page = lastPage;
		}
		
		return page;
	}
	
	public int getPageDecrement() {
		int page = this.page - 1;
		
		if(page < 1){							//There is no page smaller than 0
			page = 1;
		}
		
		return page;
	}
	
	public int getLastPage() {
		int networks = 800; 					//Get that from Database
		int lastPage = networks/pageEntries;
		
		return lastPage;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageEntries() {
		return pageEntries;
	}

	public void setPageEntries(int pageEntries) {
		this.pageEntries = pageEntries;
	}

	
}
