package com.xywei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication7003 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServerApplication7003.class, args);
	}

}
