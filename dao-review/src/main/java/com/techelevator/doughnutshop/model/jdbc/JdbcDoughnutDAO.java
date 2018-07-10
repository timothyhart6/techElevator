package com.techelevator.doughnutshop.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.doughnutshop.model.Doughnut;
import com.techelevator.doughnutshop.model.DoughnutDAO;

public class JdbcDoughnutDAO implements DoughnutDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcDoughnutDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Doughnut> getDoughnuts() {
		List<Doughnut> doughnuts = new ArrayList<Doughnut>();
		String sql = "SELECT * FROM doughnut";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		
		while(result.next()) {
			doughnuts.add(mapRowSetToDoughnut(result));
		}
		
		return doughnuts;
	}

	@Override
	public Doughnut getDoughnut(long id) {
		String sql = "SELECT * FROM doughnut WHERE id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		
		if(result.next()) {
			return mapRowSetToDoughnut(result);
		}
		
		return null;
	}
	
	private Doughnut mapRowSetToDoughnut(SqlRowSet row) {
		Doughnut doughnut = new Doughnut();
		doughnut.setId(row.getLong("id"));
		doughnut.setName(row.getString("name"));
		doughnut.setInventoryCount(row.getInt("inventory_count"));
		
		return doughnut;
	}

}
