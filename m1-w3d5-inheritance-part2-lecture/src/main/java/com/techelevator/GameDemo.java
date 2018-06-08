package com.techelevator;

import com.techelevator.cards.HighLow;
import com.techelevator.game.Game;
import com.techelevator.monopoly.Monopoly;

public class GameDemo {

	public static void main(String[] args) {
		//Game theGame = new Monopoly(4);
		//Game theGame = new HighLow();
		Game[] games = new Game[] { new Monopoly(4), new HighLow() };
		
		for (Game theGame : games) {
			theGame.playGame();
		}
			
	}

}
