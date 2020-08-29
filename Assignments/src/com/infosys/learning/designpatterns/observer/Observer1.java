package com.infosys.learning.designpatterns.observer;

public class Observer1 implements Observer {
	
	@Override
	public void update() {
		System.out.println("Observer1 - Updates received");		
	}
	
}
