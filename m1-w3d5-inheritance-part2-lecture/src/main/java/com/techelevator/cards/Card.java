package com.techelevator.cards;

public class Card {

	private String suit;
	private String value;
	private boolean faceUp = false;
	
	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}

	public static boolean doSomething(String s) {
	
		
		return true;
	}
	
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}

	public boolean isFaceUp() {
		return faceUp;
	}
	
	@Override
	public String toString() {
		if (faceUp) {
			return value + suit;
		} else {
			return "##";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
