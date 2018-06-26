package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

	private List<Slot> inventory;
	private int customerBalance;

	public VendingMachine(InventoryDAO inventoryDao) {
		this.inventory = inventoryDao.getInventory();
	}

	public List<Slot> getInventory() {
		return inventory;
	}

	public void addMoney(int i) {
		this.customerBalance += i;
	}

	public int getCurrentBalance() {
		return customerBalance;
	}

	public void dispenseItem(String location) {
		for(Slot s : inventory) {
			if(s.getLocation().equals(location)) {
				if(s.getQuantity() == 0) {
					throw new OutOfStockException();
				}
			}
		}
	}
}
