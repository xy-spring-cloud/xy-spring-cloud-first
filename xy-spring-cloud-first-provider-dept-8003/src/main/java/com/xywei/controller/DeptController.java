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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xywei.entity.Dept;
import com.xywei.entity.DeptMSG;
import com.xywei.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private DeptService deptService;

	@GetMapping("/depts")
	@HystrixCommand
	public List<Dept> listDepts() {
		return deptService.list();
	}

	@PostMapping("/dept")
	public boolean addDept(Dept dept) {
		return deptService.add(dept);
	}

	/**
	 * 
	 * @Datetime 2019年8月27日 下午12:30:59<br/>
	 * @Description 添加服务熔断
	 * @param id
	 * @return
	 */
	@GetMapping("/dept/{id}")
	@HystrixCommand(fallbackMethod = "fallBack_FinDeptById")
	public Dept finDeptById(@PathVariable("id") Long id) {

		Dept dept = deptService.get(id);

		if (null == dept) {

			System.out.println("1==========================服务熔断了=================================================");
			DeptMSG deptMSG = new DeptMSG("没有数据，来自provider的消息");
			dept.setDeptno(id);
			System.out.println("没有数据");
			System.out.println("2===========================================================================");
			throw new RuntimeException(deptMSG.getDeptno() + " " + deptMSG.getMessage());
		}

		return dept;
	}

	/**
	 * 服务器熔断以后调用的方法
	 * 
	 * @Datetime 2019年8月27日 下午12:33:01<br/>
	 * @Description
	 * @return
	 */
	public Dept fallBack_FinDeptById(@PathVariable("id") Long id) {
//		DeptMSG dept = new DeptMSG("没有数据，来自provider的消息");
//		dept.setDeptno(id);
		return new Dept((long) id, "没有信息", "没有数据");
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
