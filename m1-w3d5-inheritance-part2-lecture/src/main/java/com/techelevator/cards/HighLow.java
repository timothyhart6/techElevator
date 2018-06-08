package com.techelevator.cards;

import com.techelevator.game.Game;

public class HighLow extends Game {

	private int playerOneScore = 0;
	private int playerTwoScore = 0;
	private int pushes = 0;
	
	private Deck deck;
	
	public HighLow() {
		super(2);
	}

	@Override
	protected void setup(int numberOfPlayers) {
		deck = new Deck();
		deck.shuffle();
		playerOneScore = 0;
		playerTwoScore = 0;
		pushes = 0;
	}

	@Override
	protected void takeTurn(int player) {
		Card playerOneCard = deck.deal();
		Card playerTwoCard = deck.deal();
		playerOneCard.flip();
		playerTwoCard.flip();
		int oneValue = getCardValue(playerOneCard);
		int twoValue = getCardValue(playerTwoCard);
		
		System.out.println("Player one has a " + playerOneCard + " against Player two's " + playerTwoCard);
		
		if (oneValue > twoValue) {
			System.out.println("Player one gets a point");
			playerOneScore++;
		} else if (twoValue > oneValue) {
			System.out.println("Player two get a point"); 
			playerTwoScore++;
		} else {
			System.out.println("It's a push");
			pushes++;
			
		}
		
	}

	@Override
	protected boolean isGameOver() {
		if (playerOneScore == 10) {
			System.out.println("GAME OVER: PLAYER ONE WINS!");
			return true;
		}
		if (playerTwoScore == 10) {
			System.out.println("GAME OVER: PLAYER TWO WINS!");
			return true;
		}
		return false;
	}

	@Override
	protected void finishGame() {
		System.out.println("\n--------------------\nFinal Score:");
		System.out.println("Player One: " + playerOneScore);
		System.out.println("Player Two: " + playerTwoScore);
		System.out.println("Pushes: " + pushes);
		
	}
	
	private int getCardValue(Card card) {
		int value = 0;
		switch(card.getValue()) {
			case "T":
				value = 10;
				break;
			case "J":
				value = 11;
				break;
			case "Q":
				value = 12;
				break;
			case "K":
				value = 13;
				break;
			case "A":
				value = 14;
				break;
			default:
				value = Integer.parseInt(card.getValue());
				break;
		}
		
		return value;
	}

}
