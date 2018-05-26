package com.techelevator;

public class CommandLineArgumentExamples {
	
	/*
	 * When a user enters arguments on the command line, for example add -A after the git command, then they
	 * are populated in order into the String[] args array passed to the main method.
	 * 
	 * We can then treat this array like any other array and check it to see what the user entered and run the appropriate code
	 */
	public static void main(String[] args) {
		
		// Print all the command line arguments
		System.out.print("The following command line arguments were recieved: ");
		for (int i = 0; i < args.length; i++) {
			System.out.printf(" %10s ", args[i]);
		}
		System.out.println();
		System.out.println();
		
		/* 
		 * We can use either an if..else if... else OR a switch sytnax to determine what the user selected
		 * 
		 * The check to make sure the length is greater than 0 is to protect against OutOfBoundary errors if the user
		 * does not enter a command
		 */
		if (args.length > 0) {
			String output = "You selected to ";
			switch(args[0]) {
				case "add":
					output += "add a change";
					break;
				case "commit":
					output += "commit your changes";
					break;
				case "push":
					output += "push your code";
					break;
				case "pull":
					output += "pull new changes";
					break;
				default:
					output += "do something I don't understand";
					break;
			}
			System.out.println(output);
		}
	}
}
