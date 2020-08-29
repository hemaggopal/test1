package com.infosys.learning.designpatterns.facade;
/**
 * Facade acts as single interface exposed to client.
 * Client is agnostic of the complex interfaces behind it.
 */
public class FacadeMain {

	public static void main(String[] args) {
		ServiceFacade facade = new ServiceFacadeImpl();
		facade.perform();
	}
	
}