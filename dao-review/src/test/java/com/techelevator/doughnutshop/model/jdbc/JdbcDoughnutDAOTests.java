package com.techelevator.doughnutshop.model.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.doughnutshop.model.Doughnut;
import com.techelevator.doughnutshop.model.DoughnutDAO;
import com.techelevator.doughnutshop.model.jdbc.JdbcDoughnutDAO;

public class JdbcDoughnutDAOTests {

	private static SingleConnectionDataSource dataSource;
	private DoughnutDAO doughnutDAO;
	private JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void beforeAll() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/doughnut_shop");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@Before 
	public void before() {
		doughnutDAO = new JdbcDoughnutDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		// TRUNCATE EXAMPLE
		jdbcTemplate.execute("TRUNCATE doughnut, filling, topping CASCADE");
	}
	
	@After
	public void after() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@AfterClass
	public static void afterAll() {
		dataSource.destroy();
	}
	
	@Test
	public void getDoughnuts_returns_all_of_the_doughnuts() {
		// ARRANGE
		Doughnut testDoughnut = insertTestDoughnut();
				
		// ACT
		List<Doughnut> results = doughnutDAO.getDoughnuts();
		
		// ASSERT
		assertFalse(results.isEmpty());
		assertEquals(1, results.size());
		
		// We know we got a single doughnut back, so let's make sure that the details match what we sent
		Doughnut actualDoughnut = results.get(0);
		assertDoughnutsAreTheSame(testDoughnut, actualDoughnut);
	}
	
	@Test
	public void getDoughnuts_returns_an_empty_list_when_there_arent_any_doughnuts() {
		// ARRANGE
		// In this case, we don't want any doughnuts to exist, so no INSERT necessary...
		
		// ACT
		List<Doughnut> results = doughnutDAO.getDoughnuts();
		
		// ASSERT
		assertTrue(results.isEmpty());
	}
	
	@Test
	public void getDoughnut_returns_the_doughnut_with_the_specified_id() {
		// ARRANGE
		Doughnut testDoughnut = insertTestDoughnut();
		
		// ACT
		Doughnut actualDoughnut = doughnutDAO.getDoughnut(testDoughnut.getId());
		
		// ASSERT
		assertDoughnutsAreTheSame(testDoughnut, actualDoughnut);
	}
	
	@Test
	public void getDoughnut_returns_null_if_the_doughnut_cannot_be_found() {
		// ARRANGE
		Doughnut testDoughnut = insertTestDoughnut();
				
		// ACT
		Doughnut actualDoughnut = doughnutDAO.getDoughnut(testDoughnut.getId() + 1);
				
		// ASSERT
		assertNull(actualDoughnut);
	}
	
	private Doughnut insertTestDoughnut() {
		String doughnutName = "HOMER SIMPSON TEST DOUGHNUT";
		long doughnutId = jdbcTemplate.queryForObject(
				"INSERT INTO doughnut (name) VALUES (?) RETURNING id",
				Long.class,
				doughnutName);
		
		Doughnut testDoughnut = new Doughnut();
		testDoughnut.setName(doughnutName);
		testDoughnut.setId(doughnutId);
		
		return testDoughnut;
	}
	
	private void assertDoughnutsAreTheSame(Doughnut expected, Doughnut actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getId(), actual.getId());
	}
}
