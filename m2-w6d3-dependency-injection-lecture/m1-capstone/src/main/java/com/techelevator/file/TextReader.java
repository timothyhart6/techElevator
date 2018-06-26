package com.techelevator.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.exception.FileAccessException;

/**
 * Reads lines from a text based file
 *
 */
public class TextReader {
	
private File file = null;
	
	/**
	 * Creates a file object from the path in the filename argument
	 * @param filename
	 */
	public TextReader(String filename) {
		file = new File(filename);
	}
 
	
	/**
	 * Reads lines from a text based file as a List of Strings
	 * @return
	 */
	public List<String> readLines() {
		
		List<String> lines = null;
		
		if (file.exists()) {

			try (FileReader fileReader = new FileReader(file.getAbsoluteFile());
					BufferedReader bufferedReader = new BufferedReader(fileReader)) {

				lines = new ArrayList<String>();
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					lines.add(line);
				}

			} catch (IOException e) {
				throw new FileAccessException(e, "Failed to read Text File", this.getClass().getName());
			}
		}
		
		return lines;
		
	}
}
