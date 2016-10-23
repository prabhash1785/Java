package com.prabhash.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Server Socket which will count the number of client connections received
 * 
 * @author Prabhash Rathore
 *
 */
public class MyServerSocket {
	
	private static int connectionCount = 0;
	private static final int PORT = 9000; 
	private static Map<String, String> dataStore;
	
	static {
		dataStore = new HashMap<>();
		dataStore.put("foo", "bar");
		dataStore.put("apple", "mango");
		dataStore.put("US", "India");
		dataStore.put("Earth", "Sun");
	}

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Server is running at port: " + PORT);
		
		boolean isStopped = false;
		while(!isStopped){
		    Socket clientSocket = server.accept();
		    
		    connectionCount++; //increment Client Connection when new connection received 
		    System.out.println("\nNumber of client connection received # " + connectionCount);
		   
		    // delegate client socket to a new worker thread
		    WorkerThread workerThread = new WorkerThread(clientSocket, connectionCount);
		    workerThread.start();
		}
		
		System.out.println("Server is going to stop!!");
		server.close(); //close server socket
		System.out.println("Server stopped!");
	}
	
	/**
	 * Worker Thread spawned by Server for each client connection.
	 * 
	 * @author Prabhash Rathore
	 *
	 */
	static class WorkerThread extends Thread {
		private Socket socket;
		private int connectionID;
		
		public WorkerThread(Socket socket, int connectionID) {
			this.socket = socket;
			this.connectionID = connectionID;
		}
		
		@Override
		public void run() {
			BufferedReader bufferedReader = null;
			OutputStream outputStream = null;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.print("\nClient said:: ");
				String line = bufferedReader.readLine();
				while(line != null) {
					System.out.print(line);
					line = bufferedReader.readLine();
				}
				
				// Reply to client
				outputStream = socket.getOutputStream();
				String message = "Hello Client at Connection ID: " + connectionID;
				outputStream.write(message.getBytes());
				outputStream.flush();
			} catch(IOException ioException) {
				ioException.printStackTrace();
			} finally {
				System.out.println("\nGoing to close all streams and socket for clinet at connection: " + connectionID);
				
				try {
					bufferedReader.close();
					outputStream.close();
					socket.close();
				} catch(IOException ioException) {
					ioException.printStackTrace();
				} 
			}
		}
	}

}
