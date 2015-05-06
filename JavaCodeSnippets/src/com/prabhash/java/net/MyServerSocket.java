package com.prabhash.java.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Socket which will count the number of client connections received
 * 
 * @author prrathore
 *
 */
public class MyServerSocket {
	
	private static int connectionCount = 0;

	public static void main(String[] args) throws IOException {
		
		int serverPort = 9000;
		ServerSocket server = new ServerSocket(serverPort);
		
		System.out.println("Server is running at port: " + serverPort);
		
		boolean isStopped = false;
		while(!isStopped){
		    Socket clientSocket = server.accept();
		    
		    connectionCount++; //increment Client Connection when new connection received
		    
		    System.out.println("Number of client connection received # " + connectionCount);
		    
		    clientSocket.close(); //close client connection
		    
		}
		
		System.out.println("Server is going to stop!!");
		
		server.close(); //close server socket
		
		System.out.println("Server stopped!");
		
	}

}
