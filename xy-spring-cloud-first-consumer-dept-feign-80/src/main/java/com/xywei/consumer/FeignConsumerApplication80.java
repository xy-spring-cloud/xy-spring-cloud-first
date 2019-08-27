package com.xywei.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author future
 * @Datetime 2019年8月26日 下午11:22:28<br/>
 * @Description
 * @EnableFeignClients 是service层所在的包
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.xywei" })
//@ComponentScan(basePackages = "com.xywei") 不用也没问题
@ComponentScan(basePackages = "com.xywei")
public class FeignConsumerApplication80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FeignConsumerApplication80.class, args);
	}

}
