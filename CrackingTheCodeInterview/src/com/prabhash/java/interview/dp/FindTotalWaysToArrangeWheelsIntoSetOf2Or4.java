package com.prabhash.java.interview.dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find all possible ways to arrange n wheels into 2-wheeler or 4-wheeler vehicles.
 * 
 * @author Prabhash Rathore
 *
 */
public class FindTotalWaysToArrangeWheelsIntoSetOf2Or4 {
	
	/**
	 * Using Dynamic Programming, find count of valid 2 wheel and 4 wheel combinations out of given n wheels.
	 * 
	 * @param wheels
	 * @return int[]
	 */
	public static int[] chooseFleets(int[] wheels) {
        Map<Integer, Integer> cache = new HashMap<>(); // cache to prevent redundant calculations
        int[] output = new int[wheels.length];
        
        for(int i = 0; i < wheels.length; i++) {
            Set<String> set = new HashSet<>(); // to store unique pattern of wheels
            chooseFleetsHelper(wheels[i], "", set, cache);
            output[i] = set.size();
        }
        
        return output;
    }

    private static void chooseFleetsHelper(int n, String s, Set<String> set, Map<Integer, Integer> cache) {
        if(n < 0 || n % 2 != 0) {
            return;
        }
        
        if(n == 0) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);
            System.out.println("String s => " + s);
            set.add(s);
            return;
        }
        
        if(cache.containsKey(n)) {
            return;
        }
        
        s += 2;
        n = n - 2;
        chooseFleetsHelper(n, s, set, cache);
        
        if(n < 4) {
        	return;
        }
        
        s += 4;
        n = n - 4;
        chooseFleetsHelper(n, s, set, cache);
       
        s = s.substring(0, s.length() - 1); // remove the last char from string
        cache.put(n, set.size());
    }

	public static void main(String[] args) throws IOException{
		int[] _wheels = new int[3];
		int[] values = new int[] {6, 3, 2};
		for(int i = 0; i < _wheels.length; i++) {
			_wheels[i] = values[i];
		}
        
        int[] res = chooseFleets(_wheels);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(_wheels[res_i] + " => " + res[res_i]);
        }
    }
}