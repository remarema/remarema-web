package remarema.web.test;

public class Node {

	private String nodeName = "Node";
	private String nodeVersion = "1.0";
	private String nodeNetwork= "Net A";
	
	public String getNodeName(int i) {
		return nodeName + i;
	}

	public String getVersionName(int i) {
		return nodeVersion + i;
	}

	public String getNetworkName(int i) {
		return nodeNetwork + i;
	}

}
