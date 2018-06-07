package com.techelevator;

import java.util.Scanner;

public class AuctionDemo {

	public static void main(String[] args) {
		
		MinBidAuction auction = new MinBidAuction("Record", 10);
		
	
//		Auction auction = minBidAuction;
//		if (auction instanceof MinBidAuction) {
//			MinBidAuction auctionTwo = (MinBidAuction) auction;
//		}
		
		auction.getNumber();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Buy my " + auction.getItemForSale());
		while (true) {
			
			System.out.println("Enter your name:");
			System.out.print(">>>");
			
			String bidder = in.nextLine();
			
			System.out.println("Place a bid.");
			System.out.print(">>>");
			
			int amount = in.nextInt();
			in.nextLine();
			
			boolean isWinning = auction.placeBid(new Bid(bidder, amount));
			
			System.out.println(auction.getHighBid().getBidder() +  " is winning with " + auction.getHighBid().getBidAmount());
		}

	}

}
