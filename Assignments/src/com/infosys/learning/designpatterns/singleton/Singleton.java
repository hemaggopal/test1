package com.infosys.learning.designpatterns.singleton;

import java.io.Serializable;

/**
 * Eager initialization of INSTANCE is lazily loaded due to static nested class.
 * 
 * @author hemalatha.gopal
 *
 */
public class Singleton implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;

	private Singleton() {}
	
	private static class SingletonHelper {
		private final static Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() {
		return getInstance();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return getInstance();
	}
}