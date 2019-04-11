package com.notebook.common;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class ResponseUtil {
	public static void sendStrMessage(HttpServletResponse resp,String str) throws Exception{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer=resp.getWriter();
		writer.print(str);
//		writer.close();
//		resp.flushBuffer();
	}
//	是否登录，登录是否成功的返回
	public static void loginCheckMessage(HttpServletResponse resp,String status,Map map) throws Exception{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer=resp.getWriter();
		Map result=new HashMap();
		result.put("status", status);
		result.put("data", map);
		writer.print(JSON.toJSONString(result));
		writer.close();
	}
	public static Map refactResponse(){
		return null;
	}
//	未登录用户返回
	
//	接收参数类型不同
	public static Map stringMessage(String str){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", str);
		return result;
	}
	public static Map booleanMessage(Boolean bo){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", bo);
		return result;
	}
	public static Map listMessage(List list){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", list);
		return result;
	}
	public static Map mapMessage(Map map){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", map);
		return result;
	}
	public static Map objMessage(Object obj){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", obj);
		return result;
	}
//	用户异常
	public static Map userException(String message){
		Map result=new HashMap();
		result.put("status", ConstParams.INVALID_USER_STATUS);
		result.put("retMsg", "非法用户");
		return result;
	}
//	权限异常
	public static Map permissionException(String message){
		Map result=new HashMap();
		result.put("status", ConstParams.INVALID_USER_STATUS);
		result.put("retMsg", message);
		return result;
	}
//	后台程序异常
	public static Map processException(String message){
		Map result=new HashMap();
		result.put("status", ConstParams.VALID_USER_STATUS);
		result.put("retMsg", "后台异常，请联系开发人员");
		return result;
	}
	
}
