package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.techelevator.inventory.item.Eatable;
import com.techelevator.inventory.item.Item;
import com.techelevator.transaction.CompleteTransaction;
import com.techelevator.transaction.change.Coin;

/**
 * Handles all interaction with the user input and output
 *
 */
public class Menu {

	private PrintWriter out;
	private Scanner in;

	/**
	 * Creates a PrintWriter for output and Scanner for Input from the InputStream and OutputStream
	 * passed to it.  The Scanner will handle all user input for the Vending Machine, and the PrintWriter
	 * will handle all User output for the Vending Machine.
	 * 
	 * A PrintWriter is used to wrap the System.out so a different output stream can be used with the Vending
	 * Machine, thus decoupling it from the console.
	 * 
	 * @param input
	 * @param output
	 */
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	/**
	 * Gets and returns a user selection from an Array of available objects
	 * @param options
	 * @return
	 */
	public Object getChoiceFromOptions(Object[] options) { 
		// Call the getChoiceFromOptions overload with default values, so code is not duplicated
		return getChoiceFromOptions(options, false, 0.0f);
	}
	
	
	/**
	 * Gets and returns user selection from an Array of available selections.  If showBalance is
	 * true, then the balance will be shown below the user options
	 * @param options
	 * @param showBalance
	 * @param balance
	 * @return
	 */
	public Object getChoiceFromOptions(Object[] options, boolean showBalance, float balance) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options, showBalance, balance);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	
	/**
	 * Displays any list of strings to the user
	 * @param list
	 */
	public void displayList(List<String> list) {
		out.println();
		for(String s : list) {
			out.println(s);
		}
		out.flush();
	}
	
	
	/**
	 * Gets non-menu based input of dollar amounts from the user
	 * @return
	 */
	public int getAmountFromUserInput() {
		
		int choice = 0;
		while (choice  == 0) {	
			out.print("Add money to your balance (dollars only) >>");
			out.flush();
			try {
				choice = in.nextInt();
				if (choice < 0) {
					throw new InputMismatchException("Negative amount added!");
				}
			} catch (InputMismatchException e) {
				out.println("*** Invalid amount.  Please add whole dollars only. ***");
				out.println();
				choice = 0;
				if (in.hasNextLine()) {
					in.nextLine();
				}
			}
		}
		in.nextLine();
		return choice;
	}
	
	
	/**
	 * Gets the choice from the user as a String, such as Slot key (A1, B2, etc.)
	 * @param balance
	 * @return
	 */
	public String getItemChoiceFromUser(float balance) {
		showBalance(balance);
		out.print("\nPlease choose an item >>> ");
		out.flush();
		return in.nextLine().toUpperCase();
	}
	
	
	/**
	 * Displays a message to the user.  If isError is true, then it will be wrapped with an indicator
	 * that it is an error message to draw attention from the user.
	 * @param message
	 * @param isError
	 */
	public void displayUserMessage(String message, boolean isError) {
		if (isError) {
			out.println("*** " + message + " ***");
		} else {
			out.println(message);
		}
		out.flush();
	}
	
	
	/**
	 * Displays the output of a Completed Transaction
	 * @param completeTransaction
	 */
	public void displayCompleteTransaction(CompleteTransaction completeTransaction) {
		
		if (!completeTransaction.getChange().isEmpty()) {
			out.println();
			out.print("Dispensing change: ");
		}
		for (Coin coin : completeTransaction.getChange().keySet()) {
			out.print(completeTransaction.getChange().get(coin) + " ");
			out.print(coin.getName() + "(s) ");
		}
		out.println();
		for (Item item : completeTransaction.getItems()) {
			out.println(((Eatable) item).eat());
		}
		out.flush();
	}
	
	
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options, boolean showBalance, float balance) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		if (showBalance) {
			showBalance(balance);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
	private void showBalance(float balance) {
		out.println(String.format("Current Money Provided: $%0$.2f", balance));
		out.flush();
	}
}
