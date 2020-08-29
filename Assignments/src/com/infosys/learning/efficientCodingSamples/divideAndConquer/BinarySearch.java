package com.infosys.learning.efficientCodingSamples.divideAndConquer;

public class BinarySearch {

	static int binarySearch(int[] arr, int searchEle) {
		int left = 0;
		int right = arr.length-1;
		while(left <= right) { //dont forget =
			int mid = (left+right)/2;
			if(arr[mid] == searchEle) {
				return mid;
			} else if(arr[mid] > searchEle) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,6,7,8};
		int searchEle = 7;
		int index = binarySearch(arr, searchEle);
		System.out.println(index + "," + ((index==-1)? false: true));
	}	
}