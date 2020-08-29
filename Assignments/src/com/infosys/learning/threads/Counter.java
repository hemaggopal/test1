package com.infosys.learning.threads;

public class Counter implements Runnable {

	private int counter;
	
	public Counter(int counter) {
		this.counter = counter;
	}
	
	public synchronized void increment(int value) {
		counter+=value;
	}
	/*
	 * public void decrement(int value) { counter-=value; }
	 */
	
	public int getCounter() {
		return counter;
	}
	
	@Override
	public void run() {
		increment(10);
		System.out.println(Thread.currentThread().getName() + "-inc-" + getCounter());
		/*
		 * decrement(5); System.out.println(Thread.currentThread().getName() + "-dec-" +
		 * getCounter());
		 */
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter(10);
		for(int i=0; i < 3; i++) {
			new Thread(counter).start();
		}
	}

}
