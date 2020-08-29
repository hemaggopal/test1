package com.infosys.learning.efficientCodingSamples.greedyAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChange {

	static int coin_change(int amount, List<Integer> coins){
	    System.out.println("Amount to be given "+ amount);
	    int coin_chosen=0;
	    System.out.println(coins);
	    if(coins.indexOf(amount) >= 0){
	        return amount;
	    }
	    for(int i=0;i<coins.size();i++){
	        if(coins.get(i)<amount){
	            coin_chosen=coins.get(i);
	        }
	        else{
	            break;
	        }
	    }
	    System.out.println("Coin chosen " + coin_chosen);
	    int remaining_change=amount-coin_chosen;
	    System.out.println("Amount remaning " + remaining_change);
	    return coin_change(remaining_change,coins);
	}	
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,6};
		
		coin_change(8, Arrays.stream(arr).boxed().collect(Collectors.toList()));

	}
}
