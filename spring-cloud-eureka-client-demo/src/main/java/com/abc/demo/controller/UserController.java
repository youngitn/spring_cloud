package com.abc.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Service("aaaaa")
public class UserController {

	@Value("${configuration.test}")
	private String testMsg;

	// 無參get方法
	@GetMapping("/getWan")
	public String getWan() throws InterruptedException {

		return "Hi wan 呼叫方式為：get!!" + "8003" + testMsg;
	}

	// 帶參get方法
	@GetMapping("/getWanParams")
	public String getWanParams(String name) {
		return "Hello !! 呼叫方式為：get ,引數為：" + name;
	}

	// 無參post方法
	@PostMapping("/postWan")
	public String postWan() {
		return "Hi wan 呼叫方式為：post!!";
	}

	// 帶參post方法
	@PostMapping("/postWanParams")
	public String postWanParams(String name) {
		return "Hi wan 呼叫方式為：post,引數為：" + name;
	}

}
