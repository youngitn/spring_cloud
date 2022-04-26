package com.alibaba.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.cloud.service.UserServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MainController {

	// 服務直連，不通過eureka，直接進行請求
	@Autowired
	UserServiceFeign userApiService;

	// 通過eureka服務名稱請求
	@Autowired
	UserServiceFeign userApi2Service;

	// 服務直連，不通過eureka，直接進行請求
	@HystrixCommand(fallbackMethod = "getWanFallback")
	@GetMapping("/getWan")
	public String getWan() {
		
		return userApiService.getWan();
	}

	public String getWanFallback() {
		return "getWan getWanFallback!!!";
	}

	// 通過eureka服務名稱請求-
	@GetMapping("/getWan2")
	public String getWan2() {
		return userApi2Service.getWan();
	}

	// 通過eureka服務名稱請求-帶參請求
	@GetMapping("/getWanParams")
	public String getWanParams() {
		String name = "Hi！！ wan";
		return userApi2Service.getWanParams(name);
	}

	// 通過eureka服務名稱請求-post無參請求
	@GetMapping("/postWan")
	public String postWan() {
		return userApi2Service.postWan();
	}

	// 通過eureka服務名稱請求-post帶參請求
	@GetMapping("/postWanParams")
	public String postWanParams() {
		String name = "Hi！！ wan";
		return userApi2Service.postWanParams(name);
	}

}