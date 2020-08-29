package com.temp;

public class SuperClassTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClassTest st = new SuperClassTest();
		st.classTest();
		//SubClass ref1 = new SuperClass();

	}

	void classTest() {
		SuperClass ref = new SubClass();
		System.out.println(ref.word);// output 1 ?????
		ref.printWord();// output 2 ?????

	}

}
