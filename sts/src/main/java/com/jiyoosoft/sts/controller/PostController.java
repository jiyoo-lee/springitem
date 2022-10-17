package com.jiyoosoft.sts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiyoosoft.sts.dto.MemberDTO;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	//@RequestBody를 이용
	@PostMapping(value="/member")
	public String parameterPost( @RequestBody MemberDTO memberDTO) {	
		return memberDTO.toString();
	}
}
