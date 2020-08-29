package com.infosys.learning.designpatterns.factory;

public interface ApplicationContext extends BeanFactory {

	Object getBean(String name);

}
	
	