package com.fang.job;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;



/**
 * job控制
 * http://my.oschina.net/u/1177710/blog/284608
 * @author zhiguo
 *
 */
public class QuartzManager {

	
	private static SchedulerFactory schedulerFactory=new StdSchedulerFactory();



	/**
	 * 添加job
	 * 
	 * @author SZG 2016年5月4日 下午3:24:40
	 */
	public static void createJob(ScheduleJob scheduleJob) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// 构建Cron表达式 秒 分 时 日 月 周 年
			CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
			// 不存在 创建
			if (null == trigger) {
				// 构建Job
				JobDetail jobdetail = JobBuilder.newJob(scheduleJob.getJobClass()).withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroupName()).build();
				//将人物信息传入jobExecutionContext
				jobdetail.getJobDataMap().put("executeJob", scheduleJob);
				// 通过TriggerBuilder进行构建
				trigger = TriggerBuilder.newTrigger().withIdentity(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName())
						.withSchedule(cronSchedule).startNow() // 从当前时间开始
						.build();
				//将任务绑定触发器
				scheduler.scheduleJob(jobdetail, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改job
	 * 
	 * @author SZG 2016年5月4日 下午3:24:47
	 */
	public static void updateJob(ScheduleJob scheduleJob) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName());
			Scheduler scheduler = schedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

			if (null != trigger) {// 存在任务
				// Trigger已存在，那么更新相应的定时设置
				// 按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronSchedule).startNow()
						.build();

				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除任务
	 */
	protected static void deleteJob(ScheduleJob scheduleJob) {
		try {
			Scheduler scheduler =schedulerFactory.getScheduler();
			JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroupName());
			scheduler.deleteJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 启动定时任务
	 */
	public static void start() {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			if (!scheduler.isStarted()) {
				scheduler.start();
			}
			scheduler.resumeAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止定时任务
	 * @author SZG
	 * 2016年5月4日 下午3:39:26
	 */
	public static  void shutdown(){
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void showJobs() {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
			System.out.println("所有trigger:");
			int i=2;
			for (String triggerGroup : triggerGroupNames) {
				Trigger trigger = scheduler.getTrigger(new TriggerKey("job_trigger_"+i,triggerGroup));
				i--;
				System.out.println(trigger);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
