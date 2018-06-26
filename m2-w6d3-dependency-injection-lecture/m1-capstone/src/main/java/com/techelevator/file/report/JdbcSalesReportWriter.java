package com.techelevator.file.report;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.inventory.item.Item;

public class JdbcSalesReportWriter implements ReportWriter {

	private static final int SALES_REPORT_ID = 1;
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcSalesReportWriter(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void write(List<Item> lines) {
		
		float balance = 0;
		
		for (Item item : lines) {
			balance += item.getPrice();
			writeItem(item, SALES_REPORT_ID);
		}
		
		updateTotalAmount(balance, SALES_REPORT_ID);
		
	}
	
	private void updateTotalAmount(float amount, int salesReportId) {
		String select = "Select total_amount FROM sales_report WHERE id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(select, salesReportId);
		result.next();
		float newTotal = result.getFloat("total_amount") + amount;
		
		String update = "UPDATE sales_report SET total_amount = ? WHERE id = ?";
		jdbcTemplate.update(update, newTotal, salesReportId);
	}
	
	private void writeItem(Item item, int salesReportId) {
		
		String sqlSelectItem = "Select item, number_sold FROM sales_report_items WHERE sales_report_id = ? AND item = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectItem, salesReportId, item.getName());
		if (result.next()) {
			// The item already exists, so update it
			String update = "UPDATE sales_report_items SET number_sold = ? WHERE sales_report_id = ? AND item = ?";
			int newCount = result.getInt("number_sold") + 1;
			jdbcTemplate.update(update, newCount, salesReportId, item.getName());
		} else {
			// The item doesn't exist so add it
			String insert = "INSERT INTO sales_report_items (sales_report_id, item, number_sold) VALUES (?, ?, ?)";
			jdbcTemplate.update(insert, salesReportId, item.getName(), 1);
		}
		
	}
	
	

}
