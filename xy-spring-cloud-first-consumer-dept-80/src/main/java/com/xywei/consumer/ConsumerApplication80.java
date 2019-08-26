package com.xywei.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.xywei.ribbon.rule.CustomRibbonRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider-dept-service", configuration = CustomRibbonRule.class)
public class ConsumerApplication80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerApplication80.class, args);
	}

}
