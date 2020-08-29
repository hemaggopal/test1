package com.infosys.learning.threads;

import java.util.Date;

public class Clock implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + " - " + new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
