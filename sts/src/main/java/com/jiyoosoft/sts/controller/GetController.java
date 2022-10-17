package com.jiyoosoft.sts.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiyoosoft.sts.dto.MemberDTO;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String hello() {	return "Hello GET Method!"; }

	
	//variale/문자열
	@GetMapping(value="/variable/{variable}")
	public String getVariale(@PathVariable String variable) {
		
		return variable;
	}
	
//	@GetMapping(value="/variable/{variable}")
//	public String getVariale2(@PathVariable("variable") String var) {
//		
//		return var;
//	}
	
	// ##################파라미터 처리####################
	
	
	//고전적인 Java Web Programming에서의 처리 방식
	@GetMapping(value="/parameter1")
	public String parameter(HttpServletRequest request) {
		
		String result = request.getParameter("email") + " "
						+request.getParameter("name") + " "
						+request.getParameter("organization");
		return result;
	}
	
	//파라미터를 읽어서 형변환까지는 수행 해줌
	@GetMapping(value="/parameter2")
	public String parameter2(@RequestParam("email") String email, @RequestParam("") String name, @RequestParam("organization") String organization) {
		
		String result = email + " " + name + " " + organization;
		return result;
	}
	
	//파라미터가 어떻게 올지 몰라서 Map을 이용 (이름을 모를때 사용함 , 파라미터가 여러개인데 고정된 값이 전송되지 않는 경우임. 권장하진 않음)
	@GetMapping(value="/parameter3")
	public String parameter3(@RequestParam Map<String,String> param) {
		StringBuilder result = new StringBuilder();	
		//Map 순회
		param.entrySet().forEach(map -> {
			result.append(map.getKey() + " :" 
						+ map.getValue() + "\n");
		});
		return result.toString();
	}
	
	//가장 권장 사항, 파라미터들을 하나의 인스턴스로 묶어서 처리
	// 파라미터가 여러개일때 권장하는 방식이다. 
	@GetMapping(value="/parameter4")
	public String parameter4(MemberDTO memberDTO) {
		
		return memberDTO.toString();
	}
	
	//String으로 바로 더해주면 안됨(memory leak 발생 우려)
	public void test() {
		String str = "hello";
		String result = String.format("%s","%s", str,"word");
		System.out.println(result);
	}
	
}

