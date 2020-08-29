package com.infosys.learning.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Atomic classes has compareAndSet which updates the value only when the expected value matches.
 * @author hemalatha.gopal
 *
 */
public class AtomicSample {
	AtomicInteger atomic = new AtomicInteger(0);

	public AtomicSample() {
	}

	public AtomicSample(int value) {
		this.atomic = new AtomicInteger(value);
	}

	public void incrementAndGet() {
		while (true) {
			int value = getAtomicValue();
			if (atomic.compareAndSet(value, value + 10))
				return;
			// atomic.incrementAndGet();
			// printAtomicValue();
		}
	}

	public void printAtomicValue() {
		System.out.println(atomic.get());
	}

	public int getAtomicValue() {
		return atomic.get();
	}

	public static void main(String[] args) {
		AtomicSample atomicInstance = new AtomicSample(0);

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				atomicInstance.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + "-" + atomicInstance.getAtomicValue());
			}).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		/*
		 * new Thread(()->{ atomicInstance.incrementAndGet();
		 * System.out.println(Thread.currentThread().getName() + "-" +
		 * atomicInstance.getAtomicValue()); }).start();
		 */
	}
}