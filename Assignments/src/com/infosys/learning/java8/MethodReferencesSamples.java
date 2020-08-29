package com.infosys.learning.java8;

import java.util.function.Function;

public class MethodReferencesSamples {
	
	MethodReferencesSamples(String str) {
		super();
		System.out.println(str);
	}

	int function1() {
		return 1;
	}
	
	static int square(int i) {
		return i*i;
	}
	
	public static void main(String[] args) {
		MethodReferencesSamples lambdaSamples = new MethodReferencesSamples("MethodReferencesSamples constructor called W/O method ref");
		//STATIC FUNCTIONS
		//Inbuilt functional interface that takes an argument and returns result
		Function<Integer, Integer> fun = MethodReferencesSamples::square;
		System.out.println(fun.apply(3));
		//Custom functional interface that takes an argument and returns result
		Foo foo = MethodReferencesSamples::square;
		System.out.println(foo.method(3));
		
		//INSTANCE FUNCTIONS
		FooReturnType fooReturnType = lambdaSamples::function1;
		System.out.println(fooReturnType.method());
		
		//CONSTRUCTORS
		FooConstructor f = MethodReferencesSamples::new;
		f.method("MethodReferencesSamples constructor called using method ref");
	}
	
	interface Foo {
		int method(int k);
	}
	
	interface FooReturnType {
		int method();
	}
	
	interface FooConstructor {
		MethodReferencesSamples method(String str);
	}
}
