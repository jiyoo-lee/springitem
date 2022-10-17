package com.jiyoosoft.sts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiyoosoft.sts.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PUTController {
	
	@PutMapping(value="/member")
	public String parameterPut( @RequestBody MemberDTO memberDTO) {	
		return memberDTO.toString();
	}
	
	//DTO 인스턴스를 리턴하면 json 형식으로 출력됨
	@PutMapping(value="/member1")
	public MemberDTO parameterPut1( @RequestBody MemberDTO memberDTO) {	
		return memberDTO;
	}
	
	//DTO 인스턴스를 리턴하면 json 형식으로 출력됨
	@PutMapping(value="/member2")
	public ResponseEntity<MemberDTO> parameterPut2( @RequestBody MemberDTO memberDTO) {	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
	}
	
}
