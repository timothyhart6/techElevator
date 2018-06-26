package com.techelevator.inventory;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.inventory.item.Candy;
import com.techelevator.inventory.item.Chip;
import com.techelevator.inventory.item.Drink;
import com.techelevator.inventory.item.Gum;
import com.techelevator.inventory.item.Item;
import com.techelevator.inventory.reader.InventoryReaderMock;

public class InventoryTest {

	private Inventory inventory;
	
	@Before
	public void setup() {
		inventory = new Inventory(new InventoryReaderMock());
	}
	
	@Test 
	public void loads_expected_items() {
		Map<String, Slot> slots = inventory.getSlots();
		
		Assert.assertEquals("Incorrect inventory size.  Should be 16, but was " + slots.size(), 16, slots.size());
		int chipCount = 0;
		int candyCount = 0;
		int drinkCount = 0;
		int gumCount = 0;
		
		for (String key: slots.keySet()) {

			Item item = slots.get(key).getItem();
			
			if (item instanceof Chip) {
				chipCount++;
			} else if (item instanceof Candy) {
				candyCount++;
			} else if (item instanceof Drink) {
				drinkCount++;
			} else if (item instanceof Gum) {
				gumCount++;
			} else {
				Assert.fail("Invalid item type found " + item.getClass().getSimpleName());
			}
			
			Assert.assertFalse("Item with key " + key + " is sold out on load", slots.get(key).isSoldOut());
			
		}
		
		Assert.assertEquals("Incorrect chip count. Should be 4, but was " + chipCount, 4, chipCount);
		Assert.assertEquals("Incorrect candy count. Should be 4, but was " + candyCount, 4, candyCount);
		Assert.assertEquals("Incorrect drink count. Should be 4, but was " + drinkCount, 4, drinkCount);
		Assert.assertEquals("Incorrect gum count. Should be 4, but was " + gumCount, 4, gumCount);
		
	}
	

}
