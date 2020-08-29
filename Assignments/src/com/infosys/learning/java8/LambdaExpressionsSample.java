package com.infosys.learning.java8;

import java.util.function.Function;

public class LambdaExpressionsSample {

	public static void invokeRunnable() {
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
	}
	
	public static int square(int i) {
		return i*i;
	}
	
	public static void main(String[] args) {
		invokeRunnable();
		//Defining a square function with implementation unlike method references
		//Using built in Function<,> functional interface
		Function<Integer, Integer> func = (i) -> {return i*i;};
		System.out.println(func.apply(3));
		
		func = x->x*x; //No parenthesis, no return type for single line expression
		System.out.println(func.apply(3));
		
		//Defining a function which accepts an argument and returns a number
		//Passing this function to square function defined
		Foo foo = (x) -> { return x;};
		System.out.println(square(foo.method(3)));
	}
	
	interface Foo {
		int method(int i);
	}
}
