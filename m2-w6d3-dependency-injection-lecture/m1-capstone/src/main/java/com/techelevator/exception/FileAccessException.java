package com.techelevator.exception;

/**
 * Exception for failure to open a needed file (Log or Sales Report)
 *
 */
@SuppressWarnings("serial")
public class FileAccessException extends RuntimeException {

	private String source;
	
	public FileAccessException(Throwable rootException, String message, String source) {
		super(message, rootException);
		this.source = source;
	}

	public String getSource() {
		return source;
	}
	
	public String getErrorMessage(){
		return "Failed to load from file: " + source + " : " + super.getMessage();
	}

}
