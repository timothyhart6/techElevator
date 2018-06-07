package com.techelevator;

public class MinBidAuction extends Auction {

	private int minimumBid;
	
	public MinBidAuction(String itemForSale, int minBid) {
		super(itemForSale);
		this.minimumBid = minBid;
		
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		if (offeredBid.getBidAmount() < this.minimumBid) {
			return false;
		}
		return super.placeBid(offeredBid);
	}
	
	
}
