package com.xywei.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerApplication80Configuration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
