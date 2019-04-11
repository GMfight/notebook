package com.notebook.controller;
//package com.htxx.rzzc.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.htxx.rzzc.common.ResponseUtil;
//import com.htxx.rzzc.domain.User;
//import com.htxx.rzzc.serviceImpl.UserServiceImpl;
////用户信息管理
//@RestController
//@RequestMapping("/user")
//public class UserInfoManage {
//	private final Logger loger=LoggerFactory.getLogger(UserInfoManage.class);
//	@Autowired UserServiceImpl userServiceImpl;
//	
//	@GetMapping(value="/allUser")
//	public Map getAll(HttpSession session,HttpServletResponse resp,String id){
//		loger.info("get all user info");
//		loger.info("id:"+id);
////		loger.info("用户session:"+session.getAttribute("userName"));
//		List<User> userList=userServiceImpl.getAll();
//		return ResponseUtil.listMessage(userList);
//	}
////	@CrossOrigin("http://localhost:8084")
//	@PostMapping(value="/login")
//	public void checkUser(HttpSession session,HttpServletResponse resp,String id,String pwd) throws Exception{
//		Map checkResult=new HashMap();
//		checkResult=userServiceImpl.checkUser(id, pwd);
//		if("0".equals(checkResult.get("code"))){
//			session.setAttribute("userName",checkResult.get("name"));
//			loger.info("login success："+session.getAttribute("userName"));
//			ResponseUtil.loginCheckMessage(resp,"000",checkResult);
//		}else{
//			ResponseUtil.loginCheckMessage(resp,"700",checkResult);
//		}
//	}
//	
//	@GetMapping(value="/checkUserId")
//	public Map checkUserId(HttpServletResponse resp,String id){
//		loger.info("校验用户id:"+id);
//		Map res=new HashMap();
//		return ResponseUtil.stringMessage(userServiceImpl.getUserById(id)+"");
//		
//	}
//	@GetMapping(value="/checkUserName")
//	public Map checkUserName(HttpServletResponse resp,String name){
//		loger.info("校验用户name:"+name);
//		Map res=new HashMap();
//		return ResponseUtil.stringMessage(userServiceImpl.getUserByName(name)+"");
//		
//	}
//	
//	@PostMapping(value="/addUser")
//	public boolean addUser(User user){
//		loger.info("add user=====");
//		return false;
//	}
//	
//	@PostMapping(value="/modUser")
//	public boolean modUser(User user){
//		loger.info("mod user=====");
//		return false;
//	}
//	
//	@PostMapping(value="/delUser")
//	public boolean delUser(String id){
//		loger.info("del user=====");
//		return false;
//	}
//	
//	@PostMapping(value="/exit")
//	public boolean Exit(HttpSession session,HttpServletResponse resp,String id) throws Exception{
//		loger.info("exit user=====");
//		session.invalidate();
//		ResponseUtil.loginCheckMessage(resp,"700",null);
//		return false;
//	}
//}
