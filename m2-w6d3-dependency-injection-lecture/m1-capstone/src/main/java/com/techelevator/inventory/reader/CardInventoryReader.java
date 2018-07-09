package com.techelevator.inventory.reader;

import java.util.HashMap;
import java.util.Map;

import com.techelevator.inventory.Slot;
import com.techelevator.inventory.item.Item;

public class CardInventoryReader extends InventoryReader {

	@Override
	public Map<String, Slot> read() {
		
		Map<String, Slot> inventory = new HashMap<String, Slot>();
		
		inventory.put("A1", new Slot(new Item("Item A", .50f)));
		inventory.put("B1", new Slot(new Item("Item B", 2f)));
		inventory.put("C1", new Slot(new Item("Item C", 60f)));
		
		return inventory;
	}

}
