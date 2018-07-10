package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.file.log.JDBCLogWriter;
import com.techelevator.file.log.LogWriter;
import com.techelevator.file.log.TextLogWriter;
import com.techelevator.file.report.JdbcSalesReportWriter;
import com.techelevator.file.report.ReportWriter;
import com.techelevator.file.report.SalesReportWriter;
import com.techelevator.inventory.reader.CardInventoryReader;
import com.techelevator.inventory.reader.CsvInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.view.Menu;

/**
 * Starts the vending machine applicatoin
 * Creates a new VendingMachineCLI and creates and passes it the inventory reader to use
 *
 */
public class VendingMachineStart {
	
	public static void main(String[] args) {
		
		/*
		 * Datasource for the JDBC versions
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/vendingmachine");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		
		/*
		 * Creates the menu and injects the System.in and System.out as the input and output stream
		 * that will be used for user interaction
		 */
		Menu menu = new Menu(System.in, System.out);
		
		/*
		 * Original Inventory CSV File Reader, Text File log writer, and Text file Sales Report Writer
		 */
		//InventoryReader reader = new CsvInventoryReader();
		LogWriter logWriter = new TextLogWriter();
		//ReportWriter salesReportWriter = new SalesReportWriter();

		

		/*
		 * JDBC version of the Inventory Reader, Log Writer, and Sales Writer.  These classes read/write from the 
		 * vendingmachine database instead of a text file.
		 */
		//InventoryReader reader = new com.techelevator.inventory.reader.JdbcInventoryReader(dataSource);
		//LogWriter logWriter = new JDBCLogWriter(dataSource);
		ReportWriter salesReportWriter = new JdbcSalesReportWriter(dataSource);
		InventoryReader reader = new CardInventoryReader();
		
		/*
		 *  Injects the Menu, Inventory Reader, Log Writer, and Sales Writer that we wish to use.  Any combination can be used.
		 *  This inverts the control of each functionality from the Vending Machine to this class.
		 */
		VendingMachineCLI cli = new VendingMachineCLI(menu, reader, logWriter, salesReportWriter);
		cli.run();
	}
}
