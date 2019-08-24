package com.xywei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xywei.entity.Dept;
import com.xywei.service.DeptService;

@RestController
public class DeptController {

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

}
