package com.techelevator.coin;

public class Money {

	private String name;
	private int value;
	
	public Money(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
}
