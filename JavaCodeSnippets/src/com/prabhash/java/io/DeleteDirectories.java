/*
 * @author Prabhash Rathore 
 * 
 */
package com.prabhash.java.io;

import java.io.File;

/** 
 * Program to delete directories and files within the directories if their time stamp is older than given 
 * time stamp.
 * Also delete empty directories.
 * 
*/

public class DeleteDirectories {

	private static String path = "C:\\var\\temp";
	
	/**
	 * This program lists all the files and directories present at a given path.
	 * This is a recursive algorithm to access the nested files and directories
	 * 
	 * @param file
	 */
	private static void listDirectories(File file) {
		
		if(file == null) {
			System.out.println("No such file/directory!!");
			return;
		}
		
		if(file.isDirectory()) {
			System.out.println("Directory: " + file.getName());
			
			File[] list = file.listFiles();
			
			//Check for Empty Directory
			if(list.length == 0) {
				System.out.println("Found an empty diretory, name of this dir is -> " + file.getName());
				//file.delete(); //Not deleting any files just to reduce the risk of deleting important files accidentally
			} else {			
				for(File f : list) {					
					listDirectories(f); //Recursive call to get the nested directories and files					
				}
			}
		} else {
			System.out.println("File: " + file.getName());
		}		
		
	}
	
	public static void main(String[] args) {
		
		listDirectories(new File(path));

	}

}
