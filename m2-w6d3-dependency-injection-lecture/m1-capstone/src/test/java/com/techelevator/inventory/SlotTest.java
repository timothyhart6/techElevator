package com.techelevator.inventory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.inventory.item.Candy;

public class SlotTest {

	Slot slot;
	
	@Before
	public void setup(){
		slot = new Slot(new Candy("Candy", 1.00f));
	}
	
	@Test
	public void remove_one_item() {
		// Act
		Assert.assertNotNull("Failed to remove item", slot.removeItem());
		// Assert
		Assert.assertEquals("Item count should be 4, but was " + slot.getCount(), 4, slot.getCount());
		Assert.assertFalse("Item is sold out", slot.isSoldOut());
	}
	
	@Test 
	public void remove_four_items() {
		// Arrange
		Assert.assertNotNull("Failed to remove item 1", slot.removeItem());
		Assert.assertNotNull("Failed to remove item 2", slot.removeItem());
		Assert.assertNotNull("Failed to remove item 3", slot.removeItem());
		// Act
		Assert.assertNotNull("Failed to remove item 4", slot.removeItem());
		// Assert
		Assert.assertEquals("Item count should be 1, but was " + slot.getCount(), 1, slot.getCount());
		Assert.assertFalse("Item is sold out", slot.isSoldOut());
	}
	
	@Test 
	public void sellout_item() {
		// Arrange
		Assert.assertNotNull("Failed to remove item 1", slot.removeItem());
		Assert.assertNotNull("Failed to remove item 2", slot.removeItem());
		Assert.assertNotNull("Failed to remove item 3", slot.removeItem());
		Assert.assertNotNull("Failed to remove item 4", slot.removeItem());
		// Act
		Assert.assertNotNull("Failed to remove item 5", slot.removeItem());
		// Assert
		Assert.assertEquals("Item count should be 0, but was " + slot.getCount(), 0, slot.getCount());
		Assert.assertTrue("Item is NOT sold out", slot.isSoldOut());
		Assert.assertNull("Allowed removal of item after sell out", slot.removeItem());
	}
}
