package br.com.edu.start;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author Eduardo
 */
public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(final String message, final Object... parameters) {
		super(message(message, parameters));
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public static String message(String message, Object... parameters) {
		MessageFormat formatter = new MessageFormat(message, Locale.getDefault());

		return formatter.format(parameters);
	}

}
