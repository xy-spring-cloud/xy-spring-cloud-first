package com.xywei.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xywei.entity.Dept;

/**
 * @author future
 * @Datetime 2019年8月24日 下午11:48:09<br/>
 *           restTemplate:类似MocMVC，发送rest请求
 */
@RestController
public class ConsumerDeptController {

//	private static final String PROVIDER_URL_SUFFIX = "http://127.0.0.1:8001/";
	// ribbon与eureka整合后可以直接使用服务名字，而不需要知道IP+port
	private static final String PROVIDER_URL_SUFFIX = "http://provider-dept-service/";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer/depts")
	public List<Dept> listDepts() {
		return restTemplate.getForObject(PROVIDER_URL_SUFFIX + "depts", List.class);
	}

	@PostMapping("/consumer/dept")
	public boolean addDept(Dept dept) {
		return restTemplate.postForObject(PROVIDER_URL_SUFFIX + "dept", dept, Boolean.class);
	}

	/**
	 * 
	 * @Datetime 2019年8月25日 上午12:19:13<br/>
	 * @param id
	 * @return
	 */
	@GetMapping("/consumer/dept/{id}")
	public Dept finDeptById(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PROVIDER_URL_SUFFIX + "dept" + "/" + id, Dept.class);
//		 这里有个坑，provider端明明是get要求，此处也是get请求，最后怎么出现了405，原因，是方法用错了
//		return restTemplate.getForObject(PROVIDER_URL_SUFFIX+"dept", Dept.class, id);
	}

	@GetMapping("/consumer/service")
	public List<List<ServiceInstance>> serviceDiscovery() {

		List<List<ServiceInstance>> allInstancesList = restTemplate.getForObject(PROVIDER_URL_SUFFIX + "/service",
				List.class);

		return allInstancesList;

	}

}
