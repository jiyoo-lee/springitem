package com.jeeyusoft.item.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDTO {
	
	private String name;
	//file은 multipartfile로 생성한다!!!
	private MultipartFile picurl;

}
