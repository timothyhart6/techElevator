package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private TestInventoryDAO inventoryDao;
	private VendingMachine machine;

	@Before
	public void setup() {
		initializeInventoryDao();
		machine = new VendingMachine(inventoryDao);
	}
	
	@Test
	public void returns_inventory_of_slots() {
		List<Slot> results = machine.getInventory();
		
		assertNotNull(results);
		assertTrue(inventoryDao.getInventory().containsAll(results));
		assertTrue(results.containsAll(inventoryDao.getInventory()));
	}
	
	@Test
	public void keeps_track_of_customer_balance() {
		machine.addMoney(100);
		machine.addMoney(125);
		machine.addMoney(75);
		assertEquals(300, machine.getCurrentBalance());
	}
	
	@Test
	public void throws_OutOfStockException_when_product_has_zero_quantity() {
		Slot emptySlot = new Slot("C1", "GrainWaves", 100, 0);
		inventoryDao.addSlot(emptySlot);
		machine.addMoney(200);
		try {
			machine.dispenseItem("C1");
			fail("Did not throw Exception");
		} catch(OutOfStockException e) {
			// This is what we want, test passes
		}
	}

	private void initializeInventoryDao() {
		inventoryDao = new TestInventoryDAO();
		List<Slot> inventory = new ArrayList<>();
		inventory.add(new Slot("A1", "Chips", 200, 5));
		inventory.add(new Slot("B1", "Pretzels", 150, 5));
		inventoryDao.setInventory(inventory);
	}
}
