package com.jiyoosoft.sts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@GetMapping("/")
	public String gohome() {
		return "Hello Spring Boot Web I'm here";
	}
}
