package com.techelevator.transaction.change;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Handles determining the best types and counts of coins to return to the customer as change
 *
 */
public class ChangeMaker {

	private static final Coin[] coins = new Coin[] { new Quarter(), new Dime(), new Nickel() };
	
	
	/**
	 * Determines the best number and coins to return as change using the passed balance.
	 * The resulting Map contains the Coin type as a Key and the count of each coin type as the value
	 * @param balance
	 * @return
	 */
	public Map<Coin, Integer> makeChange(float balance) {
		
		int amount = (int)(balance * 100);
		
		Map<Coin, Integer> change = new LinkedHashMap<Coin, Integer>();
		
		for (Coin coin : coins) {
			if (amount <= 0) { break; }
			int cnt = amount / coin.getValue();
			if (cnt > 0) {
				amount = amount % (coin.getValue() * cnt);
				change.put(coin, cnt);
			}
		}
		
		return change;
		
	}

}
