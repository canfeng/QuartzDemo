package com.fang.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fang.job.MainJob;
import com.fang.job.QuartzManager;
import com.fang.job.ScheduleJob;

public class RunEnter {

	public static void main(String[] args) throws InterruptedException {
		
		ScheduleJob scheduleJob=new ScheduleJob();
		InputStream inputStream = RunEnter.class.getClassLoader().getResourceAsStream("mainjob.properties");
		Properties properties=new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scheduleJob.setJobName(properties.getProperty("jobName"));
		scheduleJob.setJobGroupName(properties.getProperty("jobGroupName"));
		scheduleJob.setTriggerName(properties.getProperty("triggerName"));
		scheduleJob.setTriggerGroupName(properties.getProperty("triggerGroupName"));
		scheduleJob.setCronExpression(properties.getProperty("cronExpression"));
		scheduleJob.setJobClass(MainJob.class);
		
		QuartzManager.createJob(scheduleJob);
		QuartzManager.start();
		
		
	}
}


