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
 * b**e => [abase, abate, ...]
 * 
 * @author Prabhash Rathore
 *
 */
public class WordSuggestionInSudoku {
	
	private static Node root = new Node(' ');

	/**
	 * Returns words from dictionary as a list.
	 * 
	 * @return l
	 */
	private static List<String> getWords() {
		List<String> l = new ArrayList<>();
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
		private boolean isEnd;

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

		Node[] child = node.children;
		for (int i = 0; i < child.length; i++) {
			if (child[i] != null) {
				s += child[i].data;

				if (child[i].isEnd) {
					System.out.println(s);
				}

				printAllWordsInTrieHelper(child[i], s);

				s = s.substring(0, s.length() - 1);
			}
		}
	}

//	public static List<String> getMatchingWords(String s) {
//		if (s == null || s.length() == 0) {
//			return null;
//		}
//
//		Node node = root;
//		Node[] child = node.children;
//
//		char[] ch = s.toCharArray();
//		for (int i = 0; i < ch.length; i++) {
//			if (ch[i] == '*') {
//				List<String> list = getMatchingWords(s.substring(i + 1));
//
//			}
//
//		}
//	}
	
	public static void main(String[] args) {
		List<String> list = getWords();

		for (String string : list) {
			addWordToTrie(string);
		}

		// print words from trie
		printAllWordsInTrie();
	}
}
