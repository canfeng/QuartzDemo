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
 * job����
 * http://my.oschina.net/u/1177710/blog/284608
 * @author zhiguo
 *
 */
public class QuartzManager {

	
	private static SchedulerFactory schedulerFactory=new StdSchedulerFactory();



	/**
	 * ���job
	 * 
	 * @author SZG 2016��5��4�� ����3:24:40
	 */
	public static void createJob(ScheduleJob scheduleJob) {
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			// ����Cron���ʽ �� �� ʱ �� �� �� ��
			CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
			// ������ ����
			if (null == trigger) {
				// ����Job
				JobDetail jobdetail = JobBuilder.newJob(scheduleJob.getJobClass()).withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroupName()).build();
				//��������Ϣ����jobExecutionContext
				jobdetail.getJobDataMap().put("executeJob", scheduleJob);
				// ͨ��TriggerBuilder���й���
				trigger = TriggerBuilder.newTrigger().withIdentity(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName())
						.withSchedule(cronSchedule).startNow() // �ӵ�ǰʱ�俪ʼ
						.build();
				//������󶨴�����
				scheduler.scheduleJob(jobdetail, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �޸�job
	 * 
	 * @author SZG 2016��5��4�� ����3:24:47
	 */
	public static void updateJob(ScheduleJob scheduleJob) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroupName());
			Scheduler scheduler = schedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

			if (null != trigger) {// ��������
				// Trigger�Ѵ��ڣ���ô������Ӧ�Ķ�ʱ����
				// ���µ�cronExpression���ʽ���¹���trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronSchedule).startNow()
						.build();

				// ���µ�trigger��������jobִ��
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ������
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
	 * ������ʱ����
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
	 * ֹͣ��ʱ����
	 * @author SZG
	 * 2016��5��4�� ����3:39:26
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
			System.out.println("����trigger:");
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
