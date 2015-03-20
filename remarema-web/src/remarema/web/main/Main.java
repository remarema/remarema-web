package remarema.web.main;

import java.util.ArrayList;

import remarema.web.test.Deploy;
import remarema.web.test.Network;
import remarema.web.test.Node;
import remarema.web.test.Setting;
import remarema.web.test.TestMethods;
import remarema.web.test.Version;

/**
 * Stuff I will need from the Database.
 * 
 * @author Maik Riedlsperger
 * @version 0.020
 */
public class Main {
	
	private ArrayList<Network> networks;
	private ArrayList<Node> nodes;
	private ArrayList<Deploy> deploys;
	private ArrayList<Version> versions;
	private ArrayList<Setting> settings;
	
	/**
	 * Stuff I need from Rebecca
	 */
	public Main(){
		setNetworks(new ArrayList<Network>());
		setNetworks(TestMethods.getNetworks());					//ArrayList of all Networks
		
		setNodes(new ArrayList<Node>());
		setNodes(TestMethods.getNodes());						//ArrayList of all Nodes
		
		setDeploys(new ArrayList<Deploy>());
		setDeploys(TestMethods.getDeploys());					//ArrayList of all Deploys
		
		setVersions(new ArrayList<Version>());
		setVersions(TestMethods.getVersions());					//ArrayList of all Versions
		
		setSettings(new ArrayList<Setting>());
		setSettings(TestMethods.getSettings());					//ArrayList of all Settings
	}



	/*
	 * Tons of Getters and Setters
	 */
	
	public ArrayList<Version> getVersions() {
		return versions;
	}

	public void setVersions(ArrayList<Version> versions) {
		this.versions = versions;
	}



	public ArrayList<Setting> getSettings() {
		return settings;
	}



	public void setSettings(ArrayList<Setting> settings) {
		this.settings = settings;
	}



	public ArrayList<Deploy> getDeploys() {
		return deploys;
	}



	public void setDeploys(ArrayList<Deploy> deploys) {
		this.deploys = deploys;
	}



	public ArrayList<Node> getNodes() {
		return nodes;
	}



	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}



	public ArrayList<Network> getNetworks() {
		return networks;
	}



	public void setNetworks(ArrayList<Network> networks) {
		this.networks = networks;
	}
}
