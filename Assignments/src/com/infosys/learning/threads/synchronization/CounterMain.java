package com.infosys.learning.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterMain {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=1; i<= 500; i++) {
			executor.submit(()-> {counter.increment();});			
		}
		executor.awaitTermination(1000,TimeUnit.MILLISECONDS);
		System.out.println(counter.getCounter());
		
		
		for(int i=1; i<=500; i++) {
			executor.submit(()-> {Counter.staticIncrement();});
		}
		executor.awaitTermination(1000,  TimeUnit.MILLISECONDS);
		System.out.println(Counter.staticCounter);
		
		executor.shutdown();
	}
}