package com.techelevator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryFileDAO implements InventoryDAO {

	private static final int INITIAL_QUANTITY = 5;
	private Scanner inputScanner;

	public InventoryFileDAO(InputStream inputStream) {
		this.inputScanner = new Scanner(inputStream);
	}

	@Override
	public List<Slot> getInventory() {
		ArrayList<Slot> inventory = new ArrayList<>();
		while(inputScanner.hasNextLine()) {
			String line = inputScanner.nextLine();
			Slot slot = parseSlotFromLine(line);
			inventory.add(slot);
		}
		return inventory;
	}

	private Slot parseSlotFromLine(String line) {
		String[] parts = line.split("\\|");
		String location = parts[0];
		String productName = parts[1];
		int price = (int)(Double.valueOf(parts[2]) * 100);
		Slot slot = new Slot(location, productName, price, INITIAL_QUANTITY);
		return slot;
	}

}
