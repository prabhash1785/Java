package com.prabhash.java.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadASCIIFile {

public static void main(String[] args) throws Exception {
	
		if(args.length < 1) {
			System.out.println("Can't run this program without a valid filename!!");
			return;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        
	        String everything = sb.toString();
	        
	        System.out.println("Values:::: " + everything);
	        
	    } finally {
	        br.close();
	    }

	}

}
