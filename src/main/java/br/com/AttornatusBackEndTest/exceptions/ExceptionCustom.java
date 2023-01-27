package br.com.AttornatusBackEndTest.exceptions;

public class ExceptionCustom extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionCustom(String message) {
		super(message);
	}

	public ExceptionCustom(String message, Throwable cause) {
		super(message, cause);
	}
}
