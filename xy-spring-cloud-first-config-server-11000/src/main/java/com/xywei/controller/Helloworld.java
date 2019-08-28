package com.xywei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

	@RequestMapping("/helloworld")
	public String helloworld() {
		return "hello,world!";
	}

}
