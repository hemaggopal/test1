package com.infosys.learning.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample implements Runnable {

	private int sleepTime;
	private CountDownLatch latch;
	
	public CountDownLatchSample(int sleepTime, CountDownLatch latch) {
		this.sleepTime = sleepTime;
		this.latch = latch;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();		
	}
}