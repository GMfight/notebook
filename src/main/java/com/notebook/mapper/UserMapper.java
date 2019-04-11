package com.notebook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.notebook.domain.User;

@Mapper
public interface UserMapper {
	@Select("select l.layer from users l where l.accountId=#{id}")
	String getUserLayer(String id);
	
	@Select("select l.isAdmin from users l where l.accountId=#{accountId}")
	int checkIfAdmin(String accountId);
	
	@Select("select * from user l where l.layer like")
	List<User> getUsersByAdmin(String layer);
	
	@Select("select * from user l where l.accountId=#{accountId}")
	User getUser(String accountId);
	
	@Insert("")
	boolean addUser(User user);
	
	@Update("")
	boolean modUser(User user);
}
