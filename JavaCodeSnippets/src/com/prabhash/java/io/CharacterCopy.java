package com.prabhash.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Use Character Stream to copy content from one file to another. This will copy one character at a time. When compared with Byte Stream,
 * the Character Stream also convents local character set to Unicode convention.
 * 
 * Reader and Writer are the main super classes which provides Character Streams.
 * 
 * @author prrathore
 *
 */
public class CharacterCopy {

	public static void main(String[] args) throws IOException {
		
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		try {
			
			fileReader = new FileReader("./data/data.txt");
			fileWriter = new FileWriter("./data/output.txt");
			
			int c;
			int count = 0;
			
			while((c = fileReader.read()) != -1) {
				fileWriter.write(c);
				count++;
			}
			
			System.out.println("Characters copies: " + count);
			
		} finally {
			if(fileReader != null) {
				fileReader.close();
			}
			
			if(fileWriter != null) {
				fileWriter.close();
			}
		}

	}

}
