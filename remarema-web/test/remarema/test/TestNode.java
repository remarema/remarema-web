package remarema.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import remarema.services.network.CreateNodeParameter;
import remarema.services.network.NodeServiceBean;

public class TestNode {

	@PersistenceContext
	protected EntityManager em;
	
	public TestNode(){
	    
	}
	
	public boolean Test(){
		NodeServiceBean n = new NodeServiceBean(em);
	    CreateNodeParameter p = new CreateNodeParameter("asdf", 1, "111.111.111.111");
	    return n.createNode(p);
	}
}
