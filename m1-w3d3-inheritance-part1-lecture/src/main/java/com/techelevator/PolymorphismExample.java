package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismExample {

	public static void main(String[] args) {
		
		Auction buyoutAuction = new BuyoutAuction("Buyout", 10);
		Auction reserveAuction = new ReserveAuction("Reserve", 20);
		Auction minBidAuction = new MinBidAuction("MinBid", 30);
		Auction auction = new Auction("Auction");
		
		List<Auction> auctions = new ArrayList<Auction>();
		auctions.add(buyoutAuction);
		auctions.add(reserveAuction);
		auctions.add(minBidAuction);
		auctions.add(auction);
		
		for (Auction act : auctions) {
			act.placeBid(new Bid("Jane", 50));
			System.out.println(act.getItemForSale() + "  " + act.getHighBid().getBidAmount());
		}
		
		
		
	}
}
