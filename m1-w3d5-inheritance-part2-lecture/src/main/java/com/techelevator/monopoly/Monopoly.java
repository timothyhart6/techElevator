package com.techelevator.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.techelevator.game.Game;

public class Monopoly extends Game {

	private static final String[] PIECES = { "Dog", "Wheelbarrow", "Thimble", "Car", "Iron", "Hat", "Shoe", "Battleship", "Cannon" };
	private List<Player> players;
	private Random random;
	
	public Monopoly(int numberOfPlayers) {
		super(numberOfPlayers);
		players = new ArrayList<>();
		random = new Random();
	}
	
	@Override
	protected void setup(int numberOfPlayers) {
		System.out.println("Distribute money to each player");
		for(int i = 0; i < numberOfPlayers && i < PIECES.length; i++) {
			Player p = new Player(i+1, PIECES[i]);
			players.add(p);
			System.out.println("Player "+p.getPlayerNumber()+" is the "+p.getPlayingPiece());
		}
	}

	@Override
	protected void takeTurn(int player) {
		Player currentPlayer = players.get(player-1);
		if(!currentPlayer.isBankrupt()) {
			System.out.println(currentPlayer.getPlayingPiece()+" is taking a turn.");
			if(random.nextInt(4) % 3 == 0) {
				System.out.println(currentPlayer+" IS BANKRUPT!!!");
				currentPlayer.goBankrupt();
			}
		}
	}

	@Override
	protected boolean isGameOver() {
		return getActivePlayers().size() == 1;
	}

	@Override
	protected void finishGame() {
		Player winner = getActivePlayers().get(0);
		System.out.println("* ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ ");
		System.out.println(winner.getPlayingPiece() + " IS THE WINNER!!!");
		System.out.println("* ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ ");
	}

	private List<Player> getActivePlayers() {
		List<Player> activePlayers = new ArrayList<>();
		for(Player p : players) {
			if(!p.isBankrupt()) {
				activePlayers.add(p);
			}
		}
		return activePlayers;
	}
}
