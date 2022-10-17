package com.jiyoosoft.sts.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/delete-api")
public class DeleteController {
	
	@DeleteMapping(value="/request")
	public String deleteThis(@RequestParam("name") String name){
		return name;
	}
}
