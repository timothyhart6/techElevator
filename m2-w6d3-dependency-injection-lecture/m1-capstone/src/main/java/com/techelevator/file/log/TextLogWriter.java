package com.techelevator.file.log;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.file.TextWriter;

/**
 * Text based file writer for the Log
 *
 */
public class TextLogWriter implements LogWriter {

	private static final String LOGFILE_NAME = "Log.txt";
	private TextWriter writer = null;
	 
	/**
	 * Creates a new TextWriter for the Log file
	 */
	public TextLogWriter() {
		writer = new TextWriter(LOGFILE_NAME);
	}
	
	
	/**
	 * Writes a log entry to the log file
	 */
	@Override
	public void log(LogEntry entry) {
		writer.writeLines(prepareLogString(entry), true);
		
	}
	
	private List<String> prepareLogString(LogEntry entry) {
		String beginBal = String.format("$%1.2f", entry.getBeginningBalance());
		String endBal = String.format("$%1.2f", entry.getEndingBalance());
		
		String entryString = String.format("%1$-23s", entry.getFormattedDateTime());
		entryString += String.format("%1$-12s", entry.getAction());
		entryString += String.format("%1$-8s", beginBal);
		entryString += String.format("%1$8s", endBal);
		
		List<String> entries = new ArrayList<String>();
		entries.add(entryString);
		return entries;
	}
	
	


}
