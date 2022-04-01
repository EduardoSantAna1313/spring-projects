package br.com.edu.start.message;

import java.util.ResourceBundle;

/**
 * App messages loaded from messages.properties.
 * 
 * @author Eduardo
 */
public class AppMessages {

	private static ResourceBundle bundle = ResourceBundle.getBundle("messages");

	public static final String INFO_MANDATORY_FIELDS;

	public static final String RECORD_NOT_FOUND;

	public static final String SUCCESSFULLY_SAVED;

	static {
		INFO_MANDATORY_FIELDS = bundle.getString("info_mandatory_fields");
		SUCCESSFULLY_SAVED = bundle.getString("successfully_saved");
		RECORD_NOT_FOUND = bundle.getString("record_not_found");
	}

	private AppMessages() {
		// NA
	}

}
