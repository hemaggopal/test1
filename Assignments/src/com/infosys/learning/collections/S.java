package com.infosys.learning.collections;

import java.util.Arrays;
import java.util.List;

public class S {

	public static void main(String[] args) {

		List<String> lst = Arrays.asList("a", "b");/*new ArrayList<String>() {{ 
            add("a"); 
            add("b"); 
            } }; */
		/*
		 * lst.remove("a"); lst.remove("a");
		 */
		
		System.out.println(lst);
		lst.remove(1);
	}		
}
