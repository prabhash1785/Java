package com.prabhash.java.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunWindowsCommand {

	public void RunWinCommands() throws IOException, Exception {
		String[] cmd = {"cmd.exe","/c","dir"};  
		Process p = Runtime.getRuntime().exec(cmd);  
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
		String temp = "";  
		while ((temp = input.readLine()) != null)  
			System.out.println(temp);  
		input.close();
		System.out.println("Exit Value before process destruction: " + p.exitValue());
		System.out.println("Going to destroy the process..");
		p.destroy();
		System.out.println("Exit Value after process destruction: " + p.exitValue());		
	}
	
	public static void main(String[] args) {
		try {
			new RunWindowsCommand().RunWinCommands();
		} catch(IllegalStateException illegalStageException) {
			illegalStageException.printStackTrace();
		} catch(IOException i) {
			i.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}

}
