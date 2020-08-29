package com.infosys.learning.efficientCodingSamples;

import java.util.Arrays;

public class Quiz1 {
	static int calculate1(int x, int y) {
		if (x == 0)
			return y;
		else
			return calculate1(x - 1, x + y);
	}

	static void squareOddNumbers(int[] arr) {
		Arrays.stream(arr).filter(n -> n%2!=0).map(n->n*n).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		//5,2->4,7->3,11->2,14->1,16->0,17
		System.out.println(calculate1(5, 2)); 
		int[] arr = {3,4,5,2,6};
		squareOddNumbers(arr);
	}
}
