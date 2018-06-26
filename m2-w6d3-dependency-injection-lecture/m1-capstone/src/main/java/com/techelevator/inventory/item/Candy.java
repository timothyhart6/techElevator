package com.techelevator.inventory.item;

/**
 * Subclass for Candy Items
 *
 */
public class Candy extends Item  implements Eatable  {

	private static final String sound = "Munch Munch, Yum!";
	
	public Candy(String name, float price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return sound;
	}

}
