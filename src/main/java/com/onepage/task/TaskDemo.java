package com.onepage.task;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.onepage.service.QuartzDemoService;
public class TaskDemo implements Job {
	@Resource
	private QuartzDemoService service;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("任务开始---->job");
		service.send();
		System.out.println("任务结束---->job");
	}
}
