package com.techelevator.farm;

public class Cow extends FarmAnimal implements Singable, Sellable {
	
	public Cow(boolean asleep) {
		super("Cow", "moo!", 1000d, asleep);
	}

	@Override
	public int eat() {
		// TODO Auto-generated method stub
		return 0;
	}

}