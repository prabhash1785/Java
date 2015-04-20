package com.prabhash.java.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataStream to read and write primitive data types.
 * 
 * @author prrathore
 *
 */
public class DataStreams {

	public static void main(String[] args) throws IOException {
		
		DataOutputStream outputStream = null;
		FileOutputStream fileOutput = null;
		
		DataInputStream inputStream = null;
		FileInputStream fileInput = null;
		
		try {
			
			fileOutput = new FileOutputStream("./data/DataStream.txt");			
			outputStream = new DataOutputStream(fileOutput);
			
			outputStream.writeInt(100);
			outputStream.writeChar(67);
			outputStream.writeBytes("San Jose is the Silicon Valley");
			outputStream.writeBoolean(true);
			
			//Lets read from DataStream
			fileInput = new FileInputStream("./data/DataStream.txt");
			inputStream = new DataInputStream(fileInput);
			
			int number = inputStream.readInt();
			System.out.println("Number:" + number);
			
			System.out.println("Char is: " + inputStream.readChar());
			
			boolean flag = inputStream.readBoolean();
			System.out.println("Flag: " + flag);
			
			System.out.println("String is: " + inputStream.readByte() + " " + inputStream.readByte());
			
		} finally {
			
			if(fileOutput != null) {
				fileOutput.close();
			}
			
			if(outputStream != null) {
				outputStream.close();
			}
			
			if(fileInput != null) {
				fileInput.close();
			}
			
			if(inputStream != null) {
				inputStream.close();
			}
			
		}

	}

}
