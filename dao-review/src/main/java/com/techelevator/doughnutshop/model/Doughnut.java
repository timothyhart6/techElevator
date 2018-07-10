package com.techelevator.doughnutshop.model;

import java.util.List;

public class Doughnut {

	private long id;
	private Filling filling;
	private int inventoryCount;
	private String name;
	private int priceInCents;
	private List<Topping> toppings;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Filling getFilling() {
		return filling;
	}
	
	public void setFilling(Filling filling) {
		this.filling = filling;
	}
	
	public int getInventoryCount() {
		return inventoryCount;
	}
	
	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPriceInCents() {
		return priceInCents;
	}
	
	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}

}
