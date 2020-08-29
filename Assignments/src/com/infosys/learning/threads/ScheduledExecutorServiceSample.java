package com.infosys.learning.threads;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceSample {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		System.out.println(new Date());
		
		/*
		 * Starts executing after 2 seconds. Each thread is triggered 
		 * for every 5 seconds difference, irrespective of the previous thread completion.
		 * 
		 * Fri Aug 21 18:01:00 PDT 2020 
		 * pool-1-thread-1 - Fri Aug 21 18:01:02 PDT 2020
		 * pool-1-thread-1 - Fri Aug 21 18:01:07 PDT 2020 
		 * pool-1-thread-1 - Fri Aug 21 18:01:12 PDT 2020 
		 */		
		// executor.scheduleAtFixedRate(new Clock(), 2, 5, TimeUnit.SECONDS);
		
		executor.scheduleWithFixedDelay(new Clock(), 2, 5, TimeUnit.SECONDS);
		/*
		 * Starts executing after 2 seconds. Subsequent threads are triggered 
		 * 5 seconds after the previous thread completion. Hence there is 6 seconds diff 
		 * below, 5 seconds + 1 second in Clock.
		 * 
		 * Fri Aug 21 18:01:53 PDT 2020 
		 * pool-1-thread-1 - Fri Aug 21 18:01:55 PDT 2020
		 * pool-1-thread-1 - Fri Aug 21 18:02:01 PDT 2020
		 * pool-1-thread-1 - Fri Aug 21 18:02:01 PDT 2020
		 */		
	}
}
