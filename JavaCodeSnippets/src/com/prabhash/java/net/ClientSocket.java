package com.prabhash.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Client Socket
 * 
 * @author prrathore
 *
 */
public class ClientSocket {

	public static void main(String[] args) throws IOException {
		
		Socket clientSocket = new Socket("localhost", 9000);
		System.out.println("Opened socket connection with server..");
		
		OutputStream outputStream = clientSocket.getOutputStream();
		outputStream.write("Hello Server\n".getBytes());
		outputStream.flush();
		
		InputStream inputStream = clientSocket.getInputStream();
		byte[] data = new byte[10];
		System.out.print("Server said:: ");
		int dataRead = inputStream.read(data);
		while(dataRead > 0) {
			System.out.print(new String(data));
			dataRead = inputStream.read(data);
		}
		
		outputStream.close();
		inputStream.close();
		clientSocket.close();
	}

}
