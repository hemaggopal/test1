package com.infosys.learning.threads.synchronization;

public class Counter {

	private int counter = 0;
	protected static int staticCounter = 0;

	/*
	 * Without synchronized keyword, counter instance variable is 
	 * shared across threads and leads to erroneous data 
	 */
	public synchronized void increment() {
		setCounter(getCounter() + 1);
		//counter++;
	}
	
	/*
	 * Without synchronized keyword, staticCounter static(one per class per JVM) 
	 * variable is shared across threads and leads to erroneous data 
	 */
	public static synchronized void staticIncrement() {
		//setStaticCounter(getStaticCounter()+1);
		staticCounter = staticCounter + 1;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return counter;
	}	

	public static int getStaticCounter() {
		return staticCounter;
	}

	public static void setStaticCounter(int staticCounter) {
		Counter.staticCounter = staticCounter;
	}
}