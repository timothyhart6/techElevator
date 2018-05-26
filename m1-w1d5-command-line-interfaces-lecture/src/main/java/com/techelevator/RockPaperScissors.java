package com.techelevator;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		
		// First we need a Scanner
		Scanner in = new Scanner(System.in);
		// Next an instance of the Random library
		Random random = new Random();
		
		// Array to keep track of possible computer choices
		String[] computerChoices = new String[] { "Rock", "Paper", "Scissors" };
		
		// Some variables to keep track of the score
		int playerWins = 0;
		int computerWins = 0;
		int ties = 0;
		
		// We will use a while loop so the player can play multiple games until they select to quit
		while(true) {
			
			// Get the player's choice
			System.out.println("Select (R)ock, (P)aper, (S)cissors, or (Q)uit");
			System.out.print(">>>");
			
			String playerChoice = in.nextLine().toUpperCase();
			
			// If the player choose to Quit, then display a final message and break the while loop to end the game
			if (playerChoice.equals("Q")) {
				System.out.println("Final Score:");
				System.out.println("Human Wins: " + playerWins);
				System.out.println("Computer Wins: " + computerWins);
				System.out.println("Ties: " + ties);
				System.out.println("Thank you for playing!");
				break;
			}
			
			// Get the computer choice
			int randomChoice = random.nextInt(3);
			String computerChoice = computerChoices[randomChoice];
			System.out.println("The computer chooses " + computerChoice);
			
			// String to hold the result
			String result = "";
			
			// Switch statement on the player's choice
			switch(playerChoice) {
				case "R":
					// Switch on the computer's choice to determine the winner, we will repeat this for each of the possible player choices, 
					// and change it according to who wins in each case
					switch(computerChoice) {
						case "Rock":
							// It's a tie, so increment the ties counter
							ties++;
							result = "It's a TIE!";
							break;
						case "Paper":
							// Paper beats Rock, the Computer wins, so increment the computerWins counter
							computerWins++;
							result = "The computer wins!";
							break;
						case "Scissors":
							// Rock beats Scissors, the player wins, so increment the playerWins counter
							playerWins++;
							result = "You wins!";
							break;
					}
					break;
				case "P":
					switch(computerChoice) {
						case "Rock":
							playerWins++;
							result = "You wins!";
							break;
						case "Paper":
							ties++;
							result = "It's a TIE!";
							break;
						case "Scissors":
							computerWins++;
							result = "The computer wins!";
							break;
					}
					break;
				case "S":
					switch(computerChoice) {
						case "Rock":
							computerWins++;
							result = "The computer wins!";
							break;
						case "Paper":
							playerWins++;
							result = "You win!";
							break;
						case "Scissors":
							ties++;
							result = "It's a TIE!";
							break;
					}
					break;
				default:
					// The user made a choice we don't know
					System.out.println("Invalid choice, please try again!");
					break;
			}
			
			// Show the user the results
			System.out.println(result);
		}
		
	}
}
