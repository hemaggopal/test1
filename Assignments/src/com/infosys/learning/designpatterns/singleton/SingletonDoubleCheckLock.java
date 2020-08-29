package com.infosys.learning.designpatterns.singleton;

public class SingletonDoubleCheckLock {

	private static SingletonDoubleCheckLock instance;
	
	//https://stackoverflow.com/questions/11639746/what-is-the-point-of-making-the-singleton-instance-volatile-while-using-double-l
	//http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
	//private volatile static SingletonDoubleCheckLock instance;

	private SingletonDoubleCheckLock () {}

	public static SingletonDoubleCheckLock getInstance() {
		if(instance == null) {
			synchronized(SingletonDoubleCheckLock.class) {
				if(instance == null) 
					instance = new SingletonDoubleCheckLock();
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		int hashCode1 = SingletonDoubleCheckLock.getInstance().hashCode();
		int hashCode2 = SingletonDoubleCheckLock.getInstance().hashCode();
		if(hashCode1 == hashCode2) {
			System.out.println("Instances are same");
		}
	}
}