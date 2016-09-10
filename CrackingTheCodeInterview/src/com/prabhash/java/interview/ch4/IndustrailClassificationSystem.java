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
 * getClassificationPath(string) -> list(string) input company -> List<Path>
 *  "IBM" -> "Technology", "Service"
 *  
 * getCompanies(string) -> list(string)  * input sector - > companies
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
			return true;
		}
		
		// Make sure if children is null then do not iterate over children
		if(root.getChildren() == null) {
			return false;
		}
		
		for(Node node : root.getChildren()) {
			boolean result = getClassificationPathHelper(name, node, path);
			if(result) {
				path.add(node.name);
				return true;
			}
		}
		return false;
	}
	
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
		
		Node technology = new Node("Technology");
		list = new ArrayList<>();
		list.add(service);
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
		System.out.println("Org");
		
		return system;
	}

	public static void main(String[] args) {
		IndustrailClassificationSystem system = generateIndustrialSystem();
		List<String> companyPath = system.getClassificationPath("IBM");
		if(companyPath == null || companyPath.size() == 0) {
			System.out.println("Company not found");
		} else {
			System.out.println("Here is the path:");
			for(String path : companyPath) {
				System.out.print(path + " -> ");
			}
		}
	}
}
