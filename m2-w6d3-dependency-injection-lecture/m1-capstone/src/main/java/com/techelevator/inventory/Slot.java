package com.techelevator.inventory;

import com.techelevator.inventory.item.Item;

/**
 * Data object for the vending machine's slots
 *
 */
public class Slot {

	private static final int DEFAULT_ITEM_COUNT = 5;

	private Item item;
	private int count;
	
	/**
	 * Adds an item to the slot and sets the current count to the starting default
	 * @param item
	 */
	public Slot(Item item) {
		this.item = item;
		this.count = DEFAULT_ITEM_COUNT;
	}

	public Item getItem() {
		return this.item;
	}
	
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Removes an item from the slot, and decrements its count
	 * @return
	 */
	public Item removeItem() {
		if (count == 0) {
			return null;
		}
		count--;
		return item;
	}
	
	
	/**
	 * Determines if there are available items in the slot
	 * @return
	 */
	public boolean isSoldOut() {
		return count == 0 ? true : false;
	}
	
}
