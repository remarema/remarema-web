package remarema.web.servlets;

import java.util.*;

import javax.servlet.jsp.tagext.ValidationMessage;
import javax.validation.*;

public final class BeanValidation {
	private static final BeanValidation INSTANCE = new BeanValidation();

	private ValidatorFactory validatorFactory;

	private BeanValidation() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
	}

	public final Validator getValidator() {
		return validatorFactory.getValidator();
	}

	public static final List<ValidationMessage> validate(Object bean) {
		Validator validator = INSTANCE.getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(bean);
		if (violations.isEmpty()) {
			return Collections.emptyList();
		}
		return convertViolationsToValidationMessages(violations);
	}

	private static List<ValidationMessage> convertViolationsToValidationMessages(
			Set<ConstraintViolation<Object>> violations) {
		List<ValidationMessage> result = new ArrayList<>(violations.size());
		for (ConstraintViolation<?> violation : violations) {
			ValidationMessage message = buildValidationMessage(violation);
			result.add(message);
		}
		return result;
	}

	private static ValidationMessage buildValidationMessage(
			ConstraintViolation<?> violation) {
		String path = createPropertyPath(violation);
		String message = createMessage(violation);
		return new ValidationMessage(path, message);
	}

	private static String createMessage(ConstraintViolation<?> violation) {
		return violation.getMessage();
	}

	private static String createPropertyPath(ConstraintViolation<?> violation) {
		Path propertyPath = violation.getPropertyPath();
		if (propertyPath == null) {
			return null;
		}
		return propertyPath.toString();
	}
}
