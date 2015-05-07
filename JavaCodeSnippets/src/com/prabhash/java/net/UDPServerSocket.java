package com.prabhash.java.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP Server Socket. This will listen to clients on UDP Port and receive data from client.
 * 
 * @author prrathore
 *
 */
public class UDPServerSocket {
	
	private static int connectionCount = 0;

	public static void main(String[] args) throws Exception {
		
		DatagramSocket serverSocket = new DatagramSocket(9000);
		System.out.println("UDP Server running on Port 9000");
		
		boolean isStopped = false;
		while(!isStopped) {
			
			byte[] buffer = new byte[256];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			
			serverSocket.receive(packet);
			
			connectionCount++;
			System.out.println("Connection Count: " + connectionCount);
			
			System.out.println("Data received from clinet: " + packet.getData());
			
		}
		
		serverSocket.close();

	}

}
