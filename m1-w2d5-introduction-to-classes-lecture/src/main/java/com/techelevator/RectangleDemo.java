package com.techelevator;

import com.techelevator.shape.Rectangle;

public class RectangleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle = new Rectangle();
		
		rectangle.setWidth(10);
		rectangle.setHeight(20);
	
		Rectangle rect2 = new Rectangle(30, 30);
	
		
		System.out.println(rectangle.isLargerThan(rect2));
		System.out.println(rect2.isLargerThan(10, 5));

		System.out.println("Rectangle 2: " + rect2);
		
		Rectangle rect3 = new Rectangle(10, 20);
		
		System.out.println("Is 1 and 3 equals: " + rectangle.equals(rect3));
		
		String result = "";
		if (rect2.equals(rect3)) {
			result = "EQUAL!!!";
		} else {
			result = "Not equal";
		}
		System.out.println(result);
	}

}
