package com.fang.job;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import com.fang.model.InterfaceInfo;
import com.fang.service.InterfaceInfoService;
import com.fang.util.ContextUtil;

public class MainJob implements Job{

	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {

		ContextUtil<InterfaceInfoService> contextUtil=new ContextUtil<InterfaceInfoService>();
		InterfaceInfoService interfaceInfoService = contextUtil.getbean(InterfaceInfoService.class);
		List<InterfaceInfo> list = interfaceInfoService.queryAll();
		System.out.println(list);
		for (InterfaceInfo interfaceInfo : list) {
			ScheduleJob scheduleJob=new ScheduleJob();
			scheduleJob.setJobName("job_"+interfaceInfo.getInterfaceID());
			scheduleJob.setJobGroupName("job_group_"+interfaceInfo.getInterfaceID());
			scheduleJob.setTriggerName("trigger_");
			scheduleJob.setTriggerGroupName("trigger_group_");
			scheduleJob.setCronExpression(interfaceInfo.getCronExpression());
			scheduleJob.setInterfaceInfo(interfaceInfo);
			QuartzManager.createJob(scheduleJob);
		}
		
	}

}
