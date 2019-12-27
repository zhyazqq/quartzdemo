package com.onepage.config;

//import javax.annotation.Resource;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;
@Component("myAdaptableJobFactory")//实例化bean
public class MyAdaptableJobFactory extends AdaptableJobFactory{
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	//将对象添加到spring容器中 并完成注入
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		Object object=super.createJobInstance(bundle);
		autowireCapableBeanFactory.autowireBean(object);
		return object;
	}
}
