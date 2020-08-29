package com.infosys.learning.collections;

import java.util.Arrays;

public class ArrayListDS<T> {

	private static final int DEFAULT_CAPACITY = 2;
	private T[] array;
	private int size;
	
	ArrayListDS() {
		array = (T[])new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	/**
	 * When size is greater than or equal to array length, 
	 * increase the size of array by 50%
	 * @param element
	 */
	public boolean add(T element) {
		//System.out.println(size + ", " + array.length);
		if(size >= array.length) {
			increaseCapacity();
		}
		array[size++] = element;	
		return true;
	} 
	
	/**
	 * Decrease the size otherwise the array will result like [10, 20, 40, 50, null, 60]
	 * instead of [10, 20, 40, 50, 60, null] 
	 * @param index
	 */
	public void remove(int index) {
		int lengthToBeCopied = array.length-index-1;
		System.arraycopy(array, index+1, array, index, lengthToBeCopied); 
		size--;
	}
	
	/**
	 * Increases size by 50%
	 */
	public void increaseCapacity() {
		int newSize = size + (size >> 1);
		array = Arrays.copyOf(array, newSize);
	}
	
	public int indexOf(Object obj) {
		for(int i=0; i< size; i++) {
			if(array[i].equals(obj))
				return i;
		}
		return -1;
	}
	
	public boolean contains(Object t) {
		return indexOf(t) != -1;
	}
	
	public String toString() {
		return Arrays.toString(array);
	}
	 
	public static void main(String[] args) {
		ArrayListDS<Integer> intLst = new ArrayListDS<>();
		intLst.add(10);
		intLst.add(20);
		intLst.add(30);
		intLst.add(40);
		intLst.add(50);
		System.out.println(intLst);
		intLst.remove(2);
		System.out.println(intLst);
		intLst.add(60);
		System.out.println(intLst);
		
		System.out.println(intLst.contains(10));
		System.out.println(intLst.contains(3));
		
		ArrayListDS<String> strLst = new ArrayListDS<>();
		strLst.add("A");
		strLst.add("B");
		strLst.add("C");
		strLst.add("D");
		strLst.add("E");
		System.out.println(strLst);
	}
}