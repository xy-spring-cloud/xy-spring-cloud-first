package com.xywei.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class FeignConsumerApplication80Configuration {
	/**
	 * 
	 * @Datetime 2019年8月26日 下午11:23:57<br/>
	 * @Description
	 * @return 整合了feign就没有用了
	 */
//
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	@Bean
	public IRule iRule() {
		// 轮询，与@ribbonclient中同时存在，看是否会报错？还是覆盖？
//		return new RoundRobinRule();
		// 随机
		return new RandomRule();
		// 重试
//		return new RetryRule();
	}

}
