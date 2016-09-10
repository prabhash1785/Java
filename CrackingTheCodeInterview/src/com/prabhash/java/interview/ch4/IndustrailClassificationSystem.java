package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a structure of Industry Classification System. Implement methods to query the organization for certain business functions 
 * based on given query strings.
 * 
 * For example: Industry Classification System
 * 
 * Healthcare
 * Finance
 *   Banking
 *   Insurance
 * Technology
 *   Service
 *     IBM
 *     MSFT
 *   Software
 *   Hardware
 *     Mobile
 *       NOKIA
 *     Laptops
 *       LENOVO
 *       
 * getClassificationPath(string) -> list(string)
 *  "IBM" -> "Technology", "Service"
 *  
 * getCompanies(string) -> list(string)
 *  "Hardware" -> "NOKIA", "LENOVO"
 * 
 * @author Prabhash Rathore
 *
 */
public class IndustrailClassificationSystem {
	
	private Node root;
	
	public IndustrailClassificationSystem() {
		this("IndustrailClassificationSystem");
	}
	
	public IndustrailClassificationSystem(String name) {
		root = new Node(name);
	}
	
	/**
	 * The whole industrial system is represented as an n-ary Tree. So starting from root of the tree, look for company name as per
	 * parameter. If a match is found, add all parent nodes to a list and return that list.
	 * 
	 * Time Complexity: O(n) where n is the size of tree
	 * 
	 * @param companyName
	 * @return path
	 */
	public List<String> getClassificationPath(String companyName) {
		if(companyName == null) {
			return null;
		}
		
		List<String> path = new ArrayList<>();
		boolean result = getClassificationPathHelper(companyName, root, path);
		if(!result) {
			return null;
		}
		
		Collections.reverse(path);
		return path;
	}
	
	private boolean getClassificationPathHelper(String name, Node root, List<String> path) {
		if(root == null) {
			return false;
		}
		
		if(root.name.equals(name)) {
			path.add(root.name);
			return true;
		}
		
		// Make sure if children is null then do not iterate over children
		if(root.getChildren() == null) {
			return false;
		}
		
		for(Node node : root.getChildren()) {
			boolean result = getClassificationPathHelper(name, node, path);
			if(result) {
				path.add(root.name);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Given an industry type, return all the company names which belongs to this industry.
	 * 
	 * This is implemented by recursively traversing the Industrial System tree. Once the right industry type is found, pass that node
	 * to another recursive function which will fetch all industries in that subtree. Industries are identified as the leaves of that
	 * sub-tree.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param industry
	 * @return companies
	 */
	public List<String> getCompanies(String industry) {
		if(industry == null) {
			return null;
		}
		
		List<String> companies = new ArrayList<>();
		boolean result = getCompaniesHelper(industry, root, companies);
		if(!result) {
			return null;
		}
		
		return companies;
	}
	
	private boolean getCompaniesHelper(String industry, Node root, List<String> companies) {
		if(root == null) {
			return false;
		}
		
		if(root.name.equals(industry)) {
			fetchCompaniesHelper(root, companies);
			return true;
		}
		
		if(root.getChildren() == null) {
			return false;
		}
		
		for(Node node : root.getChildren()) {
			boolean result = getCompaniesHelper(industry, node, companies);
			if(result) {
				return true;
			}
		}
		return false;
	}
	
	private void fetchCompaniesHelper(Node root, List<String> companies) {
		if(root == null) {
			return;
		}
		
		if(root.getChildren() == null) {
			companies.add(root.name);
			return;
		}
		
		for(Node node : root.getChildren()) {
			fetchCompaniesHelper(node, companies);
		}
	}
	
	/**
	 * Node to represent each unit or segment in industrial system. Each unit can have n children.
	 *
	 */
	public static class Node {
		private String name;
		private List<Node> children;
		
		public Node(String name) {
			this.name = name;
		}
		
		public List<Node> getChildren() {
			return this.children;
		}
		
		public void setChildren(List<Node> children) {
			this.children = children;
		}
	}
	
	private static IndustrailClassificationSystem generateIndustrialSystem() {
		IndustrailClassificationSystem system = new IndustrailClassificationSystem();
		Node root = system.root;
		
		Node service = new Node("Service");
		List<Node> list = new ArrayList<>();
		list.add(new Node("IBM"));
		list.add(new Node("MSFT"));
		service.setChildren(list);
		
		Node software = new Node("Software");
		
		Node mobile = new Node("Mobile");
		list = new ArrayList<>();
		list.add(new Node("NOKIA"));
		mobile.setChildren(list);
		
		Node laptop = new Node("Laptops");
		list = new ArrayList<>();
		list.add(new Node("LENOVO"));
		laptop.setChildren(list);
		
		Node hardware = new Node("Hardware");
		list = new ArrayList<>();
		list.add(mobile);
		list.add(laptop);
		hardware.setChildren(list);
		
		Node technology = new Node("Technology");
		list = new ArrayList<>();
		list.add(service);
		list.add(software);
		list.add(hardware);	
		technology.setChildren(list);
		
		list = new ArrayList<>();
		list.add(new Node("Banking"));
		list.add(new Node("Insurance"));
		
		Node finance = new Node("Finance");
		finance.setChildren(list);

		list = new ArrayList<>();
		list.add(new Node("Healthcare"));
		list.add(finance);
		list.add(technology);
		
		root.setChildren(list);
		
		return system;
	}
	
	public static void printList(List<String> list) {
		if(list == null || list.size() == 0) {
			System.out.println("\nEmpty list");
		} else {
			System.out.println("\nHere is the path:");
			for(String s : list) {
				System.out.print(s + " -> ");
			}
		}
	}

	public static void main(String[] args) {
		IndustrailClassificationSystem system = generateIndustrialSystem();
		List<String> companyPath = system.getClassificationPath("IBM");
		printList(companyPath);
		
		companyPath = system.getClassificationPath("LENOVO");
		printList(companyPath);
		
		List<String> companyNames = system.getCompanies("Hardware");
		printList(companyNames);
	}
}
