package com.techelevator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VendingMachineCLI {

	public static void main(String[] args) throws FileNotFoundException {
		File inventoryFile = new File("/Users/David/vendingMachine.csv");
		FileInputStream inputStream = new FileInputStream(inventoryFile);
		InventoryDAO inventoryDAO = new InventoryFileDAO(inputStream);
		
		for(Slot s : inventoryDAO.getInventory()) {
			System.out.println(s.getLocation()+"\t\t"+s.getProductName()+"\t\t"+s.getPrice()+"\t\t"+s.getQuantity());
		}
	}

}
