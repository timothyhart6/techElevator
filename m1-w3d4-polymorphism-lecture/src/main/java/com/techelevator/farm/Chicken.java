package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Singable, Sellable  {
		
	public Chicken() {
		super("Chicken", "cluck!", 20d);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}