package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Singable, Sellable  {
		
	public Chicken(boolean asleep) {
		super("Chicken", "cluck!", 20d, asleep);
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public int eat() {
		// TODO Auto-generated method stub
		return 0;
	}

}