package com.infosys.learning.multithreading;
/**
 * Each thread has its own copy of value. 
 * Here, value 10 is specific for each thread and all 4 threads increments to 11.
 * 
 * @author hemalatha.gopal
 *
 */
public class ThreadLocalSample implements Runnable {

	ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
		protected Integer initialValue() {
			return 10;
		}
	};
	
	public void run() {
		threadLocal.set(threadLocal.get()+1);
		System.out.println(Thread.currentThread().getName() + " - " + threadLocal.get());
	}
	
	public static void main(String[] args) {
		ThreadLocalSample threadLocalSample = new ThreadLocalSample();
		new Thread(threadLocalSample).start();
		new Thread(threadLocalSample).start();
		new Thread(threadLocalSample).start();
		new Thread(threadLocalSample).start();
	}
}
