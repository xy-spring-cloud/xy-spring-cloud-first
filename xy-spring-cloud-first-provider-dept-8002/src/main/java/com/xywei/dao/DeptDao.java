package com.xywei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xywei.entity.Dept;


/**
 * @author future
 * @createDate 2019年8月24日 下午10:16:39 <br/>
 *             mybatis与Spring Boot整合必须有@mapper
 */
@Mapper
public interface DeptDao {

	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();

}
