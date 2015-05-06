package com.prabhash.java.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9000);
		
		boolean isStopped = false;
		while(!isStopped){
		    Socket clientSocket = server.accept();
		    System.out.println("Client connection received");
		    
		    clientSocket.close();
		    
		}
		
		server.close();
		
	}

}
