package com.infosys.learning.efficientCodingSamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalProgramming {

	static void perform(int x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		Function<Integer, Integer> func = x -> x; // No parenthesis, no return type for single line expression
		perform(func.apply(5));

		Foo foo = x -> x;
		perform(foo.function(5));

		List<Integer> list = Arrays.asList(1, 3, 6, 7, 9);

		List<Integer> modList = list.stream().map(x -> x * x).filter(x -> x < 30).collect(Collectors.toList());
		modList.forEach(System.out::println);

		/* - From LEx */
		List<Integer> numList = Arrays.asList(10, 20, 30, 40, 50);

		System.out.println("===For Each===");
		numList.stream().forEach(num -> System.out.println(num));

		System.out.println("===For Each Alternative===");
		// numList.stream().forEach(num->System.out::println(num));
		System.out.println("==Map===");
		List<Integer> newList = numList.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(newList);
		System.out.println("==Filter===");
		List<Integer> filteredList = numList.stream().filter(n -> n > 30).collect(Collectors.toList());
		System.out.println(filteredList);
		System.out.println("==Chaining===");
		List<Integer> chainedList = numList.stream().map(n -> n * 2).filter(n -> n > 30).collect(Collectors.toList());
		System.out.println(chainedList);
	}

	interface Foo {
		int function(int x);
	}
}
