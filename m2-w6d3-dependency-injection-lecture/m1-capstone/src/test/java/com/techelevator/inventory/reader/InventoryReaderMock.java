package com.techelevator.inventory.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.Slot;

public class InventoryReaderMock extends InventoryReader {

	@Override
	public Map<String, Slot> read() {
		return loadInventoryFromDelimitedLines(getInventoryMockLines(), "\\|");
	}
	
	
	private List<String> getInventoryMockLines() {
		List<String> lines = new ArrayList<String>();
		
		lines.add("A1|Corn Crisps|3.05|Chip");
		lines.add("A2|Stinkers|1.45|Chip");
		lines.add("A3|Pepper Waves|2.75|Chip");
		lines.add("A4|Rain Popcorn|3.65|Chip");
		lines.add("B1|Sunpie|1.80|Candy");
		lines.add("B2|Chickentales|1.50|Candy");
		lines.add("B3|Tonka Bar|1.50|Candy");
		lines.add("B4|Brunchie|1.75|Candy");
		lines.add("C1|Soda|1.25|Drink");
		lines.add("C2|Dr. Oregeno|1.50|Drink");
		lines.add("C3|Hill Melter|1.50|Drink");
		lines.add("C4|Light|1.50|Drink");
		lines.add("D1|I-Chews|0.85|Gum");
		lines.add("D2|Tiny League Chew|0.95|Gum");
		lines.add("D3|Briclets|0.75|Gum");
		lines.add("D4|Unoemint|0.75|Gum");
		
		
		return lines;
	} 

}
