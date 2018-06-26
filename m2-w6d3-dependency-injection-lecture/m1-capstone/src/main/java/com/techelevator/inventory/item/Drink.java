package com.techelevator.inventory.item;

/**
 * Subclass for Drink Items
 *
 */
public class Drink extends Item  implements Eatable  {

	private static final String sound = "Glug Glug, Yum!";
	
	public Drink(String name, float price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return sound;
	}

}
