package com.xywei.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xywei.entity.Dept;
import com.xywei.service.DeptService;

/**
 * 
 * @author future
 * @Datetime 2019年8月26日 下午10:59:44
 * @Description 直接调用api的 service
 */
@RestController
public class FeignConsumerDeptController {

	@Autowired
	private DeptService deptService;

	@GetMapping("/feign/consumer/depts")
	public List<Dept> listDepts() {
		return deptService.listDepts();
	}

	@PostMapping("/feign/consumer/dept")
	public boolean addDept(Dept dept) {
		return deptService.addDept(dept);
	}

	@GetMapping("/feign/consumer/dept/{id}")
	public Dept finDeptById(@PathVariable("id") Long id) {
		return deptService.finDeptById(id);

	}

	@GetMapping("/feign/consumer/service")
	public List<List<ServiceInstance>> serviceDiscovery() {

		List<List<ServiceInstance>> allInstancesList = deptService.serviceDiscovery();
		return allInstancesList;

	}

}
