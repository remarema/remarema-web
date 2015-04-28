package remarema.test;

import javax.persistence.*;

import remarema.services.network.NodeServiceBean;

public class TestNode {

	protected EntityManager em;

	public TestNode() {

	}

	public boolean Test() {
		NodeServiceBean n = new NodeServiceBean(em);
		// CreateNodeRequest p = new CreateNodeRequest("asdf", 1,
		// "111.111.111.111");
		// return n.createNode(p);
		return false;
	}
}
