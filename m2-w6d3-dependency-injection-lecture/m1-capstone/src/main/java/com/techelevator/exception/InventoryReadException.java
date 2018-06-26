package com.techelevator.exception;

/**
 * Thrown when the vending machines Inventory File cannot be read
 *
 */
@SuppressWarnings("serial")
public class InventoryReadException extends RuntimeException {

	private String source;
	
	public InventoryReadException(String message, String source) {
		super(message);
		this.source = source; 
	}
	
	public InventoryReadException(Throwable rootException, String message, String source) {
		super(message, rootException);
		this.source = source;
	}

	public String getSource() {
		return source;
	}
	
	public String getErrorMessage(){
		return "Failed to load inventory from " + source + " : " + super.getMessage();
	}

}
