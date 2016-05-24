package com.fang.main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.quartz.Job;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fang.job.MainJob;
import com.fang.model.InterfaceInfo;
import com.fang.service.InterfaceInfoService;

public class _test {

	
	@Test
	public void test1() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		InterfaceInfoService interfaceInfoService = context.getBean(InterfaceInfoService.class);
		List<InterfaceInfo> list = interfaceInfoService.queryAll();
		System.out.println(list);
	}
	
	@Test
	public void test2() throws Exception {
		for (Class<?> item : MainJob.class.getInterfaces()) {
			System.out.println(item);
		}
		
		
	}
}
