package com.prabhash.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * A sample byte buffer.
 * 
 * @author prrathore
 *
 */
public class SampleByteBuffer {

	public static void main(String[] args) {
		
		RandomAccessFile file;
		
		try {
			file = new RandomAccessFile("./data/data.txt", "rw");
			
			FileChannel fileChannel = file.getChannel();
			
			ByteBuffer byteBuffer = ByteBuffer.allocate(48);
			
			int bytesRead = fileChannel.read(byteBuffer);
			
			while(bytesRead != -1) {
				byteBuffer.flip(); //flip it for read from write
				
				while(byteBuffer.hasRemaining()) {
					System.out.println((char) byteBuffer.get());
				}
				
				byteBuffer.clear();
				bytesRead = fileChannel.read(byteBuffer);
				
			}
			
		} catch(FileNotFoundException f) {
			f.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
		}
		
	}

}
