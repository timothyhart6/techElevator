package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> listOfCards = new ArrayList<Card>();
	
	public Deck() {
		buildDeck();
	}
	
	private void buildDeck() {
		String[] suits = new String[] { "c", "s","d","h" };
		String[] values = new String[] { "A", "2", "3","4","5","6","7","8", "9", "T", "J", "Q", "K"};
		
		for (String suit : suits) {
			for (String value : values) {
				Card currentCard = new Card(suit, value);
				listOfCards.add(currentCard);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	public Card deal() {
		if (size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}
	
	public int size() {
		return listOfCards.size();
	}
	
	private void flip() {
		for (Card card : listOfCards) {
			card.flip();
		}
	}
	
	@Override
	public String toString() {
		this.flip();
		String myStr = "Deck [listOfCards=" + listOfCards + "]";
		this.flip();
		return myStr;
	}
}
