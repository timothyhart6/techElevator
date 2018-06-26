package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class TestInventoryDAO implements InventoryDAO {

	private List<Slot> inventory;
	
	public TestInventoryDAO() {
		this.inventory = new ArrayList<>();
	}

	@Override
	public List<Slot> getInventory() {
		return inventory;
	}
	
	public void setInventory(List<Slot> inventory) {
		this.inventory = inventory;
	}

	public void addSlot(Slot emptySlot) {
		this.inventory.add(emptySlot);
	}

}
