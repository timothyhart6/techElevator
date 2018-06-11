package com.techelevator;

import com.techelevator.game.Game;
import com.techelevator.highlow.HighLow;
import com.techelevator.monopoly.Monopoly;

public class GameDemo {

	public static void main(String[] args) {
		Monopoly theGame = new Monopoly(4);
		theGame.playGame();
	}

}
