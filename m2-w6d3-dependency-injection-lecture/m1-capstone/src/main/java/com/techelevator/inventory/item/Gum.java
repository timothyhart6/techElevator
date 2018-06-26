package com.techelevator.inventory.item;


/**
 * Subclass for Gum Items
 *
 */
public class Gum extends Item implements Eatable {

	private static final String sound = "Chew Chew, Yum!";
	
	public Gum(String name, float price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return sound;
	}

}
