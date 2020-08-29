package com.infosys.learning.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private int state;
	private List<Observer> observers;
	
	public Observable() {
		observers = new ArrayList<>();
	}
	
	public void register(Observer observer) {
		observers.add(observer);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyObservers();		
	}
	
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
	
}
