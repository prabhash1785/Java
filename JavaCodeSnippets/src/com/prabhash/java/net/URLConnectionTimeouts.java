package com.prabhash.java.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Sample code to show how url connection and read timeouts work.
 * 
 * @author prrathore
 *
 */
public class URLConnectionTimeouts {
	
	public static void main(String[] args) {
		
		final String webAddress = "http://jsonapi.org";
	
		try {
			
			final URL url = new URL(webAddress); 
			final URLConnection urlConnection = url.openConnection(); // this does not open connection
			
			urlConnection.setConnectTimeout(2000);
			urlConnection.setReadTimeout(5000);
			
			BufferedInputStream bIn = new BufferedInputStream(urlConnection.getInputStream());
			
			byte[] data = new byte[64]; // byte buffer to read data from BuffererdInputStream
			
			while(bIn.read(data) != -1) {
				
				for(byte b : data) {
					System.out.print((char)b);
				}
				System.out.println("\n");
			}
			
			bIn.close();
	
		} catch(IOException io) {
			io.printStackTrace();
		}

	}

}
