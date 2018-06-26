package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.exception.InvalidAmountException;
import com.techelevator.file.log.LogEntry;
import com.techelevator.file.log.LogWriter;
import com.techelevator.file.report.ReportWriter;
import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Slot;
import com.techelevator.inventory.item.Item;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.transaction.CompleteTransaction;
import com.techelevator.transaction.CurrencyHandler;
import com.techelevator.transaction.change.Coin;

/**
 * The VendingMachine class handles the internal business processing of the vending machine
 *
 */
public class VendingMachine {

	public enum PurchaseStatus {
		OK,
		SOLDOUT,
		NOTENOUGHMONEY,
		INVALIDITEM
	}
	
	private LogWriter log;
	private Inventory inventory;
	private ReportWriter salesReport;
	private CurrencyHandler currencyHandler;
	

	private List<Item> cart;
	
	/**
	 * Constructor sets the working instance of the LogWriter, InventoryReader, and ReportWriter
	 * Creates a ArrayList to act as a cart and a CurrencyHandler.
	 * @param logWriter
	 * @param reader
	 * @param reportWriter
	 */
	public VendingMachine(LogWriter logWriter, InventoryReader reader, ReportWriter reportWriter) {
		this.log = logWriter;
		inventory = new Inventory(reader);
		cart = new ArrayList<Item>();
		currencyHandler = new CurrencyHandler();
		salesReport = reportWriter;
	}
	
	/**
	 * Creates and returns a formatted List of Strings for each item in the Inventory
	 * @return
	 */
	public List<String> getItemsAsStringList(){
		
		List<String> items = new ArrayList<String>();
		
		for (String key : inventory.getSlots().keySet()) {
			Slot slot = inventory.getSlots().get(key);
			items.add(String.format("%1$-5s%2$-25s$%3$.2f%4$12s", 
					key, slot.getItem().getName(), 
					slot.getItem().getPrice(), 
					slot.isSoldOut() ? "Sold Out" : String.valueOf(slot.getCount())));
		}
		
		return items;
	} 

	/**
	 * Gets the currrent customer balance
	 * @return
	 */
	public float getBalance() {
		return currencyHandler.getBalance();
	}
	
	/**
	 * Adds money to the current customer balance
	 * Throws an InvalidAmountException if the requested amount is negative
	 * @param amount
	 * @throws InvalidAmountException
	 */
	public void addToBalance(float amount) throws InvalidAmountException {
		float originalBal = currencyHandler.getBalance();
		try {
			currencyHandler.addToBalance(amount);
			log.log(new LogEntry("FEED MONEY", originalBal, currencyHandler.getBalance()));	
		} catch(InvalidAmountException e) {
			throw e;
		}
		
	}
	
	/**
	 * Handles the customers purhcase
	 * @param slotId
	 * @return
	 */
	public PurchaseStatus makePurchase(String slotId) {
		
		PurchaseStatus purchaseStatus = determinePurchaseStatus(slotId);
		
		if (purchaseStatus == PurchaseStatus.OK) {
			Item item = inventory.getItemFromSlot(slotId);
			
			float startingBalance = currencyHandler.getBalance();
			try {
				currencyHandler.substractFromBalance(item.getPrice());
				cart.add(item);
				log.log(new LogEntry(item.getName(), slotId, startingBalance, currencyHandler.getBalance()));
			} catch (InvalidAmountException e) {
				return PurchaseStatus.NOTENOUGHMONEY;	
			}
			
		}

		return purchaseStatus;
	}
	
	/**
	 * Comples the transaction by getting change, updating the sales report, and getting change
	 * @return
	 */
	public CompleteTransaction finishTransaction() {		
		Map<Coin, Integer> change = currencyHandler.getChange();
		CompleteTransaction completeTransaction = new CompleteTransaction(cart, change);
		salesReport.write(cart);
		reset();
		return completeTransaction;
	}
	
	
	private PurchaseStatus determinePurchaseStatus(String slotId)  {
		if (!inventory.isValidSlot(slotId)) {
			return PurchaseStatus.INVALIDITEM;
		}
		if (inventory.isItemSoldOut(slotId)) {
			return PurchaseStatus.SOLDOUT;
		}
		if (inventory.getItemPriceFromSlot(slotId) > currencyHandler.getBalance()) {
			return PurchaseStatus.NOTENOUGHMONEY;
		}
		return PurchaseStatus.OK;
	}
	
	
	private void reset() {
		this.cart = new ArrayList<Item>();
	}
	
}
