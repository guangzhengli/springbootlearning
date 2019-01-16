package com.ligz.springbootstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:ligz
 */
@RestController
public class HelloController {
	@Autowired
	User user;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/getUser")
	public String getUser(){
		return user.getName() + " is " + user.getContent();
	}

}
