package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class InventoryFileDAOTest {

	@Test
	public void returns_one_slot_objet_for_each_line_in_inentory_file() throws FileNotFoundException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A1|cheesey puffs|1.50\nA2|potato chips|1.00\nB1|Dr. Salt|2.50".getBytes());
		InventoryFileDAO dao = new InventoryFileDAO(inputStream);
		
		List<Slot> results = dao.getInventory();
		
		assertNotEquals(null, results);
		assertEquals(3, results.size());
	}

	@Test
	public void reads_location_from_inventory_file() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A1|cheesey puffs|1.50\nA2|potato chips|1.00\nB1|Dr. Salt|2.50".getBytes());
		InventoryFileDAO dao = new InventoryFileDAO(inputStream);
		
		List<Slot> results = dao.getInventory();
		
		assertEquals("A1", results.get(0).getLocation());
		assertEquals("A2", results.get(1).getLocation());
		assertEquals("B1", results.get(2).getLocation());
	}
	
	@Test
	public void reads_productName_from_inventory_file() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A1|cheesey puffs|1.50\nA2|potato chips|1.00\nB1|Dr. Salt|2.50".getBytes());
		InventoryFileDAO dao = new InventoryFileDAO(inputStream);
		
		List<Slot> results = dao.getInventory();
		
		assertEquals("cheesey puffs", results.get(0).getProductName());
		assertEquals("potato chips", results.get(1).getProductName());
		assertEquals("Dr. Salt", results.get(2).getProductName());
	}
	
	@Test
	public void reads_price_from_inventory_file() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A1|cheesey puffs|1.50\nA2|potato chips|1.00\nB1|Dr. Salt|2.50".getBytes());
		InventoryFileDAO dao = new InventoryFileDAO(inputStream);
		
		List<Slot> results = dao.getInventory();
		
		assertEquals(150, results.get(0).getPrice());
		assertEquals(100, results.get(1).getPrice());
		assertEquals(250, results.get(2).getPrice());
	}
	
	@Test
	public void initial_quantity_is_five() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A1|cheesey puffs|1.50\nA2|potato chips|1.00\nB1|Dr. Salt|2.50".getBytes());
		InventoryFileDAO dao = new InventoryFileDAO(inputStream);
		
		List<Slot> results = dao.getInventory();
		
		assertEquals(5, results.get(0).getQuantity());
		assertEquals(5, results.get(1).getQuantity());
		assertEquals(5, results.get(2).getQuantity());
	}
}
