package com.alibaba.cloud.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Request;

public class FeignConfiguration {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Request.Options options() {

		return new Request.Options(5,TimeUnit.SECONDS,10,TimeUnit.SECONDS,true);
	}
}