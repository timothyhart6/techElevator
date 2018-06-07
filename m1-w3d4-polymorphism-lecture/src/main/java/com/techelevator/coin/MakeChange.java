package com.techelevator.coin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeChange {

	private static final Coin[] coins = new Coin[] { new FiftyCentPiece(), new Quarter(), new Dime(), new Nickel() };
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		while(true) {
			
			System.out.println("Enter amount to make change:");
			System.out.print(">>>");
			int amount = (int) (Double.parseDouble(in.nextLine()) * 100);
			
			Map<Coin, Integer> change = new LinkedHashMap<Coin, Integer>();
			
			for (Coin coin : coins) {
				if (amount <= 0 ) { break; }
				int cnt = amount / coin.getValue();
				if (cnt > 0) {
					amount = amount % (coin.getValue() * cnt);
					change.put(coin, cnt);
				}	
			}
			
			for (Coin coin : change.keySet()) {
				System.out.println(change.get(coin) + " " + coin.getName());
			}
			
		}

	}

}
