package com.prabhash.java.interview.practice.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a dictionary of words and string with some wild card characters, find all possible words for these strings based on dictionary
 * match.
 * 
 * *a**d 
 * *b**e 
 * *c**f
 * 
 * For example, for below string, possible words could be:
 * *b**e => [abase, abate, ...]
 * 
 * @author Prabhash Rathore
 *
 */
public class WordSuggestionInSudoku {
	
	private static Node root = new Node(' '); // Root of Trie

	/**
	 * Returns words from dictionary as a list
	 * 
	 * @return l
	 */
	private static List<String> getWords() {
		List<String> l = new ArrayList<>();
		l.add("acghf");
		l.add("dcuxf");
		l.add("aarhus");
		l.add("aaron");
		l.add("ababa");
		l.add("aback");
		l.add("abaft");
		l.add("abandon");
		l.add("abandoned");
		l.add("abandoning");
		l.add("abandonment");
		l.add("abandons");
		l.add("abase");
		l.add("abased");
		l.add("abasement");
		l.add("abasements");
		l.add("abases");
		l.add("abash");
		l.add("abashed");
		l.add("abashes");
		l.add("abashing");
		l.add("abasing");
		l.add("abate");
		l.add("abated");
		l.add("abatement");
		l.add("abatements");
		l.add("abater");
		l.add("abates");
		l.add("abating");
		l.add("abba");
		l.add("babbled");
		l.add("babbles");
		l.add("babbling");
		l.add("babcock");
		l.add("babe");
		l.add("babel");
		l.add("babelize");
		l.add("babelizes");
		l.add("babes");
		l.add("babied");
		l.add("babies");
		l.add("babka");
		l.add("baboon");
		l.add("fluffiest");
		l.add("gashes");
		l.add("grounder");
		l.add("hickman");
		l.add("impersonate");
		l.add("instrumentally");
		l.add("journalize");
		l.add("legacy");
		l.add("madness");
		l.add("merle");
		l.add("mottoes");
		l.add("notarize");
		l.add("overhears");
		l.add("perfectness");
		l.add("polluted");
		l.add("promoter");
		return l;
	}
	
	
	static class Node {
		private char data;
		private Node[] children;
		private boolean isEnd; // end of any complete word in Trie, this is different than leaf of Trie

		public Node(char data) {
			this.data = data;
			children = new Node[26]; // assuming we deal with only lower case chars
			isEnd = false;
		}

		@Override
		public String toString() {
			return data + " :: " + isEnd;
		}
	}

	/**
	 * Add given string to Trie Data Structure.
	 * 
	 * @param s
	 */
	public static void addWordToTrie(String s) {
		if (s == null || s.length() == 0) {
			return;
		}

		Node node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Node[] children = node.children;
			int index = (int) c - 'a';
			if (children[index] == null) {
				children[index] = new Node(c);
			}

			node = children[index];
		}

		node.isEnd = true;
	}

	public static void printAllWordsInTrie() {
		if (root == null) {
			System.out.println("Trie is empty");
			return;
		}

		Node node = root;
		printAllWordsInTrieHelper(node, "");
	}

	private static void printAllWordsInTrieHelper(Node node, String s) {
		if (node == null) {
			return;
		}

		Node[] children = node.children;
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				s += children[i].data;

				if (children[i].isEnd) {
					System.out.println(s);
				}

				printAllWordsInTrieHelper(children[i], s);

				s = s.substring(0, s.length() - 1);
			}
		}
	}

	/**
	 * Find all possible matching words which could be formed from given string with wild card chars.
	 * 
	 * For eg,
	 * *b**e => [abase, abate, ...]
	 * 
	 * @param s
	 * @return result
	 */
	public static List<String> getMatchingWords(String s) {
		if (s == null || s.length() == 0) {
			System.out.println("Input is null, can't find any matching possible strings");
			return null;
		}
		
		Node node = root;
		List<String> result = new ArrayList<>();
		getMatchingWordsHelper(s, node, "", result);
		
		return result;
	}
	
	private static void getMatchingWordsHelper(String s, Node node, String newString, List<String> list) {
		if(s == null) {
			return;
		}
		
		if(node == null) {
			return;
		}
		
		if(s.length() == 0 && node.isEnd) {
			list.add(newString);
			return;
		}
		
		Node[] children = node.children;
		char c = s.charAt(0);
		int index = (int) c - 'a';
		
		if(c == '*') {
				for(int i = 0; i < children.length; i++) {
					if(children[i] != null) {
						newString += children[i].data;
						getMatchingWordsHelper(s.substring(1), children[i], newString, list);
						newString = newString.substring(0, newString.length() - 1); // remove the last char from previous recursive call
					}
				}
		} else {
			newString += c;
			node = children[index];
			getMatchingWordsHelper(s.substring(1), node, newString, list);
		}
	}
	
	public static void main(String[] args) {
		List<String> list = getWords();

		for (String string : list) {
			addWordToTrie(string);
		}

		// print words from trie
		printAllWordsInTrie();
		
		// Get possible matching words for given words with wild cards
		String input = "*b**e";
		List<String> listOfMatchingWords = getMatchingWords(input);
		System.out.println("\nHere are matching words for " + input + ":");
		for(String s : listOfMatchingWords) {
			System.out.println(s);
		}
		
		String input2 = "*c**f";
		List<String> listOfMatchingWords2 = getMatchingWords(input2);
		System.out.println("\nHere are matching words for " + input2 + ":");
		for(String s : listOfMatchingWords2) {
			System.out.println(s);
		}
	}
}
