package com.techelevator.transaction.change;

/**
 * Super class for Coins
 *
 */
public class Coin {
	
	private String name;
	private int value;
	
	public Coin(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	
	/**
	 * The hashCode override allows this class to be used as a Key in a Map
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	/**
	 * The equals override allows Map methods such as contains to be used when a Coin subclass is 
	 * used as a Map key
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coin))
			return false;
		Coin other = (Coin) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	
	
}
