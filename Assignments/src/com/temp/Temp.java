package com.temp;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer foo = new StringBuffer("I am foo");
		changeFoo(foo);
		System.out.println(foo.toString());// Output????
		StringBuilder foos = new StringBuilder("jjj");
		changeFoos(foos);
		System.out.println(foos.toString());
		String s = new String("sss");
		change(s);
		System.out.println(s);

	}

	public static void change(String foo) {
		foo = "ddd";
	}

	public static void changeFoos(StringBuilder foo) {
		foo.append("b4");
		foo = new StringBuilder("I am not foo");
		foo.append("a4");

	}

	public static void changeFoo(StringBuffer foo) {
		foo.append("b4");
		foo = new StringBuffer("I am not foo");
		foo.append("a4");

	}

}
