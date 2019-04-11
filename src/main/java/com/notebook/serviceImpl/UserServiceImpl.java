package com.notebook.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.domain.User;
import com.notebook.mapper.UserMapper;
import com.notebook.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private final Logger loger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public String getUserLayer(String id) {
		// TODO Auto-generated method stub
		return userMapper.getUserLayer(id);
	}

	@Override
	public boolean checkIfAdmin(String accountId) {
		// TODO Auto-generated method stub
		if(userMapper.checkIfAdmin(accountId)==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<User> getUsersByAdmin(String layer) {
		return userMapper.getUsersByAdmin(layer);
	}

	@Override
	public User getUser(String accountId) {
		// TODO Auto-generated method stub
		return userMapper.getUser(accountId);
	}

	@Override
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public boolean modUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.modUser(user);
	}
	
//	@Override
//	public Map checkUser(String id,String pwd){
//		User user=userMapper.getUserById(id);
//		Map result=new HashMap();
//		if(user==null){
////			loger.info("库里用户不存在");
//			result.put("code",1);
//			result.put("msg","用户不存在");
//			return result;
//		}
//		String inPwd=DigestUtils.md5DigestAsHex(pwd.getBytes());
////		loger.info("用户输入密码："+inPwd);
//		if(inPwd.equals(user.getPwd())){
////			loger.info("用户输入信息合法");
//			result.put("code","0");
//			result.put("msg","登录成功");
//			result.put("name",user.getAccountName());
//			return result;
//		}else{
////			loger.info("账户或密码错误");
//			result.put("code",2);
//			result.put("msg","账户或密码错误");
//			return result;
//		}
//	}
	
	

}
