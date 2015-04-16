package com.prabhash.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Basic program to copy bytes from one file to another file. This program will use FileInputStream class to read a file and write using
 * FileOutput stream.
 * 
 * I understand copying a text file can be done using a higher level stream class like a FileReader but this is just a practice program
 * to write some code using ByteStream.
 * 
 * @author prrathore
 *
 */
public class ByteCopy {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("./data/data.txt");
			out = new FileOutputStream("./data/output.txt"); //this will create a file if file doesn't exist
			
			int c;
			int count = 0;
			
			while((c = in.read()) != -1) {
				out.write(c);
				count++;
			}
			
			System.out.println("Numnber of Bytes copied: " + count);
			
		} finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
		

	}

}
