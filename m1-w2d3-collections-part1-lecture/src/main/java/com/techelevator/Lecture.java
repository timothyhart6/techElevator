package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("  JAVA.LANG.OBJECT");
		System.out.println("####################");
		
		/* Since String "is-a" Object, I can assign instances of String
		 * to a variable of type Object */
		
		String name = "George Washington";
		Object obj = name;
		
		System.out.println("obj : "+obj);
		
		/* Even though name and obj are declared to be different types, they
		 * refer to the same object in memory */
		
		if(name == obj) {
			System.out.println("obj and name reference the same instance");
		}
		
		/* When we call obj.equals(...), we're calling it on an instance of String */
		
		if(obj.equals("George Washington")) {
			System.out.println("obj == George Washington");
		}
		
		/* Even though obj refers to a String instance, the compiler will only allow
		 * us to call methods that are valid for the declared data type (i.e. java.lang.Object) */
		
		// obj.toUpperCase(); // this causes a compiler error because toUpperCase is not a valid java.lang.Object method
		
		/* I can cast a super type into a valid subclass in order to treat the variable
		 * as an instance of the subclass */
		String upperName = ((String)obj).toUpperCase();
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation 
		 * of a primitive value */
		Integer employees = new Integer(25);       // here we call a constructor that "wraps" a primitive int value in an object
		Integer piecesOfCake = new Integer("24");  // here we call a constructor that converts a String into an Integer
		
		if(employees > piecesOfCake) {
			System.out.println("Burn the building down");
		}
		
		Double accountBalance = null;
		// double newBalance = accountBalance + 100;  // this causes a NullPointerException because we are trying to "unbox" a null value
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Aragorn");
		names.add("Boromir");
		names.add("Gimli");
		names.add("Legolas");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		//the elements will be returned in the same order they were added
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sam");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "David");
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(2);
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
	
		
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();
		
		Set<String> students = new HashSet<String>();  // change HashSet to TreeSet or LinkedHashSet to see how the behavior changes
		
		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();

		students.add("Jim");
		System.out.println("Added Jim");
		students.add("Seth");
		System.out.println("Added Seth");
		students.add("Dan");
		System.out.println("Added Dan");
		students.add("Jim");  // this value will be ignored because it is duplicate
		System.out.println("Added Jim again");
		System.out.println();
		
		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

		System.out.println("Set of students contains:");
		for(String studentName : students) { // note that the values are returned in a different order than they were added
			System.out.println(studentName+" : Hash = "+studentName.hashCode());
		}
		System.out.println();
		System.out.println("note that the values may be returned in a different order than they were added");
		System.out.println();
		
	}
}
