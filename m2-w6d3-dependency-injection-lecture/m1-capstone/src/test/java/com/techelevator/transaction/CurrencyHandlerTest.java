package com.techelevator.transaction;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.exception.InvalidAmountException;


public class CurrencyHandlerTest {

	CurrencyHandler currencyHandler;
	
	@Before
	public void setup() {
		currencyHandler = new CurrencyHandler();
	}
	
	@Test
	public void add_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		Assert.assertEquals(10f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void add_multiple_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(1f);
		currencyHandler.addToBalance(2f);
		currencyHandler.addToBalance(7f);
		Assert.assertEquals(10f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void add_negative_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(5f);
		try {
			currencyHandler.addToBalance(-5f);
		} catch (InvalidAmountException e) {
			Assert.assertEquals(-5f, e.getInvalidAmount(), 2);
		}
		Assert.assertEquals(5f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void subtract_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		currencyHandler.substractFromBalance(1.15f);
		Assert.assertEquals(8.85f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void subtract_multiple_amounts() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		currencyHandler.substractFromBalance(1.15f);
		currencyHandler.substractFromBalance(3f);
		Assert.assertEquals(5.85f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void subtract_negative_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		currencyHandler.substractFromBalance(-5f);
		Assert.assertEquals(5f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void subtract_full_amount() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		currencyHandler.substractFromBalance(10f);
		Assert.assertEquals(0f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void subtract_too_much() throws InvalidAmountException {
		currencyHandler.addToBalance(10f);
		try {
			currencyHandler.substractFromBalance(12f);
		} catch (InvalidAmountException e) {
			Assert.assertEquals(12f, e.getInvalidAmount(), 2);
		}
		Assert.assertEquals(10f, currencyHandler.getBalance(), 2);
	}
	
	@Test
	public void verify_balance_reset_after_change_returned() throws InvalidAmountException {
		currencyHandler.addToBalance(2f);
		currencyHandler.substractFromBalance(.85f);
		Assert.assertEquals("Incorrect Balance after subtract", 1.15f, currencyHandler.getBalance(), 2);
		
		currencyHandler.getChange();
		Assert.assertEquals("Balance not reset after change returned", 0f, currencyHandler.getBalance(), 2);
		
	}
}
