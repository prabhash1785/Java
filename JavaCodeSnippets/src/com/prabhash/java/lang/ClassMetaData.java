package com.prabhash.java.lang;

import com.prabhash.java.beans.Person;

/**
 * Using Java Class API, get the meta data about the class
 * 
 * @author prrathore
 *
 */
public class ClassMetaData {

	public static void main(String[] args) {
		
		Class<Person> personClass = Person.class;
		
		String name = personClass.getName();
		System.out.println("Name: " + name);
		
		String simpleName = personClass.getSimpleName();
		System.out.println("Simple Name: " + simpleName);
		
		char firstCharOfClass = simpleName.charAt(0);
		System.out.println("First char of Simple Class Name: " + firstCharOfClass);
		
	}

}
