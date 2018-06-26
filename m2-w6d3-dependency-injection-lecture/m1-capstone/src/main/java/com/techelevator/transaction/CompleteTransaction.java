package com.techelevator.transaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.item.Item;
import com.techelevator.transaction.change.Coin;

/**
 * Data class to hold the details of a completed transaction
 *
 */
public class CompleteTransaction {

	List<Item> items = new ArrayList<Item>();
	Map<Coin, Integer> change = new LinkedHashMap<Coin, Integer>();
	
	public CompleteTransaction(List<Item> items, Map<Coin, Integer> change) {
		this.items = items;
		this.change = change;
	}

	public List<Item> getItems() {
		return items;
	}

	public Map<Coin, Integer> getChange() {
		return change;
	}
	
}
