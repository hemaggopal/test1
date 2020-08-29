package com.infosys.learning.threads;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FutureSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Callable<Date> callable = () -> {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
			return new Date();
		};
				  
		Future<Date> future = executor.submit(callable);
		/*
		 * if(! future.isDone()) { future.cancel(true); }
		 */
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		 		
		/*try {
		 	List<Callable<Date>> callables = Arrays.asList(callable, callable);
			List<Future<Date>> futureLst = executor.invokeAll(callables);
			futureLst.forEach((future)-> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		executor.shutdown();
		
		
		ScheduledExecutorService schExecutor = Executors.newScheduledThreadPool(2);
		ScheduledFuture<Date> schFuture = schExecutor.schedule(callable, 2, TimeUnit.SECONDS);
		try {
			System.out.println(schFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		schExecutor.isShutdown();		
	}
}