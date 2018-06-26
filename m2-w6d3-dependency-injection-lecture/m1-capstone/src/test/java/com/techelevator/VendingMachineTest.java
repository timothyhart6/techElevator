package com.techelevator;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.exception.InvalidAmountException;
import com.techelevator.file.log.LogWriterMock;
import com.techelevator.file.report.SalesReportWriterMock;
import com.techelevator.inventory.item.Chip;
import com.techelevator.inventory.item.Item;
import com.techelevator.inventory.reader.InventoryReaderMock;
import com.techelevator.transaction.CompleteTransaction;
import com.techelevator.transaction.change.Coin;
import com.techelevator.transaction.change.Dime;
import com.techelevator.transaction.change.Quarter;

public class VendingMachineTest {

	private final static String ITEM_LIST_FIRST_FORMATTED_ITEM = "A1   Corn Crisps              $3.05           5";
	private final static String ITEM_LIST_LAST_FORMATTED_ITEM = "D4   Unoemint                 $0.75           5";
	VendingMachine vendingMachine;
	
	@Before
	public void setup() {
		vendingMachine = new VendingMachine(new LogWriterMock(), new InventoryReaderMock(), new SalesReportWriterMock());
	}
	
	@Test
	public void get_items_as_string_list() {
		List<String> itemList = vendingMachine.getItemsAsStringList();
		
		Assert.assertEquals(16, itemList.size());
		Assert.assertEquals(ITEM_LIST_FIRST_FORMATTED_ITEM, itemList.get(0));
		Assert.assertEquals(ITEM_LIST_LAST_FORMATTED_ITEM, itemList.get(itemList.size() - 1));
	}
	
	@Test
	public void add_to_balance() throws InvalidAmountException {
		vendingMachine.addToBalance(10f);
		Assert.assertEquals(10f, vendingMachine.getBalance(), 0);
	}
	
	@Test
	public void make_purchase_of_invalid_item() {
		Assert.assertEquals(VendingMachine.PurchaseStatus.INVALIDITEM, vendingMachine.makePurchase("Q2"));
	}
	
	@Test
	public void make_purchase_of_not_enough_money() {
		Assert.assertEquals(VendingMachine.PurchaseStatus.NOTENOUGHMONEY, vendingMachine.makePurchase("A1"));
	}
	
	@Test
	public void make_purchase() throws InvalidAmountException {
		vendingMachine.addToBalance(4f);
		Assert.assertEquals(VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
	}
	
	@Test
	public void make_purchase_sold_out() throws InvalidAmountException {
		vendingMachine.addToBalance(20f);
		Assert.assertEquals("Purchase A1 - 1", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase A1 - 2", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase A1 - 3", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase A1 - 4", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase A1 - 5", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase A1 - SOLD OUT", VendingMachine.PurchaseStatus.SOLDOUT, vendingMachine.makePurchase("A1"));
	}
	
	@Test
	public void get_items_as_string_list_sold_out() throws InvalidAmountException {
		
		vendingMachine.addToBalance(20f);
		Assert.assertEquals("Purchase B1 - 1", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("B1"));
		Assert.assertEquals("Purchase B1 - 2", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("B1"));
		Assert.assertEquals("Purchase B1 - 3", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("B1"));
		Assert.assertEquals("Purchase B1 - 4", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("B1"));
		Assert.assertEquals("Purchase B1 - 5", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("B1"));
		
		List<String> itemList = vendingMachine.getItemsAsStringList();
		
		Assert.assertEquals(16, itemList.size());
		
		for (int i = 0 ; i < itemList.size(); i++) {
			if (itemList.get(i).contains("B1")) {
				Assert.assertTrue("B1 is not Sold out", itemList.get(i).toUpperCase().contains("SOLD OUT"));
			} else {
				Assert.assertFalse(i + " is not Sold out", itemList.get(i).toUpperCase().contains("SOLD OUT"));
			}

		}
	}
	
	@Test
	public void complete_transaction_number_of_items() throws InvalidAmountException {
		List<Item> items = completeTransactionHelper().getItems();
		Assert.assertEquals("Wrong number of items purchased", 2, items.size());
	}
	
	@Test
	public void complete_transaction_correct_items() throws InvalidAmountException {
		List<Item> items = completeTransactionHelper().getItems();
		Assert.assertEquals("A1 not in puchase list", new Chip("Corn Crisps", 3.05f), items.get(0));
		Assert.assertEquals("D1 not in puchase list", new Chip("I-Chews", 0.85f), items.get(1));
	}
	
	@Test
	public void complete_transaction_machine_reset() throws InvalidAmountException {
		completeTransactionHelper().getItems();
		Assert.assertEquals(vendingMachine.getBalance(), 0f, 0);
	}
	
	@Test
	public void complete_transaction_correct_change() throws InvalidAmountException {
		Map<Coin, Integer> change = completeTransactionHelper().getChange();
		
		Assert.assertEquals(2, change.size());
		
		// Should return 1.10 - 4 quarters and 1 dime
		for (Coin coin : change.keySet()) {
			assertTrue("Wrong type of coin returned: " + coin, coin.equals(new Quarter()) || coin.equals(new Dime()));
			if (coin.equals(new Quarter())) {
				Assert.assertEquals(new Integer(4), change.get(coin));
			}
			if (coin.equals(new Dime())) {
				Assert.assertEquals(new Integer(1), change.get(coin));
			}
		}
		

	}
	
	private CompleteTransaction completeTransactionHelper() throws InvalidAmountException {
		vendingMachine.addToBalance(5f);
		Assert.assertEquals("Purchase A1", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("A1"));
		Assert.assertEquals("Purchase D1", VendingMachine.PurchaseStatus.OK, vendingMachine.makePurchase("D1"));
		return vendingMachine.finishTransaction();
	}
	

	
}
