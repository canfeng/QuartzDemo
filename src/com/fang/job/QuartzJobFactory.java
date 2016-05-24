package com.fang.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fang.model.InterfaceInfo;
import com.fang.util.web.RequestUtil;

/**
 * 公共的定时执行方法
 * @author zhiguo
 *
 */
public class QuartzJobFactory implements Job{

	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		ScheduleJob executeJob = (ScheduleJob)jobContext.getMergedJobDataMap().get("executeJob");
		System.out.println("当前执行任务："+executeJob.getJobName()+":"+new Date());
		InterfaceInfo interfaceInfo=executeJob.getInterfaceInfo();
		if (interfaceInfo!=null) {
			interfaceInfo.getSimpleUrl();
			String result = RequestUtil.getHtml(interfaceInfo.getSimpleUrl(), "utf-8", interfaceInfo.getTimeOut());
			System.out.println(result);
		}
	}
	
	
}
