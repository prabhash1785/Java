package com.prabhash.java.interview.practice.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public static void tokenizeIntoTwoWords(String word, Set<String> dictionary) {
		
		if(word == null || dictionary == null)  {
			throw new NullPointerException("Either word or dictionary is null");
		}

		// if whole word contains in dictionary
		if(dictionary.contains(word)) {
			System.out.println(word);
		}

		StringBuilder sb = new StringBuilder();

		int first = 0;
		int last = 1;

		int counter = 0;

		while(last <= word.length()) {

			String s = word.substring(first, last);

			if(dictionary.contains(s)) {

				sb.append(s).append(" ");
				first = last;
				counter++;

			}

			last++;

		}
		
		if(counter == 2 && last ==  (sb.toString().trim().length())) {
			System.out.println(sb.toString());
		} else {
			System.out.println("Complete word did not match in dictionary");
		}

	}
	
	public static StringBuffer splitIntoTwoWordsRecursively(String word, Set<String> dictionary) {
		
		if(word == null || dictionary == null) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		
		int first = 0;
		int last = 1;
		
		while(last <= word.length()) {
			
			String s = word.substring(first, last);
			
			if(dictionary.contains(s)) {
				sb.append(s + " ");
				break;
			}
			
			last++;
				
		}
		
		if(last < word.length()) {
			StringBuffer tempsb = splitIntoTwoWordsRecursively(word.substring(last), dictionary);
			if(tempsb != null) {
				sb.append(tempsb);
			}
		}
		
		return sb;
		
	}


	public static void main(String[] args) {
		
		final Set<String> set = new HashSet<String>();
		set.add("hello");
		set.add("world");
		set.add("friday");
		set.add("fridays");
		set.add("paypal");
		
		String input1 = "worldfridays";
		
		// tokenizeIntoTwoWords(input1, set);
		
		StringBuffer sb = splitIntoTwoWordsRecursively(input1, set);
		System.out.println("Tokenized String -> " + sb.toString());
		
	}

}
