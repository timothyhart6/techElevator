package com.techelevator.file.report;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.file.TextReader;
import com.techelevator.file.TextWriter;
import com.techelevator.inventory.item.Item;

/**
 * The Vending Machines text file based Sales Report Writer
 *
 */
public class SalesReportWriter implements ReportWriter {

	private static final String REPORT_PATH = "salesReport.txt";
	private TextReader reader = null;
	private TextWriter writer = null;
	
	/**
	 * Creates a next TextReader and TextWriter for the Sales Report
	 */
	public SalesReportWriter() {
		reader = new TextReader(REPORT_PATH);
		writer = new TextWriter(REPORT_PATH);
	}

	
	/**
	 * Writes a List of Vending Machine items to the SalesReport
	 */
	@Override
	public void write(List<Item> items) {
		writer.writeLines(buildSalesReport(readSalesReport(), items), false);
	}
	
	private List<String> buildSalesReport(SalesReportEntries salesReport, List<Item> items) {
		List<String> lines = new ArrayList<String>();

		double totalSales = salesReport.getTotalSales();
		for (Item item : items) {
			int itemCount = 1;
			if (salesReport.hasEntries()) {
				if (salesReport.getEntries().containsKey(item.getName())) {
					itemCount += salesReport.getEntries().get(item.getName());					
				} 
			}
			salesReport.getEntries().put(item.getName(), itemCount);
			totalSales += item.getPrice();
		}
		
		for (String name : salesReport.getEntries().keySet()) {
			lines.add(name + "|" + salesReport.getEntries().get(name));
			
		}
		
		lines.add("");
		lines.add("**TOTAL SALES** $" + String.format("%.2f", totalSales));
		return lines;
	}
	
	private SalesReportEntries readSalesReport(){
		SalesReportEntries salesReportEntries = new SalesReportEntries();
		
		List<String> lines = reader.readLines();
		if (lines != null) {
			String[] parts;
			for (String line : lines) {
				if (line.contains("TOTAL SALES")) {
					salesReportEntries.setTotalSales(Double.parseDouble(line.substring(line.indexOf('$') + 1)));
				} else if (!line.isEmpty()) {
					parts = line.split("\\|");
					if (parts.length == 2) {
						salesReportEntries.getEntries().put(parts[0], Integer.parseInt(parts[1]));
					}
				}
			}
		}
		
		return salesReportEntries;
	}
	
	

}
