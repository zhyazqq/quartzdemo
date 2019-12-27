package com.onepage.service.Impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.onepage.service.KafkaConnection;
@Service
public class KafkaConnectionImpl implements KafkaConnection {
	private KafkaTemplate<?, Object> template;

	//启动zookeeper
	//启动kafka命令 在安装目录 bin文件夹那一层 不要进入bin文件   .\bin\windows\kafka-server-start.bat .\config\server.properties 
//查看消息命令 在安装目录 bin文件夹那一层 不要进入bin文件 shift+右键开启shell 输入  .\bin\windows\kafka-console-consumer.bat --bootstrap-server 192.168.10.104:9092 --topic test_topic_1 --from-beginning
	@Override
	public boolean isConnection(String IP, Integer port) {
		
		
		
		
		
		
		
		String topic = "test_topic_1";
		Long time = System.currentTimeMillis();
		Properties posProperties = new Properties();
		ConsumerConfig config = new ConsumerConfig(posProperties);
		
		
		
		
		
		posProperties.put("zookeeper.connect", "192.168.10.104:2181");
		posProperties.put("bootstrap.servers", "192.168.10.104:9092");
		posProperties.put("group.id", "test-consumer-group");
		posProperties.put("enable.auto.commit", "false");
		posProperties.put("auto.commit.interval.ms", "1000");
		posProperties.put("auto.offset.reset", "none");
		posProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		posProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");	
	
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(posProperties);
		//订阅消息
		consumer.subscribe(Arrays.asList(topic));
		ConsumerRecords<String, String> records = consumer.poll(100);
		for (ConsumerRecord<String, String> record : records) {
			if (record.value().equals(time+"")) {
				System.out.println(record.key());
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
				consumer.close();
				return true;
			}
			
		}
		
		consumer.close();
		return false;
	}
}
