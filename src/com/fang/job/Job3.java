package com.fang.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job3 implements Job {

	@Override
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {

		System.out.println(this.getClass().toString() +"::"+ new Date());
	}

}
