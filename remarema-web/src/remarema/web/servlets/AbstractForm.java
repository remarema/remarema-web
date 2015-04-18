package remarema.web.servlets;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.ValidationMessage;

/**
 * Diese Klasse wird für die Verarbeitung und Validierung von HTML Formularen
 * verwendet.
 * 
 * Werden Daten eines Formulars an das Servlet zurückgeschickt, müssen die
 * Request-Parameter aus dem HttpServletRequest abgefragt, validiert und in das
 * gewünschte Ziel-Format konvertiert werden. Diese Klasse stellt die
 * Basisfunktion eines Formulars bereit.
 * 
 * Die Validierung eines Formulars wird mit dem Aufruf von
 * {@link #update(HttpServletRequest)} ausgeführt. Neu erzeugte Formular-Objekte
 * sind daher immer gültig.
 * 
 * @author mrodler
 *
 */
public abstract class AbstractForm {

	private List<ValidationMessage> messages;

	public AbstractForm() {
		messages = Collections.emptyList();
	}

	/**
	 * Diese Methode wird von Servlet aufgerufen um Daten aus dem
	 * HttpServletRequest an das Formular Objekt zu übergeben.
	 * 
	 * Nachdem Daten aus dem Request übernommen wurden, wird das Formular-Objekt
	 * validiert.
	 * 
	 * @param request
	 */
	public final void update(HttpServletRequest request) {
		try {
			updateFields(request);
		} finally {
			messages = validate();
		}
	}

	/**
	 * Abfrage ob Daten des aktuellen Formulars gültig sind.
	 * 
	 * @return true wenn das Formular gültig ist.
	 */
	public boolean isValid() {
		return messages.isEmpty();
	}

	public List<ValidationMessage> getMessages() {
		return Collections.unmodifiableList(messages);
	}

	public ValidationMessage getMessage(String id) {
		for (ValidationMessage validationMessage : messages) {
			if (id.equals(validationMessage.getId())) {
				return validationMessage;
			}
		}
		return null;
	}

	public List<ValidationMessage> validate() {
		return BeanValidation.validate(this);
	}

	public abstract void updateFields(HttpServletRequest request);

}
