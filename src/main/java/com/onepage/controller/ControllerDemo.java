package com.onepage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onepage.service.QuartzDemoService;


@RestController
@RequestMapping("/kafka")
public class ControllerDemo {
	@Resource
	private QuartzDemoService service;
	@RequestMapping("/send")
	public String sendMSG() {
		
		return service.send();
	}
}
