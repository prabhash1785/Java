package com.prabhash.java.interview.ds;

/**
 * Implementation of StringBuffer Data Structure.
 * 
 * @author Prabhash Rathore
 *
 */
public class StringBuilderImpl {
	
	private char[] buffer;
	private int capacity;
	private int length;

	public StringBuilderImpl() {
		this(16);
	}

	public StringBuilderImpl(int n) {
		buffer = new char[n];
		capacity = n;
		length = 0;
	}

	public int getLength() {
		return this.length;
	}

	public void ensureSize(int newLength) {
		if(newLength < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int k = 2 * capacity;
		char[] dest = new char[k];
		
		//copy existing array to new array
		System.arraycopy(buffer, 0, dest, 0, length);
		
		buffer = dest; //point buffer to new array
		capacity = k; //update capacity
	}

	public StringBuilderImpl append(String s) {
		if(s == null) {
			return this;
		}
		int newLength = this.length + s.length();
		if(newLength > capacity) {
			ensureSize(newLength);
		}
		//copy the string to existing array of characters
		for(int i = 0; i < s.length(); i++, length++) {
			buffer[length] = s.charAt(i);
		}
		
		return this;
		
	}
	
	@Override
	public String toString() {
		return new String(buffer, 0, length);
	}
	
	public static void main(String[] args) {
		
		StringBuilderImpl sb = new StringBuilderImpl();
		sb.append("America is Awesome.").append(" India is awesome too.").append(" This is a great stringbuffer program.");
		
		System.out.println("StringBuffer: " + sb);
		System.out.println("Size: " + sb.length + " :::: Capacity: " + sb.capacity);
		
	}


}