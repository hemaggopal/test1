package com.infosys.learning.designpatterns.factory;

public interface BeanFactory {
	Object getBean(String name) throws BeansException;
}