package com.notebook.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class JsonTestController {
	@PostMapping(value="/jsonTest")
	public String JSONTest(HttpServletRequest req){
		System.out.println("jsonTest开始处理");
		String id=req.getParameter("id");
//		List list=JSONObject.parseArray(req.getParameter("list"));
		System.out.println("id:"+id);
//		System.out.println("list:"+list);
//		return list.toString();
		return "fetch return";
		
	}
	@PostMapping(value="/jsonTest1")
	public String JSONTest1(HttpServletRequest req,@RequestBody String list){
		System.out.println("jsonTest1开始处理");
		System.out.println("list:"+list);
		String result=list.toString();
		
		return result;
//		return "fetch return";
	}
	@PostMapping(value="/jsonTest2")
	public String JSONTest2(HttpServletRequest req){
		Enumeration param_names=req.getParameterNames();
		while(param_names.hasMoreElements()){
			String param_name=(String) param_names.nextElement();
			String param_value=req.getParameter(param_name);
			System.out.println("param_name："+param_name);
			System.out.println("param_value："+param_value);
		}
		return "222";
	}
}
