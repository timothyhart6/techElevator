package com.techelevator.transaction;

import java.util.Map;

import com.techelevator.exception.InvalidAmountException;
import com.techelevator.transaction.change.ChangeMaker;
import com.techelevator.transaction.change.Coin;

/**
 * Handles the current customer balance of the vending machine
 *
 */
public class CurrencyHandler {

	private float balance = 0.0f;
	private ChangeMaker changeMaker;
	
	/**
	 * Creates a new ChangeMaker and prepares the CurrencyHandler
	 */
	public CurrencyHandler() {
		changeMaker = new ChangeMaker();
	}
	
	
	/**
	 * Gets the current customer balance
	 * @return
	 */
	public float getBalance() {
		return this.balance;
	}
	
	
	/**
	 * Adds to the customer's balance
	 * Throws an InvalidAmountException if the requested amount is less than 0
	 * @param amount
	 * @return
	 * @throws InvalidAmountException
	 */
	public CurrencyHandler addToBalance(float amount) throws InvalidAmountException {
		if (amount < 0) {
			throw new InvalidAmountException(null, "Amount must be a positive number", amount);
		} 
		balance += amount;
		return this;
	}
	
	
	/**
	 * Subtracts from the customer's balance
	 * Throws and InvalidAmountException if the amount requested would result in a negative balance
	 * @param amount
	 * @return
	 * @throws InvalidAmountException
	 */
	public CurrencyHandler substractFromBalance(float amount) throws InvalidAmountException {
		if (balance - Math.abs(amount) < 0) {
			throw new InvalidAmountException(null, "Amount must be less than or equal to balance", amount);
		}
		balance -= Math.abs(amount);
		return this;
	}
	
	
	/**
	 * Gets the customer's change and resets the current balance to 0
	 * @return
	 */
	public Map<Coin, Integer> getChange() {
		Map<Coin, Integer> change = changeMaker.makeChange(balance);
		reset();
		return change;
	}
	
	private void reset() {
		this.balance = 0f;
	}
}
