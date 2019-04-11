package com.notebook.filter;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.notebook.common.ResponseUtil;

public class UserConfig extends HandlerInterceptorAdapter{
	private final Logger loger=LoggerFactory.getLogger(UserConfig.class);
	Map result=new HashMap();
	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse resp,Object o) throws Exception{
//		请求处理之前调用
//		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8086");
//		resp.setHeader("Access-Control-Allow-Origin", "*");
//		resp.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
//		resp.setHeader("Access-Control-Allow-Methods","*"); //是否支持cookie跨域
		HttpSession session=req.getSession();
//		loger.info("开始进入preHandle");
		String reqUri=req.getRequestURI();
		loger.info("请求uri："+reqUri);
		return true;
//		loger.info("session:"+session.getAttribute("userName"));
//		if(!StringUtils.isEmpty(session.getAttribute("userName"))){
//			loger.info("用户已登录");
//			if(("/rzzc/user/login").equals(reqUri)){
//				loger.info("登录请求");
//				Map result=new HashMap();
//				result.put("name",session.getAttribute("userName"));
//				ResponseUtil.loginCheckMessage(resp,"000",result);
//				return false;
//			}else{
//				return true;
//			}
//		}else{
//			loger.info("用户未登录");
//			if(("/rzzc/user/login").equals(reqUri)){
//				loger.info("登录请求");
//				return true;
//			}else{
//				ResponseUtil.loginCheckMessage(resp,"700",null);
//				return false;
//			}
//		}
	}
	@Override
	public void postHandle(HttpServletRequest req,HttpServletResponse resp, Object handler, ModelAndView modelAndView){
//		请求处理之后，渲染之前调用
//		preHand为true调用，为false不调用
//		loger.info("开始进入postHandle");
//		HttpSession session=req.getSession();
		
//		loger.info("session2:"+session.getAttribute("userName"));
	}
	
	public void afterCompletion(HttpServletRequest req,HttpServletResponse resp){
//		渲染视图之后调用
		loger.info("开始进入afterCompletion");
	}
}
