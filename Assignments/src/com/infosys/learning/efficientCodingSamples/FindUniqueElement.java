package com.infosys.learning.efficientCodingSamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class FindUniqueElement {
	public static void method1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		// map.entrySet().stream().filter(x -> x.getValue() == 1).forEach(System.out::println);
		Stream<Integer> i = map.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey());
		i.forEach(System.out::println);

		Optional<Integer> optional = map.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey())
				.findAny();
		System.out.println(optional.get());

	}

	public static void method2(int[] arr) {
		List<Integer> numList = Arrays.asList(1, 1, 5, 4, 3, 3, 5, 6, 7, 2, 7, 6, 2);
		Integer unique = numList.stream().reduce((x, y) -> {
			System.out.println(x + "," + y);
			return x ^ y;
		}).orElse(0);
		System.out.println(unique);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 5, 4, 3, 3, 5, 6, 7, 2, 7, 6, 2 };
		method1(arr);
		// method2(arr);

		/*
		 * Optional<Integer> opt =
		 * map.entrySet().stream().map(Map.Entry::getKey).findFirst();
		 * System.out.println(opt.get());
		 */
	}
}