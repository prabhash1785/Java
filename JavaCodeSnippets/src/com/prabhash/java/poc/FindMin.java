package com.prabhash.java.poc;

//find the smallest number in a given array

public class FindMin {
	
	private static final int[] list = {29, 51, 100, 34, 12, 7, 13, 6, 65};

	public static int findMin(int[] a) throws Exception {
		if(a == null)
			throw new Exception("Null Array");

		if(a.length == 0) {
			throw new Exception("Can't find min from an empty array");
		}

		int min = a[0];
		for(int i = 1; i < a.length; i++) {
			if(min > a[i]) {
				min = a[i];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		try {
			int min = findMin(list);
			System.out.println("Here is min: " + min);
		} catch(Exception e) {
			System.out.println("Some exception occurred: " + e);
		}
		
	}

}
