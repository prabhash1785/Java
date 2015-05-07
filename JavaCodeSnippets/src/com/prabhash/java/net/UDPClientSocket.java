package com.prabhash.java.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP Server Socket
 * 
 * @author prrathore
 *
 */
public class UDPClientSocket {

	public static void main(String[] args) throws Exception {
		
		byte[] data = "123456789".getBytes();
		
		InetAddress address = InetAddress.getLocalHost();
		
		DatagramPacket packet = new DatagramPacket(data, data.length, address, 9000);
		
		DatagramSocket datagramSocket = new DatagramSocket();
		datagramSocket.send(packet);
		
		datagramSocket.close();

	}

}
