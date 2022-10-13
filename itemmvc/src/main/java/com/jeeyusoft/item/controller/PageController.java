package com.jeeyusoft.item.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeeyusoft.item.domain.MemberDTO;
import com.jeeyusoft.item.domain.ReportDTO;

import lombok.extern.log4j.Log4j;

//Controller를 만들기위한 어노테이션
@Controller
@Log4j
public class PageController {
	//처리 할 URL과 전송방식
	@RequestMapping(value="blog/{num}",method=RequestMethod.GET)
	//Model은 View에게 데이터를 넘기기 위한 객체
	public String blog(@PathVariable int num, Model model) {
		
		//로그
		log.info("num: " + num);
		
		//뷰에게 데이터 전달
		//num이라는 이름으로 num이라는 데이터를 전달
		model.addAttribute("num",num);
		
		//출력 할 뷰 이름 설정
		return "blog";
	}
	
	@RequestMapping(value="parameter", method=RequestMethod.GET)
	public String parameter(Model model) {
		
		return "parameter";
	}
	
	//파라미터를 HttpServletRequest를 이용해서 읽기
	@RequestMapping(value="getlink", method=RequestMethod.GET)
	public void getlink(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		System.out.println(name);
		System.out.println(job);
		
	}
	//파라미터를 @RequestParam을 이용해서 읽기
	@RequestMapping(value="getform", method=RequestMethod.GET)
	public String getForm(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		
		System.out.println(name);
		System.out.println(password);
		
		return "";
	}
	
	
	//파라미터를 command 객체를 이용해서 읽기(POST)
	@RequestMapping(value="postform", method=RequestMethod.POST)
	public String postform(MemberDTO memberDTO, Model model) {
		
		System.out.println(memberDTO);
		return "";
	}
	
	@RequestMapping(value="fileupload",method=RequestMethod.POST)
	public void fileUpload (ReportDTO reportDTO, HttpServletRequest request) {
		if(reportDTO.getPicurl().isEmpty()) {
			System.out.println("업로드 된 파일이 없습니다.");
		}
		else {
			//프로젝트내 절대 경로 생성
			String filepath = request.getServletContext().getRealPath("/upload");
			filepath = filepath + "/" +
					UUID.randomUUID()
					+ reportDTO.getPicurl().getOriginalFilename();
			
			System.out.println(filepath);
			
			File file = new File(filepath);
			try {
				reportDTO.getPicurl().transferTo(file);
			}catch (Exception e) {
				
			}
			System.out.println("업로드 된 파일 :" + reportDTO.getPicurl());
		}
	}
}
