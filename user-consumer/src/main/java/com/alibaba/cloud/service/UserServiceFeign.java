package com.alibaba.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.cloud.configuration.FeignConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*
@FeignClient(name = "wanFeign",url = "http://localhost:8003")
如果結合eureka ,在FeignClient 註解中就可以不用寫url，直接name指定服務名稱就可以直接呼叫了
*/
@FeignClient(name = "user-provider", configuration = FeignConfiguration.class)
public interface UserServiceFeign {

	@GetMapping("/getWan")
	public String getWan();

	@GetMapping("/getWanParams")
	public String getWanParams(@RequestParam("name") String name);

	@PostMapping("/postWan")
	public String postWan();

	@PostMapping("/postWanParams")
	public String postWanParams(@RequestParam("name") String name);

	// 帶參數用法
//	@RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//	public void update(@PathVariable("storeId") Long storeId, Store store);
}
