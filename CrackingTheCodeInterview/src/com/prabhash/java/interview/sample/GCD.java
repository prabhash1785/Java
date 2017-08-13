package com.prabhash.java.interview.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Find GCD of two given numbers.
 * 
 * @author Prabhash Rathore
 *
 */
public class GCD {
	
	/**
	 * Find GCD of two numbers.
	 * 
	 * Time Complexity: O(x | y)
	 * 
	 * @param x
	 * @param y
	 * @return gcd
	 */
	public static int findGCD(int x, int y) {
		int gcd = 1;
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		list1 = getDivisors(x);
		list2 = getDivisors(y);
		
		int i = list1.size() - 1, j = list2.size() - 1;
		while(i >= 0 && j >= 0) {
			int m = list1.get(i);
			int n = list2.get(j);
			
			if(m == n) {
				gcd = m;
				break;
			} else if(m > n) {
				--i;
			} else {
				--j;
			}
		}
		
		return gcd;
	}
	
	private static List<Integer> getDivisors(int x) {
		List<Integer> list = new ArrayList<>();
		if(x <= 1) {
			return list;
		}
		
		for(int i = 2; i <= x / 2; i++) {
			if(x % i == 0) {
				list.add(i);
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		int a = 6, b = 18;
		System.out.println("GCD of " + a + " and " + b + ": " + findGCD(a, b));
	}
}
