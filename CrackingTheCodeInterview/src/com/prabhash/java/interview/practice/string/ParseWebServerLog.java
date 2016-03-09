package com.prabhash.java.interview.practice.string;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a large file with Web Server logs. Parse the file to extract IP Address and their corresponding page names. One IP
 * may have more than one web page names.
 * 
 * Example of Web Server Log:
 * 	12.45.123.345 http://1.1	foobar?a=5
 * 	123.456.12.10 http://1.2 apple
 * 
 * @author prrathore
 *
 */
public class ParseWebServerLog {
	
	/**
	 * Parse the given Web Server log file.
	 * 
	 * @param fileName
	 * @return Map<String, List<String>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Map<String, List<String>> parse(String fileName) throws FileNotFoundException, IOException {
		
		if(fileName == null) {
			throw new NullPointerException("File name is null");
		}
		
		InputStream inputStream = ParseWebServerLog.class.getClassLoader().getResourceAsStream(fileName);
		
		if(inputStream == null) {
			throw new NullPointerException(fileName + " is not a valid resource");
		}
	
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line;

		try {
			while((line = bufferedReader.readLine()) != null) {
				parseSingleLine(line, map);
			}
		} finally {
			bufferedReader.close();
		}
	
		return map;
	}
	
	public static void parseSingleLine(String line, Map<String, List<String>> map) {
		
		if(line == null || map == null) {
			throw new NullPointerException();
		}
		
		if(line == "" || line.length() == 0) {
			return;
		}
		
		String trimmedLine = line.trim();
		String multipleWhiteSpaceDelimiter = "\\s+"; // Regex to represent one of more white spaces like tab, etc.
		String stringWithOneWhiteSpace = trimmedLine.replaceAll(multipleWhiteSpaceDelimiter, " ");
		
		String[] tokens = stringWithOneWhiteSpace.split(" ");
		
		if(tokens.length < 3) {
			System.out.println("Invalid Web Server log line");
			return;
		} else {
			
			String ipAddress = tokens[0];
			
			if(!validateIPAddress(ipAddress)) {
				return;
			}
			
			String webURL = tokens[2];
			String[] parsedWebURL = webURL.split("\\?"); // tokenize the base web page and query parameters
			String webPageName = parsedWebURL[0];
			
			if(map.containsKey(ipAddress)) {
				List<String> exisitngPageList = map.get(ipAddress);
				exisitngPageList.add(webPageName);
				map.put(ipAddress, exisitngPageList);
			} else {
				List<String> webPageList = new ArrayList<String>();
				webPageList.add(webPageName);
				map.put(ipAddress, webPageList);
			}
		}	
	}
	
	/**
	 * Validate an IPV4 address.
	 * 
	 * @param ip
	 * @return boolean
	 */
	public static boolean validateIPAddress(String ip) {
		
		if(ip == null) {
			throw new NullPointerException("IP string is null");
		}
		
		if(ip.length() == 0) {
			return false;
		}
		
		// Regex to match an IPV4 Address
		String ipRegEx = "[1-9][0-9][0-9]?.[1-9][0-9][0-9]?.[1-9][0-9][0-9]?.[1-9][0-9][0-9]?";
		
		Pattern pattern = Pattern.compile(ipRegEx);
		Matcher matcher = pattern.matcher(ip);
		
		return matcher.matches();
	}
	
	/**
	 * Helper function to pretyy print parsed Web Server Logs.
	 * 
	 * @param map
	 */
	public static void prettyPrintWebLog(Map<String, List<String>> map) {
		
		if(map == null) {
			System.out.println("WebServer log must be empty!!");
			return;
		}
		
		Set<String> keySet = map.keySet();
		
		for(String key : keySet) {
			
			List<String> webPages = map.get(key) ;
			
			System.out.print(key + " ==> ");
			for(String page : webPages) {
				System.out.print(page + " ");
			}
			
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "WebServerLog.txt";
		Map<String, List<String>> parsedLogData = parse(fileName);
		
		prettyPrintWebLog(parsedLogData);
		
	}
}
