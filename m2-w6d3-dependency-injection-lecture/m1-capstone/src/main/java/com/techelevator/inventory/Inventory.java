package com.techelevator.inventory;

import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.item.Item;
import com.techelevator.inventory.reader.InventoryReader;

/**
 * Creates and handles the the Vending Machine's Inventory
 *
 */
public class Inventory {

	private Map<String, Slot> slots = new LinkedHashMap<String, Slot>();
	
	/**
	 * Uses the passed InventoryReader to load the inventory and create Slots
	 * @param reader
	 */
	public Inventory(InventoryReader reader) {
		 this.slots = reader.read();
	}
	
	
	/**
	 * Returns a Map of the Vending Machines Slots
	 * The String key is a reference to the Slot location (e.g. A1, B2, etc.)
	 * @return
	 */
	public Map<String, Slot> getSlots() {
		return slots;
	}
	
	
	/**
	 * Gets the price of an item in the given slot, identified by the slot key (A1, B2, etc.)
	 * @param slotId
	 * @return
	 */
	public float getItemPriceFromSlot(String slotId) {
		return slots.get(slotId).getItem().getPrice();
	}
	
	
	/**
	 * Gets an item from a Slot, identified by the slot key (A1, B2, etc.)
	 * @param slotId
	 * @return
	 */
	public Item getItemFromSlot(String slotId) {
		return slots.get(slotId).removeItem();
	}
	
	
	/**
	 * Determines if the item in a given slot, identified by the slot key (A1, B2, etc.) is Sold Out
	 * @param slotId
	 * @return
	 */
	public boolean isItemSoldOut(String slotId) {
		return slots.get(slotId).isSoldOut();
	}
	
	
	/**
	 * Determines if a given slot key (A1, B2, etc.) is valid for the current vending machine
	 * @param slotId
	 * @return
	 */
	public boolean isValidSlot(String slotId) {
		if (slots.containsKey(slotId)) {
			return true;
		}
		return false;
	}
	
}
