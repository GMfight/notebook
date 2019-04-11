package com.notebook.common;

public class ConstParams {
	public static Integer SUPER_ADMIN_LEVEL=1;	//超级管理员层级
	public static Integer AREA_ADMIN_LEVEL=2;	//地区和一般管理员层级
		
	public static String VALID_USER_STATUS="000";	//合法用户状态码
	public static String INVALID_USER_STATUS="111";	//非法/不存在上用户状态码
	
	public static String USER_SESSIONKEY="userinfo";	//用户会话存储索引
	public static long VALID_SESSION_TIME=48*60*60*1000;
	
	public static String PLUS="plus";	//增加
	public static String Minus="minus";	//减少
	public static String HIDE="hide";	//隐藏
	public static int NO_VALUE=1;	//隐藏对应数据值
	public static String SHOW="show";	//显示
	public static int YES_VALUE=0;	//显示对应数据值
	
}
