package com.infosys.learning.multithreading;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		System.out.println(new Date());
		new Thread(new CountDownLatchSample(1000, latch)).start();
		new Thread(new CountDownLatchSample(2000, latch)).start();
		new Thread(new CountDownLatchSample(3000, latch)).start();

		try {
			latch.await();
			System.out.println(new Date());
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * This executes after all the threads have completed its execution.
		 * Without, latch.await(), this executes even b4 threads have completed its execution.
		 */
		System.out.println("Main Thread");
	}
}