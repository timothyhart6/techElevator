package com.techelevator;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Examples {

	public static void main(String[] args) {
	
		/*
		 * Map Examples
		 */
		Map<Integer, Boolean> ourMap = new HashMap<Integer, Boolean>();
		
		ourMap.put(10, true);
		ourMap.put(20, false);
		
		System.out.println("10 is " + ourMap.get(10));
		boolean valueOf20 = ourMap.get(20);
		System.out.println("20 is " + valueOf20);

		ourMap.put(10, false);
		System.out.println("10 is now " + ourMap.get(10));
		
		if (ourMap.get(20) == false) {
			System.out.println("20 is false");
		}
		
		Map<String, String> items = new HashMap<String, String>();
		items.put("A1", "Chips");
		items.put("A2", "Soda");
		items.put("B1", "Candy");
		items.put("C2", "Gum");
		
		System.out.println("A1 has " + items.get("A1"));
		
		for (String key : items.keySet()) {
			if (items.get(key).equals("Chips")) {
				System.out.println("Chips are at " + key);
			}
			System.out.println(key + " : " + items.get(key));
		}
		
		items.remove("A2");
		for (String key : items.keySet()) {
			System.out.println(key + " : " + items.get(key));
		}
		
		if (items.containsKey("B1")) {
			System.out.println("B1 Exists");
		} else {
			System.out.println("B1 Does NOT Exists");
		}
		
		items.remove("B1");
		if (items.containsKey("B1")) {
			System.out.println("B1 Exists");
		} else {
			System.out.println("B1 Does NOT Exists");
		}
		
		Map<String, Integer> inventory = new HashMap<String, Integer>();
		inventory.put("yellow pants", 5);
		inventory.put("green pants", 5);
		inventory.put("red pants", 6);
		
		System.out.println(inventory.get("green pants") + " green pants in the store");
		
		if (inventory.containsKey("green pants")) {
			inventory.put("green pants", inventory.get("green pants") + 2);
		}
		
		System.out.println(inventory.get("green pants") + " green pants in the store");
		
		/*
		 * Set Examples
		 */
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(10);
		numbers.add(12);
		numbers.add(10);
		numbers.add(10);
		numbers.add(8);
		numbers.add(502);
		
		System.out.println(numbers.size());
		
		for(Integer i : numbers) {
			System.out.println(i);
		}
		
	}

}
