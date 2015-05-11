package com.prabhash.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Client which will send message to a ServerSocketChannel using TCP/IP protocol.
 * 
 * @author prrathore
 *
 */
public class SocketChannelClient {

	public static void main(String[] args) {
		
		SocketChannel socketChannel = null;
		
		try {
			
			socketChannel = SocketChannel.open();
			
			socketChannel.connect(new InetSocketAddress("localhost", 9999));
			
			String newData = "New String to write to file..." + System.currentTimeMillis();

			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());

			buf.flip();

			while(buf.hasRemaining()) {
				socketChannel.write(buf);
			}
			
			//read message received from server channel
			ByteBuffer serverMessage = ByteBuffer.allocate(48);
			
			int byteCount = socketChannel.read(serverMessage); //data read into a byte buffer
			
			String message = "";
			
			while(byteCount != -1) {
				
				serverMessage.flip();
				
				while(serverMessage.hasRemaining()) {
					byte b = serverMessage.get();
					char c = (char) b;
					message += c;
				}
				
				serverMessage.clear();
				
				byteCount = socketChannel.read(serverMessage);
			}
			
			System.out.println("Message from server is:: " + message);
			
		} catch(IOException io) {
			io.printStackTrace();
		} finally {
			if(socketChannel != null) {
				try {
					socketChannel.close();
				} catch(IOException io) {
					io.printStackTrace();
				}
			}
		}

	}

}
