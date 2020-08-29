package com.infosys.learning.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {

	public static void main(String[] args) {
		
		ExecutorService executor = null;
		
		//Two threads will run 4 instances of clock 
		//executor = Executors.newFixedThreadPool(2);
		
		//Four threads will run 4 instances of clock
		//executor = Executors.newCachedThreadPool();
		
		//Single thread will run 4 instances of clock
		executor = Executors.newSingleThreadExecutor();
		
		executor.execute(new Clock());
		executor.execute(new Clock());
		executor.execute(new Clock());
		executor.execute(new Clock());
		
		executor.shutdown();
	}
}
