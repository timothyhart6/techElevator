package com.techelevator;

<<<<<<< HEAD
import com.techelevator.game.Game;
import com.techelevator.highlow.HighLow;
=======
import com.techelevator.cards.HighLow;
import com.techelevator.game.Game;
>>>>>>> 0e4bbf2f352a6a403e24546fa6eb92795445176c
import com.techelevator.monopoly.Monopoly;

public class GameDemo {

	public static void main(String[] args) {
<<<<<<< HEAD
		Monopoly theGame = new Monopoly(4);
		theGame.playGame();
=======
		//Game theGame = new Monopoly(4);
		//Game theGame = new HighLow();
		Game[] games = new Game[] { new Monopoly(4), new HighLow() };
		
		for (Game theGame : games) {
			theGame.playGame();
		}
			
>>>>>>> 0e4bbf2f352a6a403e24546fa6eb92795445176c
	}

}
