package com.prabhash.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Deserialization of an object using ObjectInputStream class.
 * 
 * Issues faced while deserialization:
 * 	- Without having a serialVersionUID in class of serialized object, I couldn' deserialize the object. The exception thrown was InvalidClassException.
 *    After adding SerialVersionUID, I was able to deserialize the object.
 * 
 * @author prrathore
 *
 */
public class Deserialization {

	public static void main(String[] args) throws IOException {
		
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		
		try {
			
			fileInputStream = new FileInputStream("./data/SerializedContent.temp");
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			ObjectStreams obj = (ObjectStreams)objectInputStream.readObject(); //this deserialized object is a new object with same fields and values as original object
			
			System.out.println("First Name: " + obj.getFirstName());
			System.out.println("Last Name: " + obj.getLastName());
			System.out.println("Emp Num: " + obj.getEmpNum());
			
		} catch(IOException io) {
			io.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fileInputStream != null) {
				fileInputStream.close();
			}
			if(objectInputStream != null) {
				objectInputStream.close();
			}
		}

	}

}
