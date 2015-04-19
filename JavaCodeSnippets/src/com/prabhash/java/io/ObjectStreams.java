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
 * Serialization:
 *  - If a class to be serialized is not defined Serializable then this can't be serialized. While serializing, you will get 
 *  NotSerilizableException
 * 
 * @author prrathore
 *
 */
public class ObjectStreams implements Serializable {
	
	private static final long serialVersionUID = 20L;
	
	private String firstName;
	private String lastName;
	private int empNum;
	
	public ObjectStreams(String firstName, String lastName, int empNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empNum = empNum;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	// Write instance of class ObjectStreams to a file stream and then read it back from the file stream. 
	public static void main(String[] args) throws IOException {
		
		ObjectStreams obj = new ObjectStreams("Ricky", "Rathore", 100);
		
		//fileoutputstream to write to a file using byte stream
		FileOutputStream fileOutputStream = new FileOutputStream("./data/SerializedContent.temp");
		
		//create ObjectOutputStream to serialize an object
		ObjectOutputStream objStream = new ObjectOutputStream(fileOutputStream);
		
		//serialize the object
		objStream.writeObject(obj);
		
		objStream.close();
		fileOutputStream.close();
		
	}

}
