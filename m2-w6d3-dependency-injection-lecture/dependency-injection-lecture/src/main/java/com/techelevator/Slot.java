package com.techelevator;

public class Slot {
	private String location;
	private String productName;
	private int price;
	private int quantity;
	
	public Slot(String location, String productName, int price, int quantity) {
		this.location = location;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getLocation() {
		return location;
	}
	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	public void dispenseProduct() {
		if(quantity > 0) {
			quantity--;
		} else {
			throw new RuntimeException("No more product left.");
		}
	}

	public int getQuantity() {
		return quantity;
	}
}
