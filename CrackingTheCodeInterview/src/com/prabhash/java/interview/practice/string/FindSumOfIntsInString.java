package com.prabhash.java.interview.practice.string;

/**
 * Given a string with numeric digits embedded in in, find the sum of numeric digits. If numbers are preceded by "-" then consider
 * that number as negative.
 * 
 * For eg, t = df3h5nj12nk9f, sum = 29
 * 
 * @author Prabhash Rathore
 *
 */
public class FindSumOfIntsInString {
	
	public static int getSumOfIntegersInText(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		int sum = 0;
		boolean isNegative = false;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '-') {
				isNegative = true;
				continue;
			}
			
			StringBuffer sb = new StringBuffer();
			while(i < s.length() && Character.isDigit(c)) {
				sb.append(c);
				++i;
				c = s.charAt(i);
			}
			
			int num = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;
			
			if(isNegative) {
				num *= -1;
			}
			
			sum += num;
			
			isNegative = false;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		String s = "df3h5nj12nk9f";
		int sum = getSumOfIntegersInText(s);
		System.out.println("Sum of digits is: " + sum);
		
		String s2 = "xy15gh-8gdj20vb";
		int sum2 = getSumOfIntegersInText(s2);
		System.out.println("Sum of digits is: " + sum2);
	}

}
