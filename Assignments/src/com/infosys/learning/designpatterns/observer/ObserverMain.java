package com.infosys.learning.designpatterns.observer;

public class ObserverMain {

	public static void main(String[] args) {
		Observable observable = new Observable();
		observable.register(new Observer1());
		observable.register(new Observer2());
		
		observable.setState(5);
		
	}
}
