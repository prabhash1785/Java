package com.prabhash.java.interview.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Determine if there is a route between two nodes in a Graph.
 * 
 * @author prrathore
 *
 */
public class Q4_2_DetermineRouteBetweenTwoNodes {
	
	private List<Vertex> vertices;
	
	public Q4_2_DetermineRouteBetweenTwoNodes() {
		vertices = new ArrayList<Vertex>();
	}
	
	/**
	 * Set up a sample Graph.
	 * 
	 */
	public void createGraph() {
		
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		
		// add these vertices to Graph
		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(d);
		vertices.add(e);
		vertices.add(f);
		
		a.addConnection(b);
		b.addConnection(e);
		c.addConnection(f);
		d.addConnection(b);
		d.addConnection(c);
		e.addConnection(d);
		f.addConnection(e);
		
	}
	
	/**
	 * Find if path exists between two vertex using BFS Algorithm.
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 * @throws Exception
	 */
	public boolean pathExists(Vertex v1, Vertex v2) throws Exception {
		
		if(v1 == null || v2 == null) {
			throw new Exception("At least of the vertices are null");
		}
		
		if(v1 == v2) {
			return true;
		}
		
		boolean isConnected = false;
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		List<Vertex> visited = new ArrayList<Vertex>();
		
		queue.add(v1);
		
		while(queue.peek() != null) {
			
			Vertex v = queue.poll();
			
			if(v == v2) {
				System.out.println("Path exists between " + v1.name + " and " + v2.name);
				return true;
			}
			
			visited.add(v);
			
			List<Vertex> neighbors = v.getConnection();
			
			for(Vertex ver : neighbors) {
				if(!visited.contains(ver)) {
					queue.add(ver);
					
				}
			}
			
			
		}
		
		System.out.println("Oops... no path exists between given vertices!!");
		return isConnected;
		
	}
	
	/**
	 * Class to represent vertex in Graph.
	 * 
	 * @author prrathore
	 *
	 */
	private static class Vertex {
		
		private String name;
		private List<Vertex> connections = new ArrayList<Vertex>();
		
		public Vertex(String name) {
			this.name = name;
		}
		
		public void addConnection(Vertex v) {
			this.connections.add(v);
		}
		
		public List<Vertex> getConnection() {
			return this.connections;
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		Q4_2_DetermineRouteBetweenTwoNodes graph = new Q4_2_DetermineRouteBetweenTwoNodes();
		graph.createGraph();
		
		List<Vertex> vertices = graph.vertices;
		
		Vertex a = vertices.get(5);
		Vertex f = vertices.get(0);
		
		boolean pathExists = graph.pathExists(a, f);
		System.out.println("Path exists? " + pathExists);

	}

}
