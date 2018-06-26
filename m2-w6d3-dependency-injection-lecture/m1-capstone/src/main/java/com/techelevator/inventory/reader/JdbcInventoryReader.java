package com.techelevator.inventory.reader;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.inventory.Slot;

public class JdbcInventoryReader extends InventoryReader {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcInventoryReader(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Map<String, Slot> read() {
		Map<String, Slot> slots = new LinkedHashMap<String, Slot>();
		
		String sql= "SELECT slot, name, price, type FROM inventory";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Slot slot = mapRowToItem(results);
			slots.put(results.getString("slot"), slot);
		}
		return slots;
	}
	
	private Slot mapRowToItem(SqlRowSet results) { 
		String name = results.getString("name");
		float price = results.getFloat("price");
		return super.buildItemFromParts(results.getString("type"), name, price);
	}

}
