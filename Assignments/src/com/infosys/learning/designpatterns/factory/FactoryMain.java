package com.infosys.learning.designpatterns.factory;

public class FactoryMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new AbstractBeanFactory();
		try {
			Foo foo = (Foo)beanFactory.getBean("foo");
			foo.get();
			Bar bar = (Bar)beanFactory.getBean("bar");			
			bar.get();		
			
			beanFactory.getBean("nonexistent");	
			
		} catch(BeansException be) {
			System.out.println(be.getMessage());
		}
	}
}