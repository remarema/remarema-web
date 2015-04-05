package remarema.web.beans;

public class NodeStatus {
	
	private String nodeName;
	private int nodeID;
	private String nodeIP;
	private String networkName;
	private int networkID;
	
	public NodeStatus(){
		nodeName = "test";
		nodeIP = "192.168.1.1";
		nodeID = 222;
		networkName = "Tolles Netzwerk";
		networkID = 123;
	}
	
	public String getNodeIP() {
		return nodeIP;
	}
	public void setNodeIP(String nodeIP) {
		this.nodeIP = nodeIP;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}
	public int getNetworkID() {
		return networkID;
	}
	public void setNetworkIP(int networkID) {
		this.networkID = networkID;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	

}
