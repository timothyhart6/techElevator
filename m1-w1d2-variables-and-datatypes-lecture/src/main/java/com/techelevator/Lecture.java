package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half;
		half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		byte seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage;
		myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		float pi = 3.1416f;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Whatever your name is";
		System.out.println(myName);
		
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		byte numberOfMouseButtons = 3;
		System.out.println(numberOfMouseButtons);
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		byte percentageBatteryLeft = 80;
		System.out.println(percentageBatteryLeft);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int numberOne = 121;
		int numberTwo = 27;
		int difference = numberOne - numberTwo;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double doubleAddition = 12.3 + 32.1;
		System.out.println(doubleAddition);

		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "John Doe";

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, ";
		hello = hello + fullName;
		System.out.println(hello);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Equire";
		
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Equire";
		System.out.println(fullName);
		
		byte x = 0;
		int y = 300;
		y = (int) x; 
		System.out.println(y);
		
		
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movieTitle = "Saw";
		movieTitle += 2;
		System.out.println(movieTitle);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		int zero = 0;
		movieTitle += zero;
		System.out.println(movieTitle);
		/*
		18. What is 4.4 divided by 2.2?
		*/
		float result18 = 4.4f/2.2f;
		System.out.println(result18);
		/*
		19. What is 5.4 divided by 2?
		*/
		double result19 = 5.4 /2;
		System.out.println(result19);
		/*
		20. What is 5 divided by 2?
		*/
		double result20 = 5/2;
		System.out.println(result20);
		/*
		21. What is 5.0 divided by 2?
		*/
		double result21 = 5.0/2;
		System.out.println(result21);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		double result22 = 66.6/100;
		System.out.println(result22);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int remainder = 5 % 2;
		System.out.println(remainder);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		long largeValue = 1000000000l * 3;
		System.out.println(largeValue);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean donwWithExercises = false;
		/*
		26. Now set doneWithExercise to true.
		*/
		donwWithExercises = true;
		
	}

}
