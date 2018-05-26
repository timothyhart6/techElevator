package com.techelevator;

import java.util.Scanner;

public class ScannerExamples {
	
	public static void main(String[] args) {
	
		/*
		 * To read user input from the command line, we can use a Scanner, which
		 * we need to pass the System.in inputStream.  
		 */
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		
		/* 
		 * We use the Scanner nextLine() method to get the input from the user as
		 * a String.  This gets all values the user types up until and including the Enter/Return.
		 */
		String name = in.nextLine();
		System.out.println("Hello " + name);
		

		System.out.print("Enter a number: ");
		/*
		 * We can also use other methods of scanner like nextInt() to get input from the user
		 * and have it automatically parsed to that datatype.  This will not include the Enter/Return
		 * character, which will be left on the inputStream and must be cleaned up to continue.
		 * 
		 * If the character the user enters is not a valid value for the data type, the user will
		 * see an Exception.
		 */
		int number = in.nextInt();
		// When using the non-String methods we must call in.nextLine() afterward to cleanup the trailing return character
		in.nextLine();
		System.out.println("You input a "+ number);
		
		
		System.out.print("Enter a dollar amount: ");
		
		// We can also get a number as a String and then parse it using the desired datatypes parse function
		String dollarAmount = in.nextLine();
		
		/*
		 * We convert the string by calling the parse method on the datatype we wish to convert.  The string must only contain
		 * characters that are valid for that datatype, otherwise the user will recieve an exception.  
		 * 
		 * Some examples (there are many others)
		 * 		Integer.parseInt(string s);
		 *		Long.parseLong(string s);
		 * 		Double.parseDouble(string s);
		 * 		Boolean.parseBoolean(string s);
		 *
		 */
		double amount = Double.parseDouble(dollarAmount);
		
		// Now we can use it as that datatype, in this case a double
		double tax = amount * .75d;
		double total = amount + tax;
		
		/*
		 * If you want to display formatted values we can use the printf function with a formatter.
		 * 
		 * Each formatter has a specifier that starts with a % and ends with a code for the type.  Between the % and the code 
		 * are details of how to format the resulting string.
		 * 
		 * Example:  %4.2f  - format a floating point number (float or double) with a minimum of 4 characters before the decimal point and 2 
		 * after the decimal point.  -->  1234.00
		 * 
		 * The two most common specifiers are:
		 * 		%f  - floating point
		 *      %s  - string of characters
		 *      
		 * The formatter is put into the String where you want the data to be placed, and the value to format comes after a comma following
		 * the string.
		 */

			// If we want to print a new line, we can use an empty println() to create one, or a \n in the String
			System.out.println();
			System.out.printf("%-10s", "Item");
			System.out.printf("  %-2s ", "Price");
			System.out.printf("  %-2s ", "Tax");
			System.out.printf("  %-2s ", "Total");
			System.out.println("\n---------------------------------");
			System.out.printf("%-10s", "Book");
			System.out.printf("  $%4.2f ", amount);
			System.out.printf(" $%4.2f ", tax);
			System.out.printf(" $%4.2f \n", total);

			String itemTwo = "Record";
			double twoAmount = 5.76d;
			double twoTax = twoAmount * 0.75d;
			double twoTotal = twoAmount + twoTax;
			System.out.printf("%-10s", itemTwo);
			System.out.printf("  $%4.2f ", twoAmount);
			System.out.printf(" $%4.2f ", twoTax);
			System.out.printf(" $%4.2f ", twoTotal);
			
	}
}
