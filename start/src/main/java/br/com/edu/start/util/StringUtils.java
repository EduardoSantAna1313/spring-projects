package br.com.edu.start.util;

/**
 * Métodos utilitários para String.
 * 
 * @author Eduardo
 *
 */
public final class StringUtils {

	/**
	 * 
	 */
	private StringUtils() {
		// N/A
	}

	/**
	 * verifica se a string é nula ou vazia.
	 * 
	 * @param pStr
	 * @return
	 */
	public static final boolean isNullOrEmpty(final String pStr) {
		return pStr == null || pStr.isEmpty();
	}

	/**
	 * Verifica se a string não é nula or vazia.
	 * 
	 * @param pStr
	 * @return
	 */
	public static final boolean isNotNullOrEmpty(final String pStr) {
		return !isNullOrEmpty(pStr);
	}

}