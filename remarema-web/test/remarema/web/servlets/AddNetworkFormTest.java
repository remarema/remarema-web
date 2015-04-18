package remarema.web.servlets;

import static org.junit.Assert.*;

import org.junit.*;

public class AddNetworkFormTest {

	private AddNetworkForm form;

	@Before
	public void setup() {
		form = new AddNetworkForm();
		form.setName("name");
		form.setParent("parent");
	}

	@Test
	public void when_name_is_empty_form_is_not_valid() {
		form.setName("");
		assertFalse(form.validate().isEmpty());
	}

	@Test
	public void when_network_is_empty_form_is_not_valid() {
		AddNetworkForm form = new AddNetworkForm();
		form.setParent("");
		assertFalse(form.validate().isEmpty());
	}

}
