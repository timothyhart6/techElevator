package com.techelevator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Examples {

	public static void main(String[] args) {
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		List<String> names = new ArrayList<String>();
		names.add("Kirk");
		names.add("Spock");
		names.add("McCoy");
		
		for (String name : names) {
			System.out.println(name);
		}
		names.remove("McCoy");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		if (names.contains("Kirk")) {
			System.out.println("Found in list");
		}
		
		System.out.println(names.indexOf("Spock"));
		
		List<Double> numbers = new ArrayList<Double>();
		
		// Autoboxing
		numbers.add(2.4d);
		
		// Manual boxing
		numbers.add(new Double(1.5));
		
		double sum = 0;
		for (double d : numbers) {
			sum += d;
		}
		System.out.println("Sum of Double List: " + sum);
		
		
		int[] ints = new int[] { 1, 2, 3, 4 };
		
		int sumOfEvens = 0;
		for (int number : ints) {
			if (number % 2 == 0) {
				sumOfEvens += number;
			}
		}
		System.out.println("Sum of Evens: " + sumOfEvens);
		
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("John");
		queue.offer("Jane");
		queue.offer("Sue");
		
		for (String name : queue) {
			System.out.println(queue.size() + " : " + name);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.size() + " : " + queue.poll());
		}
		
		Stack<Integer> nums = new Stack<Integer>();
		nums.push(10);
		nums.push(20);
		nums.push(30);
		
		while(!nums.isEmpty()) {
			System.out.println(nums.size() + " : " + nums.pop());
		}
		
	}

}
