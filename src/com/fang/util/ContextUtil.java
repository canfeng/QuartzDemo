package com.fang.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextUtil<T> {

	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

	public  T getbean(Class<T> clazz) {
		return (T) context.getBean(clazz);
	}

	public  T getbean(String beanName) {
		return (T) context.getBean(beanName);
	}
}
