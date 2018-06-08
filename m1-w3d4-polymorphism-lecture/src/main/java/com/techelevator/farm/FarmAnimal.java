package com.techelevator.farm;

public abstract class FarmAnimal {
	private static int totalFood;
	
	private String name;
	private String sound;
	private double price;
	private boolean asleep;
	
	public FarmAnimal(String name, String sound, double price, boolean asleep) {
		this.name = name;
		this.sound = sound;
		this.price = price;
		this.asleep = asleep;
	}
	
	
	public abstract int eat();
	
	public void eatAndCountFood() {
		totalFood += eat();
	}
	
	
	public String getName( ) {
		return name;
	}
	
	public final String getSound( ) {
		if (asleep) {
			return "Zzzzzz...";
		}
		return sound;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isAsleep() {
		return asleep;
	}
	
}