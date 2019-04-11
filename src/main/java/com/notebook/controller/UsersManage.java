 package com.notebook.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.common.ConstParams;
import com.notebook.common.ResponseUtil;
import com.notebook.domain.User;
import com.notebook.serviceImpl.UserRecordServiceImpl;
import com.notebook.serviceImpl.UserServiceImpl;

@RestController
//@RequestMapping("/users")
public class UsersManage {
	private final Logger loger=LoggerFactory.getLogger(UsersManage.class);
	@Autowired UserServiceImpl userServiceImpl;
	@Autowired UserRecordServiceImpl userRecordServiceImpl;
//	获取区域所有用户
//		@CrossOrigin("http://localhost:8084")
//	@GetMapping(value="/test1")
//	public String getUser1(){
//		return "test successful1";
//	}
//	@PostMapping(value="/test2")
//	public String getUser2(){
//		return "test successful2";
//	}
//	获取对应账户，用户完整信息
	@GetMapping(value="/user/{accountId}")
	public Map getUser(@PathVariable(value="accountId")String accountId){
		return ResponseUtil.objMessage(userServiceImpl.getUser(accountId));
	}
//	根据id获取名下所有用户信息
	@GetMapping(value="/users/{accountId}")
	public Map getUsers(@PathVariable(value="accountId")String accountId) throws Exception{
		String userLayer=userServiceImpl.getUserLayer(accountId);
		if(userLayer==null||userLayer.length()<=0){
			loger.info("用户不存在");
			return ResponseUtil.userException("用户不存在");
		}else{
			if(userLayer.split(",").length<=ConstParams.SUPER_ADMIN_LEVEL){
				loger.info("超级管理员");
				List users=userServiceImpl.getUsersByAdmin(userLayer);
				return ResponseUtil.listMessage(users);
			}else{
				loger.info("一般管理员");
				List users=new ArrayList();
				if(userServiceImpl.checkIfAdmin(accountId)){
					users=userServiceImpl.getUsersByAdmin(userLayer.substring(0, userLayer.indexOf(",")));
				}
				return ResponseUtil.listMessage(users);
			}
		}
	}

	//	修改个人信息
	@PutMapping(value="/user/{accountId}")
	public Map updateUserInfo(@PathVariable(value="accountId")String accountId,Map userInfo){
		
		return userInfo;
	}

//	超级管理员修改其它管理员信息:禁用或启用
	@PutMapping(value="/user/modAdmin")
	public Map modAdmin(String accountId,boolean isAdmin){
		User userInfo=userServiceImpl.getUser(accountId);
		if(isAdmin){
			userInfo.setIsAdmin(ConstParams.YES_VALUE);
		}else{
			userInfo.setIsAdmin(ConstParams.NO_VALUE);
		}
		userServiceImpl.modUser(userInfo);
		return ResponseUtil.booleanMessage(true);
	}

//	新增用户
	@PostMapping(value="/user")
	public Map addUser(@RequestBody Map user){
		
		return null;
	}
//	批量新增用户
	@PostMapping(value="/users")
	public Map addBatchUsers(@RequestBody List<Map> users){
		return null;
		
	}
	
//	修改收藏
	@PutMapping(value="/user/updateStore")
	public Map modRecordStore(HttpServletRequest req, String method,String recordId){
		User userInfo=userServiceImpl.getUser(req.getSession().getAttribute(ConstParams.USER_SESSIONKEY).toString());
		int storeNum=userInfo.getStoreNum();
		if(ConstParams.PLUS.equals(method)){
			loger.info("增加收藏");
			storeNum++;
			userInfo.setStoreNum(storeNum);
			userRecordServiceImpl.addItem(userInfo.getAccountId(), recordId);
		}else if(ConstParams.Minus.equals(method)){
			loger.info("取消收藏");
			storeNum--;
			userInfo.setStoreNum(storeNum);
			userRecordServiceImpl.delItem(userInfo.getAccountId(), recordId);
		}
		userServiceImpl.modUser(userInfo);
		return ResponseUtil.booleanMessage(true);
	}

	@PostMapping(value="/login")
	public Map login(HttpServletRequest req,String accountId,String password){
		User userInfo=userServiceImpl.getUser(accountId);
		if(userServiceImpl.getUser(accountId)==null){
			return ResponseUtil.stringMessage("用户不存在");
		}
		String accountPwd=DigestUtils.md5DigestAsHex(password.getBytes());
		if(accountPwd!=userInfo.getPassword()){
			return ResponseUtil.stringMessage("用户名或密码异常");
		}
		loger.info("登陆成功");
		String lastIp=req.getRemoteHost();
		userInfo.setLastIp(lastIp);
		userInfo.setLastVisit(new Date());
//		存储用户会话信息
		HttpSession session=req.getSession();
		session.setAttribute(ConstParams.USER_SESSIONKEY, accountId);
		session.setMaxInactiveInterval(48);
		userServiceImpl.modUser(userInfo);
		return ResponseUtil.objMessage(userInfo);
	}
	@PostMapping(value="/register")
	public Map register(HttpServletRequest req,String accountId,String password,String areaId,String layer){
		if(userServiceImpl.getUser(accountId)!=null){
			return ResponseUtil.userException("用户已存在");
		}
		String accountPwd=DigestUtils.md5DigestAsHex(password.getBytes());
		User user=new User();
		user.setAccountId(accountId);
		user.setAccountName(accountId);
		user.setPassword(accountPwd);
		user.setAreaId(areaId);
		user.setLayer(layer);
		user.setLastIp(req.getRemoteHost());
		userServiceImpl.addUser(user);
		return ResponseUtil.booleanMessage(true);
	}
}
