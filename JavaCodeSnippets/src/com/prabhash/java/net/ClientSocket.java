package com.prabhash.java.net;

import java.io.IOException;
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
		
		clientSocket.close();

	}

}
