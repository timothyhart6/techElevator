package com.techelevator.item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.inventory.item.Candy;
import com.techelevator.inventory.item.Chip;
import com.techelevator.inventory.item.Drink;
import com.techelevator.inventory.item.Eatable;
import com.techelevator.inventory.item.Gum;
import com.techelevator.inventory.item.Item;

public class ItemTest {

	private static final String GUM_ITEM_SOUND = "Chew Chew, Yum!";
	private static final String CANDY_ITEM_SOUND = "Munch Munch, Yum!";
	private static final String CHIP_ITEM_SOUND = "Crunch Crunch, Yum!";
	private static final String DRINK_ITEM_SOUND = "Glug Glug, Yum!";
	private Item[] items;
	
	@Before
	public void setup() {
		items = new Item[] { 
				new Candy("candy", 1.00f),
				new Chip("chip", 2.00f),
				new Drink("drink", 3.00f ),
				new Gum("gum", 4.00f)	
		};
	}
	
	@Test
	public void items_make_correct_sounds() {
		
		for (Item item : items) {
			String sound = "";
			if (item instanceof Eatable) {
				sound = ((Eatable) item).eat();
			} else {
				Assert.fail("Non-Eatable Item in list: " + item.getName());
			}
			
			if (item instanceof Candy) {
				Assert.assertEquals("Incorrect Candy Sound", CANDY_ITEM_SOUND, sound);
			} else if (item instanceof Chip) {
				Assert.assertEquals("Incorrect Chip Sound", CHIP_ITEM_SOUND, sound);
			} else if (item instanceof Drink) {
				Assert.assertEquals("Incorrect Drink Sound", DRINK_ITEM_SOUND, sound);
			} else if (item instanceof Gum) {
				Assert.assertEquals("Incorrect Gum Sound", GUM_ITEM_SOUND, sound);
			}
		}
	}
	

}
