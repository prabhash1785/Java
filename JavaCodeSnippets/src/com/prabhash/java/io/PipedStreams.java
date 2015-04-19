package com.prabhash.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * In Java, two threads running inside same process (same JVM) can communicate with each other using Piped Streams from java.io package.
 * 
 * Do not use same thread to read from one pipe and write to other pipe stream, this can cause deadlock situations.
 * 
 * @author prrathore
 *
 */
public class PipedStreams {

	public static void main(String[] args) throws IOException {
		
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);
		
		//try {
			
			Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						output.write("Hello Piped Streams!! Used for Inter Thread Communication".getBytes());
					} catch(IOException io) {
						io.printStackTrace();
					}
					
				}
			});
			
			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					
					try {
						int data = input.read();
						
						while(data != -1) {
							System.out.println(data + " ===> " + (char)data);
							data = input.read();
						}
						
					} catch(IOException io) {
						io.printStackTrace();
					}
					
					
				}
			});
			
			thread1.start();
			thread2.start();
			
//		} finally {
//			
//			if(input != null) {
//				input.close();
//			}
//			
//			if(output != null) {
//				output.close();
//			}
//			
//		}

	}

}
