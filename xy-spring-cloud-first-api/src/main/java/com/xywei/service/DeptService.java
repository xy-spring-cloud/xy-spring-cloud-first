package com.xywei.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xywei.entity.Dept;

/**
 * 
 * @author future
 * @Datetime 2019年8月26日 下午10:53:55<br/>
 *           TODO 这里的URL一定要和provider controller的一致？待测试
 */
@FeignClient(name = "provider-dept-service", fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptService {

	@GetMapping("/depts")
	public List<Dept> listDepts();

	@PostMapping("/dept")
	public boolean addDept(Dept dept);

	@GetMapping("/dept/{id}")
	public Dept finDeptById(@PathVariable("id") Long id);

	@GetMapping("/service")
	public List<List<ServiceInstance>> serviceDiscovery();

}
