package com.techelevator.transaction.change;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ChangeMakerTest {

	private ChangeMaker changeMaker;
	
	@Before
	public void setup() {
		changeMaker = new ChangeMaker();
	}
	
	@Test
	public void return_1_quarter() {
		Map<Coin, Integer> change = changeMaker.makeChange(.25f);
		
		Assert.assertEquals("Too many coinis returned", 1, change.size());
		
		for (Coin coin : change.keySet()) {
			if (!(coin instanceof Quarter)) {
				Assert.fail("Quarter not returned: " + coin.getClass().getSimpleName());
			}
			Assert.assertEquals("Wrong number of Quarters Returned", 1, change.get(coin).intValue());
		}
	}
	
	@Test
	public void return_1_dime() {
		Map<Coin, Integer> change = changeMaker.makeChange(.10f);
		
		Assert.assertEquals("Too many coinis returned", 1, change.size());
		
		for (Coin coin : change.keySet()) {
			if (!(coin instanceof Dime)) {
				Assert.fail("Dime not returned: " + coin.getClass().getSimpleName());
			}
			Assert.assertEquals("Wrong number of Dimes Returned", 1, change.get(coin).intValue());
		}
	}
	
	@Test
	public void return_1_nickel() {
		Map<Coin, Integer> change = changeMaker.makeChange(.05f);
		
		Assert.assertEquals("Too many coinis returned", 1, change.size());
		
		for (Coin coin : change.keySet()) {
			if (!(coin instanceof Nickel)) {
				Assert.fail("Nickel not returned: " + coin.getClass().getSimpleName());
			}
			Assert.assertEquals("Wrong number of Nickel Returned", 1, change.get(coin).intValue());
		}
	}
	
	@Test 
	public void change_for__2_dollars() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(2f);
		
		Assert.assertEquals("Too many coinis returned", 1, change.size());
		
		for (Coin coin : change.keySet()) {
			if (!(coin instanceof Quarter)) {
				Assert.fail("Quarter not returned: " + coin.getClass().getSimpleName());
			}
			Assert.assertEquals("Wrong number of Quarters Returned", 8, change.get(coin).intValue());
		}
	}
	
	@Test 
	public void change_for_80_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(.8f);
		
		Assert.assertEquals("Wrong number of coinis returned", 2, change.size());
		
		Assert.assertEquals(3, change.get(new Quarter()).intValue());
		Assert.assertEquals(1, change.get(new Nickel()).intValue());
	
	}
	
	@Test 
	public void change_for_1_dollar_15_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(1.15f);
		
		Assert.assertEquals("Wrong number of coinis returned", 3, change.size());
		
		Assert.assertEquals(4, change.get(new Quarter()).intValue());
		Assert.assertEquals(1, change.get(new Nickel()).intValue());
		Assert.assertEquals(1, change.get(new Dime()).intValue());
	}
	
	@Test 
	public void change_for_85_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(.85f);
		
		Assert.assertEquals("Wrong number of coinis returned", 2, change.size());
		
		Assert.assertEquals(3, change.get(new Quarter()).intValue());
		Assert.assertEquals(1, change.get(new Dime()).intValue());
	
	}
	
	@Test 
	public void change_for_20_dollars_and_15_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(20.15f);
		
		Assert.assertEquals("Wrong number of coinis returned", 3, change.size());
		
		Assert.assertEquals(80, change.get(new Quarter()).intValue());
		Assert.assertEquals(1, change.get(new Dime()).intValue());
		Assert.assertEquals(1, change.get(new Nickel()).intValue());
	}
	
	@Test 
	public void change_for_15_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(.15f);
		
		Assert.assertEquals("Wrong number of coinis returned", 2, change.size());
		
		Assert.assertEquals(1, change.get(new Dime()).intValue());
		Assert.assertEquals(1, change.get(new Nickel()).intValue());	
	}
	
	@Test 
	public void no_change_for_2_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(.02f);
		
		Assert.assertEquals("Wrong number of coinis returned", 0, change.size());
		
	}
	
	@Test 
	public void no_change_for_0_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(.02f);
		
		Assert.assertEquals("Wrong number of coinis returned", 0, change.size());
		
	}
	
	@Test 
	public void no_change_for_negative_50_cents() {
		
		Map<Coin, Integer> change = changeMaker.makeChange(-.5f);
		
		Assert.assertEquals("Wrong number of coinis returned", 0, change.size());
		
	}
}
