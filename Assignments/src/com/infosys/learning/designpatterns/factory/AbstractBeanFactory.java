package com.infosys.learning.designpatterns.factory;

public class AbstractBeanFactory implements BeanFactory {

	public Object getBean(String name) throws BeansException {
		if(name.equals("foo"))
			return new Foo();
		else if(name.equals("bar"))
			return new Bar();
		else	
			throw new BeansException("Object cannot be created");
			
	}
	
}