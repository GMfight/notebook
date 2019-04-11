package com.notebook.service;

import java.util.List;
import java.util.Map;

import com.notebook.domain.User;

public interface UserService {
	
	String getUserLayer(String id);
	
	boolean checkIfAdmin(String accountId);
//	获取所有用户
	List<User> getUsersByAdmin(String layer);
	
	User getUser(String accountId);
	
	boolean addUser(User user);
	
	boolean modUser(User user);

}
