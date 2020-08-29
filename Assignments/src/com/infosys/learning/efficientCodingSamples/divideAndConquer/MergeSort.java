package com.infosys.learning.efficientCodingSamples.divideAndConquer;

import java.util.Arrays;

public class MergeSort {

	static void mergeSort(int[] arr, int left, int right) {
		System.out.println(Arrays.toString(arr) + ", " + left + ","+right);
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		System.out.println(Arrays.toString(arr) + ",l: " + left + ","+ mid +", " + right);
		int n1 = mid-left+1;//Be careful with this index as it may lead to indexoutofbound exception
		int n2 = right-mid;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		for(int i=0; i<n1; i++) {
			leftArr[i] = arr[left+i];
		}
		for(int i=0; i<n2; i++) {
			rightArr[i] = arr[mid+1+i]; 
		}
		
		int k = left;
		int i = 0;
		int j = 0;

		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) { //Change lesser to greater to print in descending order
				arr[k] = leftArr[i];
				i++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = leftArr[i];
			i++;k++;
		}
		while(j < n2) {
			arr[k] = rightArr[j];
			j++;k++;
		}		
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 5,3,9,2,6};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}

/**
 * 
[7, 5, 3, 9, 2, 6], 0,5
[7, 5, 3, 9, 2, 6], 0,2
[7, 5, 3, 9, 2, 6], 0,1
[7, 5, 3, 9, 2, 6], 0,0
[7, 5, 3, 9, 2, 6], 1,1
[7, 5, 3, 9, 2, 6],l: 0,0, 1
[5, 7, 3, 9, 2, 6], 2,2
[5, 7, 3, 9, 2, 6],l: 0,1, 2
[3, 5, 7, 9, 2, 6], 3,5
[3, 5, 7, 9, 2, 6], 3,4
[3, 5, 7, 9, 2, 6], 3,3
[3, 5, 7, 9, 2, 6], 4,4
[3, 5, 7, 9, 2, 6],l: 3,3, 4
[3, 5, 7, 2, 9, 6], 5,5
[3, 5, 7, 2, 9, 6],l: 3,4, 5
[3, 5, 7, 2, 6, 9],l: 0,2, 5
[2, 3, 5, 6, 7, 9]

*/