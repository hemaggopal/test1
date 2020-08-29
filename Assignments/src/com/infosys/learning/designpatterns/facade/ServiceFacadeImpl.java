package com.infosys.learning.designpatterns.facade;

public class ServiceFacadeImpl implements ServiceFacade {
	
	public void perform() {
		boolean flag = false;
		if (new ServiceA().isJobDone()) 
			System.out.println("ServiceA job is completed");
		if (new ServiceB().isJobDone()) 
			System.out.println("ServiceB job is completed");
		if (new ServiceC().isJobDone())
			System.out.println("ServiceC job is completed");
	}
	
}