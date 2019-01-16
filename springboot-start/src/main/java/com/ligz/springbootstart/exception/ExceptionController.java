package com.ligz.springbootstart.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:ligz
 */
@RestController
@RequestMapping(value = "/error")
public class ExceptionController {
	@RequestMapping(value = "/noException")
	public String noException() throws Exception{
		throw new Exception("发生错误");
	}

	@RequestMapping("/json")
	public String json() throws MyException {
		throw new MyException("发生错误2");
	}
}
