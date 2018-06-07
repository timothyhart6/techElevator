package com.techelevator.farm;

public class Cow extends FarmAnimal implements Singable, Sellable {
	
	public Cow() {
		super("Cow", "moo!", 1000d);
	}

}