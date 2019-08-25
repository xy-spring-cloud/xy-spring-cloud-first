package com.xywei.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xywei.entity.Dept;
import com.xywei.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private DeptService deptService;

	@GetMapping("/depts")
	public List<Dept> listDepts() {
		return deptService.list();
	}

	@PostMapping("/dept")
	public boolean addDept(Dept dept) {
		return deptService.add(dept);
	}

	@GetMapping("/dept/{id}")
	public Dept finDeptById(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@GetMapping("/service")
	public List<List<ServiceInstance>> serviceDiscovery() {

		List<String> services = client.getServices();
		System.out.println("****************注册的服务id****************");
		System.out.println(services);
		List<List<ServiceInstance>> allInstancesList = new ArrayList<List<ServiceInstance>>();

		for (String service : services) {
			System.out.println(">>>>>>>>>>>>>>>>详细服务有<<<<<<<<<<<<<<<<");
			List<ServiceInstance> instances = client.getInstances(service);
			allInstancesList.add(instances);
			for (ServiceInstance serviceInstance : instances) {
				System.out.println("================================");
				System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t"
						+ serviceInstance.getPort() + "\t" + serviceInstance.getUri().toString());
				System.out.println("================================");

			}
		}
		return allInstancesList;

	}

}
