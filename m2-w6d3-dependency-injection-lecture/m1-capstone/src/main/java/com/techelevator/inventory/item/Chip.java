package com.techelevator.inventory.item;

/**
 * Subclass for Chip Items
 *
 */
public class Chip extends Item implements Eatable  {

	private static final String sound = "Crunch Crunch, Yum!";
	
	public Chip(String name, float price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return sound;
	}

}
