package com.prabhash.java.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A generic Stack class.
 * 
 * @author prrathore
 *
 */
public class Stack<E> {
	
	private final List<E> stack;
	private int topPos;
	
	public Stack() {
		stack = new ArrayList<E>();
		topPos = -1;
	}
	
	public void push(E obj) {
		stack.add(obj);
		topPos++;
	}
	
	public void pushAll(Collection<? extends E> src) {
		for(E e : src) {
			push(e);
		}
	}
	
	public E pop() throws NullPointerException {
		if(stack == null) {
			throw new NullPointerException();
		}
		
		E removedElement = stack.get(topPos);
		stack.remove(removedElement);
		topPos--;
		return removedElement;
	}
	
	public void popAll(Collection<? super E> dst) throws NullPointerException {
		
		if(dst == null) {
			throw new NullPointerException();
		}
		
		for(Object e : dst) {
			if(stack.contains(e)) {
				stack.remove(e);
				topPos--;
			}
		}
		
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
	
	public int size() {
		return topPos;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(E e : stack) {
			s.append(e + " : ");
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
