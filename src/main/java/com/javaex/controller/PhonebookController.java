package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller		//이걸 달고있는것만 조사함(주소가 여기에 있다!라는 의미) (dao나 vo엔 안넣어줌)
public class PhonebookController {
	
	//필드
	//생성자
	//메소드gs
	
	//메소드일반 ///////이것만 짜주면 됨
	
	//등록폼				주소							get 방식			post 방식
	@RequestMapping(value="/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		
		
		return "/WEB-INF/views/writeForm.jsp";		//포워드(웹에서만 일어나는) -> 대신 return
	}
	
	
	//등록
	
	
	//리스트
	
	

}
