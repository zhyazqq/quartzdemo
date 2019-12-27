package com.onepage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.onepage.task.TaskDemo;

@Configuration
public class QuartzConfig {
	
	//创建job类
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factoryBean=new JobDetailFactoryBean();
		factoryBean.setJobClass(TaskDemo.class);
		return factoryBean;
	}
	//创建trigger类
	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean (JobDetailFactoryBean jobDetailFactoryBean) {
		//关联jobdetail对象
		SimpleTriggerFactoryBean triggerFactoryBean=new SimpleTriggerFactoryBean();
		triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间
		triggerFactoryBean.setRepeatInterval(2000);
		return triggerFactoryBean;
	}
	//创建Schedule
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean( SimpleTriggerFactoryBean simpleTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();

		schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
		schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
		return schedulerFactoryBean;
	}
}
