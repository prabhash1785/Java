package com.prabhash.java.mockito;

import java.util.ArrayList;
import java.util.List;

public class SimpleList {
	
	private final List<String> list;
	
	public SimpleList() {
		this(new ArrayList<>());
	}
	
	public SimpleList(final List<String> list) {
		this.list = list;
	}
	
	public void addName(String name) throws NullPointerException {
		
		if(list == null) {
			throw new NullPointerException();
		}
		
		list.add(name);
			
	}
	
	public boolean removeName(String name) {
		
		if(list == null) {
			throw new NullPointerException();
		}
		
		if(list.contains(name)) {
			list.remove(name);
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public String toString() {
		
		if(list == null) {
			throw new NullPointerException();
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(String name : list) {
			
			sb.append(name + " ");
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		
		SimpleList sl = new SimpleList();
		
		sl.addName("Robin");
		sl.addName("Joe");
		sl.addName("Brown");
		sl.addName("Russel");
		
		String s = sl.toString();
		System.out.println(s);
		
		sl.removeName("Brown");
		
		s = sl.toString();
		System.out.println(s);
		
	}

}
