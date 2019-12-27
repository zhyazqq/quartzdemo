package com.onepage.task;



import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;
@Component
public class KafkaConsumer {
	
	
	@KafkaListener(topics = {"test_topic_1"})
	public String listen(ConsumerRecord<String, String> record) {
		System.out.println("消息接受成功：topic："+record.topic()+"value:"+record.value());
		System.out.println("------------");
		return record.topic();
	}
}
