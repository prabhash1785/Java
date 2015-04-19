package com.prabhash.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.prabhash.java.beans.Address;

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
 *  - If a composed class is not Serializable then runtime Serialization will throw NotSerializableException.
 *  - Composed object doesn't really need to have a SerialVersionUID for successful deserialization but adding a SerialVersionUID could
 *  can prevent any runtine InValid class exception while deserialization.
 *  - Superclass of composed object gets Serialized as well without it being declared Serializable explicityly. Superclass of composed Serializable
 *  class must have a No-Arg constructor.
 * 
 * @author prrathore
 *
 */
public class ObjectStreams implements Serializable {
	
	private static final long serialVersionUID = 30L;
	
	private String firstName;
	private String lastName;
	private int empNum;
	private transient String city; //do not serialize this so declared as transient
	
	//compose a object for Serialization
	private Address address = null;
	
	public ObjectStreams(String firstName, String lastName, int empNum, String city, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empNum = empNum;
		this.city = city;
		this.address = address;
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
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Write instance of class ObjectStreams to a file stream and then read it back from the file stream. 
	public static void main(String[] args) throws IOException {
		
		Address address = new Address();
		address.setAddressLine1("2020 Plaza St");
		address.setAddressLine2("Apt 345");
		address.setCity("SF");
		address.setState("CA");
		address.setZip(67845);
		address.setCountry("US");
		
		ObjectStreams obj = new ObjectStreams("Ricky", "Rathore", 100, "San Jose", address);
		
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
