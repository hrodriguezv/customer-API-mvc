/**
 * 
 */
package com.consultecti.customer.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author amelendez
 * @since Sep 24, 2019
 */
public final class ValidatorUtil {

	private static final String DEFAULT_MESSAGE_VALIDATOR = "The %s can not be blank, zero or size less than or equal to zero. Avoid the wrong formats (numbers, email, etc.)";
	
	/**
	 * Return a <code>ValidationError</code> object with the name of the validated object and a
	 * list of the errors found.
	 * 
	 * @param validator
	 * @return <code>ValidationError</code>
	 */
	public static final ValidationError getValidationError(final BindingResult validator) {
		List<String> returnValue = new ArrayList<>();
		for (FieldError err : validator.getFieldErrors()) {
			returnValue.add(String.format(DEFAULT_MESSAGE_VALIDATOR, err.getField(), err.getDefaultMessage()));
		}
		return new ValidatorUtil.ValidationError(validator.getObjectName(), returnValue);
	}
	
	/**
	 * Internal Class for support the errors return type for any class.
	 */
	static class ValidationError {
		private String validatedClass;
		List<String> messagesErrors = new ArrayList<>();

		/**
		 * @param validatedClass
		 * @param messagesErrors
		 */
		public ValidationError(String validatedClass, List<String> messagesErrors) {
			this.validatedClass = validatedClass;
			this.messagesErrors = messagesErrors;
		}

		/**
		 * @return the validatedClass
		 */
		public String getValidatedClass() {
			return validatedClass;
		}

		/**
		 * @param validatedClass the validatedClass to set
		 */
		public void setValidatedClass(String validatedClass) {
			this.validatedClass = validatedClass;
		}

		/**
		 * @return the messagesErrors
		 */
		public List<String> getMessagesErrors() {
			return messagesErrors;
		}

		/**
		 * @param messagesErrors the messagesErrors to set
		 */
		public void setMessagesErrors(List<String> messagesErrors) {
			this.messagesErrors = messagesErrors;
		}
	}
}
