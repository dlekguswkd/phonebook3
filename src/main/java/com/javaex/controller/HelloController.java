package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {		// pojo 프로그래밍 깨끗한 상황

	//필드

	//생성자
	
	//메소드 gs
	
	//메소드 일반
	@RequestMapping(value="/hello", method= {RequestMethod.GET, RequestMethod.POST})
	public String hello() {
		System.out.println("HelloController.hello()");
		
		
		return "/WEB-INF/views/hello.jsp";		// 포워드 누구한테 넘길까요
	}
	
	
	
}
