package com.onepage.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobExecutionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onepage.task.TaskDemo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
	
	@Test
	public void demoTest() throws JobExecutionException {
		TaskDemo demo =new TaskDemo();
	
	}
	
}
