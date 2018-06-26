package com.techelevator.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.techelevator.exception.FileAccessException;

/**
 * Writes text to a text based file
 *
 */
public class TextWriter {
	
	private File file = null;
	
	/**
	 * Creates a new File object from the path passed in the filename argument
	 * @param filename
	 */
	public TextWriter(String filename) {
		file = new File(filename);
	}

	/**
	 * Writes a List of Strings to a text based file.  If append is true, it will append them to the
	 * end of the file.  If append is false, it will overwrite the existing file.
	 * @param entries
	 * @param append
	 */
	public void writeLines(List<String> entries, boolean append) {
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new FileAccessException(e, "Failed to create text file", this.getClass().getName());
			}
		}
		
		try (FileWriter writer = new FileWriter(file.getAbsoluteFile(), append);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			for (String entry : entries) {
				bufferedWriter.write(entry + "\r\n");				
			}
		} catch (IOException e) {
			throw new FileAccessException(e, "Failed to write to text file", this.getClass().getName());
		}
		
	}
	
}
