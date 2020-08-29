package com.infosys.learning.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSamples {

	public static int findNthLargestInArray(int[] arr, int n) {
		int[] tempArr = Arrays.stream(arr).sorted().distinct().limit(n).toArray();
		return tempArr[n - 1];
	}

	public static int findNthLargestInList(List<Integer> lst, int n) {
		List<Integer> tempLst = lst.stream().sorted().distinct().limit(n).collect(Collectors.toList());
		return tempLst.get(n - 1);
	}

	public static void performLazyIntermediateOps(int[] arr) {
		IntStream stream = Arrays.stream(arr).filter((x) -> {
			intermediateOperation(x);
			return x % 2 == 0;
		});

		// Following terminal operations should be invoked for the
		// intermediate operation to execute
		System.out.println("Even Numbers count: " + stream.count());
		// stream.forEach(System.out::println);
	}

	/*
	 * This function is invoked only when terminal ops are invoked
	 */
	public static void intermediateOperation(int x) {
		System.out.println("Intermediate function is called: " + x);
	}

	public static void mapExamples() {
		Stream<String> stream = Stream.of("AName", "bName", "cName", "DName");
		stream.map(x -> x.toUpperCase()).forEach(System.out::println);
	}

	public static void filterExamples() {
		Stream<String> stream = Stream.of("AName", "bName", "cName", "DName");
		long count = stream.filter(x -> {
			return Character.isUpperCase(x.charAt(1));
		}).count();
		System.out.println("count: " + count);
	}

	public static void intArrayToIntegerArray() {
		// int[] -> IntStream -> Stream<Integer> -> Integer[]
		int[] num = { 3, 4, 5 };

		// 1. int[] -> IntStream
		IntStream stream = Arrays.stream(num);

		// 2. IntStream -> Stream<Integer>
		Stream<Integer> boxed = stream.boxed();

		// 3. Stream<Integer> -> Integer[]
		Integer[] result = boxed.toArray(Integer[]::new);

		System.out.println(Arrays.toString(result));
	}

	public static void mapInStream() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");

		// Map -> Stream -> Filter -> String
		String result = map.entrySet().stream().filter(x -> "something".equals(x.getValue())).map(x -> x.getValue())
				.collect(Collectors.joining());

		// Map -> Stream -> Filter -> MAP
		Map<Integer, String> collect1 = map.entrySet().stream().filter(x -> x.getKey() == 2)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

		// or like this
		Map<Integer, String> collect2 = map.entrySet().stream().filter(x -> x.getKey() == 3)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Filtering
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		// Before Java 8
		String result1 = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}
		System.out.println("Before Java 8 : " + result1);

		// Map -> Stream -> Filter -> String
		result = HOSTING.entrySet().stream().filter(map1 -> "aws.amazon.com".equals(map1.getValue()))
				.map(map1 -> map1.getValue()).collect(Collectors.joining());

		System.out.println("With Java 8 : " + result);

		// filter more values
		result = HOSTING.entrySet().stream().filter(x -> {
			if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
				return true;
			}
			return false;
		}).map(map1 -> map1.getValue()).collect(Collectors.joining(","));

		System.out.println("With Java 8 : " + result);

	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 4, 3, 7, 8, 4 };
		int n = 3;
		System.out.println("Nth Largest in array: " + findNthLargestInArray(arr, n));

		List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("Nth Largest in list: " + findNthLargestInList(lst, n));

		System.out.println("Filter Operations");
		filterExamples();

		System.out.println("Map Operations");
		mapExamples();

		System.out.println("Lazy Operations");
		performLazyIntermediateOps(arr);
	}
}