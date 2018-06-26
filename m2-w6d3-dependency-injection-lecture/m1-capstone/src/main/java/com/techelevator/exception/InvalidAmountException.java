package com.techelevator.exception;

/**
 * Thrown when an invalid amount is applied to the vending machines balance
 *
 */
@SuppressWarnings("serial")
public class InvalidAmountException extends Exception {

	private float amount;
	
	public InvalidAmountException(Throwable rootException, String message, float amount) {
		super(message, rootException);
		this.amount = amount;
	}

	public float getInvalidAmount() {
		return this.amount;
	}
	
	public String getErrorMessage(){
		return "Invalid Amount: " + amount + " : " + super.getMessage();
	}

}
