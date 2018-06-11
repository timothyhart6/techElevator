package com.techelevator.farm;

public class Apple implements Sellable {

	@Override
	public String getName() {
		return "Apple";
	}

	@Override
	public double getPrice() {
		return 1d;
	}

}
