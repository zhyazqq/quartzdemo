package com.onepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//import com.onepage.swagger.EnableZQQSwagger;



@SpringBootApplication
@EnableScheduling
//@EnableZQQSwagger 第一种界面注释  如需开启  请把下面两个注释
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
	}

}
