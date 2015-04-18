package com.prabhash.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Reading from a Character Stream could be by reading one line at a time instead of one character at a time.
 * Also BufferedReader/BufferedWriter could be used to improve reading/writing performance by doing buffering while reading/writing instead
 * of reading/writing to underlying streams every character.
 * 
 * @author prrathore
 *
 */
public class ReadLinesFromFile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufReader = null;
		PrintWriter writer = null;
		
		try {
			bufReader = new BufferedReader(new FileReader("./data/data.txt"));
			writer = new PrintWriter(new FileWriter("./data/lineoutput.txt"));
			
			String line;
			
			while((line = bufReader.readLine()) != null) {
				writer.println(line);
			}
			
		} finally {
			
			if(bufReader != null) {
				bufReader.close();
			}
			
			if(writer != null) {
				writer.close();
			}
			
		}

	}

}
