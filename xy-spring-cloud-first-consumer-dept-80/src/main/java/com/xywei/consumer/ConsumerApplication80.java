package com.xywei.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerApplication80.class, args);
	}

}
