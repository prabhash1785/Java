package com.prabhash.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ObjectInputStream and ObjectOutputStream classes are used to read and write Java objects to input and output streams respectively.
 * 
 * ObjectOutputStream and ObjectInputStream can provide an application with persistent storage for graphs of objects when used with 
 * a FileOutputStream and FileInputStream respectively. ObjectInputStream is used to recover those objects previously serialized. 
 * Other uses include passing objects between hosts using a socket stream or for marshaling and unmarshaling arguments and parameters 
 * in a remote communication system.
 * 
 * @author prrathore
 *
 */
public class ObjectStreams implements Serializable {
	
	private String firstName;
	private String lastName;
	private int empNum;
	
	public ObjectStreams(String firstName, String lastName, int empNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empNum = empNum;
	}
	
	// Write instance of class ObjectStreams to a file stream and then read it back from the file stream. 
	public static void main(String[] args) throws IOException {
		
		ObjectStreams obj = new ObjectStreams("Ricky", "Rathore", 100);
		
		FileOutputStream fileOutputStream = new FileOutputStream("./data/SerializedContent.temp");
		
		ObjectOutputStream objStream = new ObjectOutputStream(fileOutputStream);
		
		objStream.writeObject(obj);
		
		objStream.close();
		fileOutputStream.close();
		
		

	}

}
