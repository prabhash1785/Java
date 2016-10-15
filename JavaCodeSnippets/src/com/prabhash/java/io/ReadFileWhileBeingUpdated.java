package com.prabhash.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Read a file while it's being updated.
 * 
 * @author Prabhash Rathore
 *
 */
public class ReadFileWhileBeingUpdated {

	public static void readFile(File file, Long fileLength) throws IOException {
		String line = null;

		BufferedReader in = new BufferedReader(new java.io.FileReader(file));
		in.skip(fileLength);
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
	}

	public static void main(String args[]) throws Exception {
		if (args.length > 0) {
			File file = new File(args[0]);
			System.out.println(file.getAbsolutePath());
			if (file.exists() && file.canRead()) {
				long fileLength = file.length();
				readFile(file, 0L);
				while (true) {

					if (fileLength < file.length()) {
						readFile(file, fileLength);
						fileLength = file.length();
					}
				}
			}
		} else {
			System.out.println("No file to read");
		}
	}
}
