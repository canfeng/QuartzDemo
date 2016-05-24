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
	 * ���սӿ���Ϣ
	 * @param interfaceInfo
	 */
	public JobFactory(InterfaceInfo interfaceInfo) {
		this.interfaceInfo=interfaceInfo;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("��̬�������ɵ�jobʵ����");
		
		return null;
	}
	
	/**
	 * ��ȡ��̬����ʵ����
	 * @author SZG
	 * 2016��5��4�� ����5:26:42
	 * @return
	 */
	public Object getProxyJob(){
		return Proxy.newProxyInstance(job_interface.getClassLoader(), 
			new Class<?>[]{job_interface}, this);
	}

	
}
