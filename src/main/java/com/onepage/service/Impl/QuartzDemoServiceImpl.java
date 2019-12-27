package com.onepage.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.onepage.dao.Student;
import com.onepage.service.QuartzDemoService;

@Service
public class QuartzDemoServiceImpl implements QuartzDemoService {
	@Autowired
	private KafkaTemplate<String, String> kafka;

	@Override
//	@Scheduled(cron = "0/10 * * * * ?")
//	@Scheduled(fixedDelay = 10000)
	public String task() {
		// TODO Auto-generated method stub
//		Long strLong=System.currentTimeMillis();
//		System.out.println("任务执行了");
		String nameString = "";

		new Thread(() -> {

			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
//					nameString=Thread.currentThread().getName();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("任务结束");
//			Long endLong=System.currentTimeMillis();
//			System.out.println(endLong-strLong);
		}).start();

		return nameString;
	}

//	@Scheduled(cron = "0/10 * * * * ?")
	@Override
	public String send() {
		
		System.out.println("任务执行了");
		new Thread(()->{
		String naemString=Thread.currentThread().getName();
		
		kafka.send("test_topic_1", naemString);
		
		System.out.println(kafka.send("test_topic_1", naemString));
		System.out.println("发送成功");
		}).start();;
		return "success";
	}

}
