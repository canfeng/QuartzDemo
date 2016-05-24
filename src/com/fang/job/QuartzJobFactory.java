package com.fang.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fang.model.InterfaceInfo;
import com.fang.util.web.RequestUtil;

/**
 * �����Ķ�ʱִ�з���
 * @author zhiguo
 *
 */
public class QuartzJobFactory implements Job{

	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		ScheduleJob executeJob = (ScheduleJob)jobContext.getMergedJobDataMap().get("executeJob");
		System.out.println("��ǰִ������"+executeJob.getJobName()+":"+new Date());
		InterfaceInfo interfaceInfo=executeJob.getInterfaceInfo();
		if (interfaceInfo!=null) {
			interfaceInfo.getSimpleUrl();
			String result = RequestUtil.getHtml(interfaceInfo.getSimpleUrl(), "utf-8", interfaceInfo.getTimeOut());
			System.out.println(result);
		}
	}
	
	
}
