package com.notebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping(value="/test1")
	public String getUser1(){
		return "test successful1";
	}
	@PostMapping(value="/test2")
	public String getUser2(){
		return "test successful2";
	}
	@RequestMapping("/hello")
	public String sayHello(HttpServletRequest req){
		System.out.println("hello test");
//		String id=req.getParameter("id");
//		System.out.println(id);
		return "hello world";
	}
}
