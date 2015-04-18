package remarema.web.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;

/**
 * Dieses Formular wird für die Neuanlage eines Netzwerks verwendet.
 * 
 * @author mrodler
 *
 */
public class AddNetworkForm extends AbstractForm {
	@NotNull
	@Size(min = 3, message = "Netzwerkname muss mindestens 3 Zeichen lang sein.")
	private String name;

	@NotNull
	@Size(min = 3, message = "Parent-Netzwerkname muss mindestens 3 Zeichen lang sein.")
	private String parent;

	public String getName() {
		return name;
	}

	public String getParent() {
		return parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void updateFields(HttpServletRequest request) {
		this.name = request.getParameter("name");
		this.parent = request.getParameter("parent");
	}

}
