package com.fang.job;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.quartz.Job;

import com.fang.model.InterfaceInfo;

public class JobFactory implements InvocationHandler{
	
	private static Class<? extends Job> job_interface=Job.class;
	
	private InterfaceInfo interfaceInfo;
	
	/**
	 * 接收接口信息
	 * @param interfaceInfo
	 */
	public JobFactory(InterfaceInfo interfaceInfo) {
		this.interfaceInfo=interfaceInfo;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("动态代理生成的job实现类");
		
		return null;
	}
	
	/**
	 * 获取动态代理实现类
	 * @author SZG
	 * 2016年5月4日 下午5:26:42
	 * @return
	 */
	public Object getProxyJob(){
		return Proxy.newProxyInstance(job_interface.getClassLoader(), 
			new Class<?>[]{job_interface}, this);
	}

	
}
