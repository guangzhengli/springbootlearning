package com.ligz.springbootstart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author:ligz
 */
@Component
public class User {
	@Value("${com.ligz.name}")
	private String name;

	@Value("${com.ligz.content}")
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
