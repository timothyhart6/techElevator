package com.techelevator.shape;

public class Rectangle {
	
	private int height;
	private int width;
	
	// Default constructor
	public Rectangle() {
		
	}
	
	// Constructor Overload that sets state
	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	public boolean isLargerThan(Rectangle other) {
		return this.getArea() > other.getArea();
	}

	// Overload
	public boolean isLargerThan(int width, int height) {
		return this.getArea() > (width * height);
	}
	
	public int getArea() {
		return this.width * this.height;
	}
	
	// Getter
	public int getHeight() {
		return this.height;
	}
	
	// Setter
	public void setHeight(int height) {
		this.height = Math.abs(height);
	}

	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	// toString Override
	@Override
	public String toString() {
		return this.width + "x" + this.height + " - " + this.getArea() + " square feet";
	}
	
	// equals Override
	@Override
	public boolean equals(Object obj) {
		Rectangle other = (Rectangle) obj;
		return this.height == other.getHeight() && this.width == other.getWidth();
	}


}
