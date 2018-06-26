package com.techelevator.inventory.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.exception.InventoryReadException;
import com.techelevator.inventory.Slot;


/**
 * Inventory Reader subclass to read the inventory from a CSV based text file that is delimited by a |
 *
 */
public class CsvInventoryReader extends InventoryReader {

	private static final String csvFilePath = "vendingmachine.csv";
	
	/**
	 * Reads the invetory from a file and creates a Map of the slots.  The Map key is the slot location (A1, B2, etc.)
	 */
	public Map<String, Slot> read() {
		return loadInventoryFromDelimitedLines(getLinesFromCvsFile(), "\\|");

	}
	
	private List<String> getLinesFromCvsFile() {
		List<String> lines = new ArrayList<String>();
		
		File inputFile = new File(csvFilePath);
		
		if (!inputFile.isFile()) {
			throw new InventoryReadException(csvFilePath + " file not found!", this.getClass().getName());
		}
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			throw new InventoryReadException(e, "Failed to read inventory file", this.getClass().getName());
		}
		
		return lines;
	}
	

}
