package remarema.web.beans;

import java.util.ArrayList;

public class NetworkStatus {
	
	private String networkName;
	private int networkID;
	private String networkParentName;
	private int networkParentID;
	private int nodeRM;
	private ArrayList<String> nodeNames = new ArrayList<String>();
	private ArrayList<Integer> nodeIDs = new ArrayList<Integer>();
	
	/*
	 * Debug stuff
	 */
	public NetworkStatus(){
		setNetworkID(1);
		setNetworkName("asdf");
		setNetworkParentID(111);
		setNetworkParentName("parentname");
		nodeNames.add("Node 01");
		nodeIDs.add(5);
	}
	
	public ArrayList<String> getNodeNames() {
		return nodeNames;
	}
	public void setNodeNames(ArrayList<String> nodeNames) {
		this.nodeNames = nodeNames;
	}
	public ArrayList<Integer> getNodeIDs() {
		return nodeIDs;
	}
	public void setNodeIDs(ArrayList<Integer> nodeIDs) {
		this.nodeIDs = nodeIDs;
	}
	public String getNetworkParentName() {
		return networkParentName;
	}
	public void setNetworkParentName(String networkParentName) {
		this.networkParentName = networkParentName;
	}
	public int getNetworkParentID() {
		return networkParentID;
	}
	public void setNetworkParentID(int networkParentID) {
		this.networkParentID = networkParentID;
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
	public void setNetworkID(int networkID) {
		this.networkID = networkID;
	}
	public int getNodeRM() {
		return nodeRM;
	}
	public void setNodeRM(int nodeRM) {
		this.nodeRM = nodeRM;
	}


}
