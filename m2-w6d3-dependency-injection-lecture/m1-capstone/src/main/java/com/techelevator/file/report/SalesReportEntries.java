package com.techelevator.file.report;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Data object to hold the Sales Report line entries
 *
 */
public class SalesReportEntries {

	private double totalSales = 0;
	private Map<String, Integer> entries = new LinkedHashMap<String, Integer>();
	
	public boolean hasEntries() {
		return !entries.isEmpty();
	}
	
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	public Map<String, Integer> getEntries() {
		return entries;
	}
	
	
	
	
}
