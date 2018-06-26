package com.techelevator.inventory.item;

/**
 * Super class for Item
 *
 */
public class Item {

	private String name;
	private float price;
	
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}

	public float getPrice() {
		return this.price;
	}
	
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.toUpperCase().equals(other.name.toUpperCase()))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}	
	
}
