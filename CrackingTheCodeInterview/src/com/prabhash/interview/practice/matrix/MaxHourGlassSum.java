package com.prabhash.interview.practice.matrix;

public class MaxHourGlassSum {

    public static int findMaxHourGlassSum(final int[][] a) {
        
        if(a == null) {
            throw new NullPointerException();
        }
        
        if(a.length > 6 || a[0].length > 6) {
            throw new IllegalArgumentException("Invalid Matrix indices");
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < a.length - 2; i++) {	
        	
        	for(int j = 0; j < a[0].length - 2; j++) {
        		
        		int tempGlassSum = 0;
        		tempGlassSum += a[i][j] + a[i][j + 1] + a[i][j + 2];
        		tempGlassSum += a[i + 1][j + 1];
        		tempGlassSum += a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];
        		
        		if(tempGlassSum > maxSum) {
        			maxSum = tempGlassSum;
        		}
        	}
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {

    	int[][] arr = new int[][] {
    			{1, 1, 1, 0, 0, 0},
    			{0, 1, 0, 0, 0, 0},
    			{1, 1, 1, 0, 0, 0},
    			{0, 0, 2, 4, 4, 0},
    			{0, 0, 0, 2, 0, 0},
    			{0, 0, 1, 2, 4, 0}
    	};
        
        int maxSum = findMaxHourGlassSum(arr);
        System.out.println("Max HourGlass Sum is: " + maxSum);
    }
}

