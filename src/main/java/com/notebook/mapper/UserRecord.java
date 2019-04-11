package com.notebook.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserRecord {
	@Insert("")
	public void addItem(String accountId,String recordId,String cguid);
	
	@Delete("")
	public void delItem(String accountId,String recordId);
}
