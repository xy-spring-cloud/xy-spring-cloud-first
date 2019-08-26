package com.xywei.service;

import java.util.List;

import com.xywei.entity.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
