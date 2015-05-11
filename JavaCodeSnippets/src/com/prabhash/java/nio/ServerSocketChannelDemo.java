package com.prabhash.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * This class will listen for client connections and print the messages sent by clients.
 * 
 * @author prrathore
 *
 */
public class ServerSocketChannelDemo {
	
	private static boolean serverState = true;
	private static int connectionCount = 0;

	public static void main(String[] args) {
		
		ServerSocketChannel serverChannel = null;
		
		try {
			
			
			serverChannel = ServerSocketChannel.open();
			
			serverChannel.bind(new InetSocketAddress(9999));
			
			while(serverState) {
				
				SocketChannel socketChannel = serverChannel.accept();
				connectionCount++;
				
				System.out.println("Connection count received from client# " + connectionCount);
				
				ByteBuffer byteBuffer = ByteBuffer.allocate(48);
				
				int byteCount = socketChannel.read(byteBuffer); //data read into a byte buffer
				
				String clientMessage = "";
				
				while(byteCount != -1) {
					
					byteBuffer.flip();
					
					while(byteBuffer.hasRemaining()) {
						byte b = byteBuffer.get();
						char c = (char) b;
						clientMessage += c;
					}
					
					byteBuffer.clear();
					
					byteCount = socketChannel.read(byteBuffer);
				}
				
				System.out.println("Message from client number " + connectionCount + " is: " + clientMessage);
								
				//close the socket
				socketChannel.close();
								
			}
			
		} catch(IOException io) {
			io.printStackTrace();
		} finally {
			if(serverChannel != null) {
				try {
					serverChannel.close();
				} catch(IOException io) {
					io.printStackTrace();
				}
			}
			
		}

	}

}
