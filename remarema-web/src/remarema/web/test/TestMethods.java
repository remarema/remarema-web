package remarema.web.test;

import java.util.ArrayList;


public class TestMethods {

	/**
	 * Returns a List of all Networks
	 * 
	 * @return All Networks
	 */
	public static ArrayList<Network> getNetworks() {
		ArrayList<Network> networks = new ArrayList<Network>();
		networks.add(new Network());
		networks.add(new Network());
		networks.add(new Network());

		return networks;
	}

	/**
	 * Returns a List of all Nodes
	 * 
	 * @return All Nodes
	 */
	public static ArrayList<Node> getNodes() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node());
		nodes.add(new Node());
		nodes.add(new Node());

		return nodes;
	}

	/**
	 * Returns a List of all Deploys
	 * 
	 * @return All Deploys
	 */
	public static ArrayList<Deploy> getDeploys() {
		ArrayList<Deploy> deploys = new ArrayList<Deploy>();
		deploys.add(new Deploy());
		deploys.add(new Deploy());
		deploys.add(new Deploy());

		return deploys;
	}

	/**
	 * Returns a List of all Versions
	 * 
	 * @return All Versions
	 */
	public static ArrayList<Version> getVersions() {
		ArrayList<Version> versions = new ArrayList<Version>();
		versions.add(new Version());
		versions.add(new Version());
		versions.add(new Version());

		return versions;
	}
	
	/**
	 * Returns a List of all Settings
	 * 
	 * @return All Deploys
	 */
	public static ArrayList<Setting> getSettings() {
		ArrayList<Setting> settings = new ArrayList<Setting>();
		settings.add(new Setting());
		settings.add(new Setting());
		settings.add(new Setting());

		return settings;
	}

}
