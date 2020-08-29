package com.infosys.learning.efficientCodingSamples.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	static int recursiveFibonacci(int n) {
		if(n==0 || n==1)
			return 1;
		return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}	
	
	//Memoization - Top down
	static Map<Integer, Integer> memoMap = new HashMap<>();
	static int memoizationFibonacci(int n) {		
		if(n==0 || n==1)
			return 1;
		else {
			memoMap.put(0,1);
			memoMap.put(1,1);
		}
		return memoization(n);
	}
	
	static int memoization(int n) {		
		if(memoMap.containsKey(n)) {
			System.out.println("Retrieved from map for: " + n);
			return memoMap.get(n);
		} 
		int result = memoization(n-1) + memoization(n-2);
		memoMap.put(n, result);
		
		return result;
	}
	
	//Tabular - Bottom Up
	static int tabularFibonacci(int n) {
		if(n==0 || n==1)
			return 1;
		//If 5, we need array from 0 to 5, so n+1
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		//run till 5, so <=n
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			System.out.println(Arrays.toString(arr));
		}
		return arr[n];
	}
	
	public static void main(String[] args) {
		System.out.println(recursiveFibonacci(5));
		System.out.println(memoizationFibonacci(5));
		System.out.println(tabularFibonacci(5));
	}
}