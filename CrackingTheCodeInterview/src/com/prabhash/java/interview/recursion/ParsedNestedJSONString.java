package com.prabhash.java.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a nested JSON string as follows, parse this string and return a nested JSON object.
 * 
 * @author Prabhash Rathore
 *
 */
public class ParsedNestedJSONString {
	
	/**
	 * Each JSON string could be a collection of elementary/primitive data or an n-level nested substring. So for each string,
	 * parse it and retrieve the list of primitives and list of substrings. For each primitive, create a node and add as a children to
	 * the root. For each substring, recurse and add the returned node as a child to the parent root. 
	 * 
	 * @param s
	 * @return
	 */
	public static Node parseJSONString(String s) {
		if(s == null) {
			return null;
		}
		
		if(s.length() == 0) {
			return null;
		}
		
		Node root = new Node(0); // this is the root
		Members members = parseSubString(s);
		List<Integer> primites = members.primitives;
		
		List<Node> children = new ArrayList<>();
		for(Integer i : primites) {
			children.add(new Node(i));
		}
		
		for(String substing : members.subStrings) {
			children.add(parseJSONString(substing));
		}
		
		root.children = children;
		return root;
	}
	
	/**
	 * Parse a string based on open and close brace pattern. Ignore the first and last index as they will be just open and close brace.
	 * During string iteration, if you encounter an open brace then it must be a sub string so keep track of open brace count and keep
	 * iterating until you find the end of this substring. Add this substring to members object.
	 * 
	 * @param s
	 * @return members
	 */
	public static Members parseSubString(String s) {
		if(s.length() == 0) {
			return null;
		}
		
		Members members = new Members();
		List<String> stringMembers = new ArrayList<>();
		List<Integer> intMembers = new ArrayList<>();
		int braceCount = 0;
		for(int i = 1; i < s.length() - 1; i++) { // just ignore first and last braces whic are open and close braces
			char c = s.charAt(i);
			if(c == ',' || c == ' ') {
				continue;
			}
			
			if(c == '[') {
				++braceCount;
				int start = i;
				++i;
				
				while(i < s.length() - 1 && braceCount > 0) {
					if(c == ',' || c == ' ') {
						++i;
						continue;
					}
					
					if(s.charAt(i) == '[') {
						++braceCount;
					} else if(s.charAt(i) == ']') {
						--braceCount;
					}
					
					++i;
					
					if(braceCount == 0) {
						stringMembers.add(s.substring(start, i));
					}
				}
			} else {
				intMembers.add(Character.getNumericValue(c));
			}
		}
			
		members.subStrings = stringMembers;
		members.primitives = intMembers;
		return members;
	}
	
	public static class Members {
		private List<Integer> primitives;
		private List<String> subStrings;
	}
	
	public static class Node {
		private int data;
		private List<Node> children;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printJSONString(Node root) {
		if(root == null || root.children == null) {
			return;
		}
		
		for(Node child : root.children) {
			System.out.print(child.data + " ");
			printJSONString(child);
		}
	}

	public static void main(String[] args) {
		final String jsonString = "[4, 6, [9, 2, [1, 1], 8], 4, [4, 7], 8, 1, [5, 3, 9], 1]";
		Node root = parseJSONString(jsonString);
		printJSONString(root);
	}

}
