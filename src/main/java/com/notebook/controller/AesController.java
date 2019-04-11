package com.notebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AesController {
	@GetMapping(value="/AESGet",produces="text/plain;charset=UTF-8")
	public String getUser1(HttpServletRequest req,HttpServletResponse res){
		System.out.println("method:"+req.getMethod());
		System.out.println("AESGet");
		res.setHeader("app-token", "2245");
		System.out.println("token:"+req.getHeader("app-token"));
		res.setContentType("application/json");
		return "{'id':'111','name':'aaa'}";
	}
//	@RequestMapping(value = "/upload",produces="application/json;charset=UTF-8")
	@PostMapping(value="/AESPost")
	public String getUser2(HttpServletRequest req,HttpServletResponse res,@RequestBody String param){
		System.out.println("AESPost");
		System.out.println(param);
		System.out.println("token:"+req.getHeader("app-token"));
		res.setHeader("app-token","12345");
		return "test successful2";
	}
	
	@RequestMapping("/AESByte")
	public String sayHello(HttpServletRequest req){
		System.out.println("AESByte");
		System.out.println("hello test");
		return "hello world";
	}
}
