package com.techelevator.file.report;

import java.util.List;

import com.techelevator.inventory.item.Item;

/**
 * Interface for the Vending Machines Sales Report writer
 *
 */
public interface ReportWriter {

	public void write(List<Item> lines);
}
