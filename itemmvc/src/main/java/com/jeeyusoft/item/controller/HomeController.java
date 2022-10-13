package com.jeeyusoft.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	//hello라는 요청이 오면 hello라는 뷰 이름을 리턴
	//servlet-context.xml파일의 viewResolver의 내용을 참조해서 위치를 결정한다.
	@RequestMapping(value = "hello", 
			method = RequestMethod.GET)
	public String hello(Model model) {
	
		
		return "hello";
	}
	
}
