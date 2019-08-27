package com.xywei.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import com.xywei.entity.Dept;
import com.xywei.entity.DeptMSG;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @author future
 * @Datetime 2019年8月27日 下午12:26:27<br/>
 * @Description 服务降级使用
 */
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {

	@Override
	public DeptService create(Throwable cause) {
		return new DeptService() {

			@Override
			public List<List<ServiceInstance>> serviceDiscovery() {
				return null;
			}

			@Override
			public List<Dept> listDepts() {
				return null;
			}

			@Override
			public Dept finDeptById(Long id) {
				System.out.println("===========================服务降级了===================================");
				Dept dept = new Dept((Long) id, "没数据，provider端已经关闭", "no 数据");
				return dept;
			}

			@Override
			public boolean addDept(Dept dept) {
				return false;
			}
		};
	}

}
