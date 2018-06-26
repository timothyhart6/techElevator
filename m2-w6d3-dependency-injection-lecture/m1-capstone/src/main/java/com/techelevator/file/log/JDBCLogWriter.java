package com.techelevator.file.log;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCLogWriter implements LogWriter {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCLogWriter(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void log(LogEntry entry) {
		String sql = "INSERT INTO log (action, beginning_balance, ending_balance, entry_date) " +
				"VALUES(?, ?, ?, ?);";
		
		jdbcTemplate.update(sql, entry.getAction(), entry.getBeginningBalance(), entry.getEndingBalance(), entry.getDateTime());
		
	}
}
