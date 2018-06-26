package com.techelevator.file.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Data object to hold the Log File entries
 *
 */
public class LogEntry {
	
	private LocalDateTime dateTime;
	private String action;
	private float beginningBalance;
	private float endingBalance;
	
	public LogEntry(String action, float beginningBalance, float endingBalance) {
		this.dateTime = LocalDateTime.now();
		this.action = action;
		this.beginningBalance = beginningBalance;
		this.endingBalance = endingBalance;
	}
	
	public LogEntry(String itemName, String slotId, float beginningBalance, float endingBalance) {
		this((String.format("%0$-8s", itemName.length() > 8 ?itemName.substring(0,8) : itemName) + " " + slotId), beginningBalance, endingBalance);
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getAction() {
		return action;
	}

	public float getBeginningBalance() {
		return beginningBalance;
	}

	public float getEndingBalance() {
		return endingBalance;
	}
	
	public String getFormattedDateTime() {
		return dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));
	}
	
}
