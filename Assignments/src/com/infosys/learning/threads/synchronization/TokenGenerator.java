package com.infosys.learning.threads.synchronization;

public class TokenGenerator {

	private int token;
	protected static int staticToken;

	public void generateToken() {
		synchronized (this) {
			setToken(getToken() + 1);

		}
		// Other activities that do not use the shared instance variable need
		// not be synchronized. This is the advantage of synchronized block over method
		printReceipt();
	}

	public static void generateStaticToken() {
		synchronized (TokenGenerator.class) {
			staticToken = staticToken + 1;
		}
		// Other activities that do not use the static variable need
		// not be synchronized. This is the advantage of synchronized block over method
		doSomething();
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public void printReceipt() {
		// doSomething - print functionality
		//System.out.println("Receipt printed - " + Thread.currentThread().getName());
	}
	
	public static void doSomething() {
		// doSomething - print functionality
	}
}