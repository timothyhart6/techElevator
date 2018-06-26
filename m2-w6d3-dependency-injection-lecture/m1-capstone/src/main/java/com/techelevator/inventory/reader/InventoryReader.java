package com.techelevator.inventory.reader;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.Slot;
import com.techelevator.inventory.item.Candy;
import com.techelevator.inventory.item.Chip;
import com.techelevator.inventory.item.Drink;
import com.techelevator.inventory.item.Gum;
import com.techelevator.inventory.item.Item;


/**
 * InventoryReader abstract class to read and an inventory file with delimited lines and build the vending
 * machine slots from each line.
 *
 */
public abstract class InventoryReader {
	
	public abstract Map<String, Slot> read();
	
	protected Map<String, Slot> loadInventoryFromDelimitedLines(List<String> inventoryLines, String delimiter)  {
		
		Map<String, Slot> slots = new LinkedHashMap<String, Slot>();
		
		
		for (String itemLine : inventoryLines) {
			String[] itemParts = itemLine.split(delimiter);
			String itemType = itemParts[3];
			slots.put(itemParts[0], buildItemFromParts(itemType, itemParts[1], Float.parseFloat(itemParts[2])));
		}
		
		return slots;
	}
	
	protected Slot buildItemFromParts(String itemType, String name, float price) {
		
		Item item = null;
		switch(itemType.toUpperCase()) {
			case "CHIP":  // Chips
				item = new Chip(name, price);
				break;
			case "CANDY":  // Candy
				item = new Candy(name, price);
				break;
			case "DRINK":  // Drink
				item = new Drink(name, price);
				break;
			case "GUM":  // Gum
				item = new Gum(name, price);
				break;
		}
		return new Slot(item);
	}
}
