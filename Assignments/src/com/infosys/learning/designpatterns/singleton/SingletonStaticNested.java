package com.infosys.learning.designpatterns.singleton;

import java.io.*;

/**
 * Eager initialization is followed in nested class which makes it thread safe. 
 * But, nested class will not be loaded until getInstance method is called and so it is lazily loaded. 
 */
public class SingletonStaticNested implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;

	private SingletonStaticNested() {}
	
	private static class SingletonStaticHelper {
		private static final SingletonStaticNested INSTANCE = new SingletonStaticNested();
	}
	
	public static SingletonStaticNested getInstance() {
		return SingletonStaticHelper.INSTANCE;
	}
	
	protected Object readResolve() {
		return getInstance();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return getInstance();
	}
	
	public static void main(String[] args) {
		SingletonStaticNested instance1 = SingletonStaticNested.getInstance();
		SingletonStaticNested instance2 = SingletonStaticNested.getInstance();
		
		int hashCode1 = instance1.hashCode();
		int hashCode2 = instance2.hashCode();
		if(hashCode1 == hashCode2) {
			System.out.println("Instances are same");
		}
		
		//Serializable Testing
		try {
			/*File directory = new File("./");
			System.out.println(directory.getAbsolutePath());*/
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("./singleton.txt")));
			objectOutputStream.writeObject(instance1);
			
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("./singleton.txt")));
			SingletonStaticNested singletonStaticNestedObj = (SingletonStaticNested)objectInputStream.readObject();
			hashCode2 = singletonStaticNestedObj.hashCode();
			if(hashCode1 == hashCode2) {
				System.out.println("Instances are same even after Serialization");
			}
		} catch(FileNotFoundException f) {
			System.err.println(f.getMessage());
		} catch(IOException f) {
			System.err.println(f.getMessage());
		} catch(ClassNotFoundException f) {
			System.err.println(f.getMessage());
		}
		
		//Clone Testing
		try {
			hashCode2 = instance1.clone().hashCode();
			if(hashCode1 == hashCode2) {
				System.out.println("Instances are same even after Cloning");
			}
		} catch(CloneNotSupportedException c) {
			System.err.println(c.getMessage());
		}
	}
}