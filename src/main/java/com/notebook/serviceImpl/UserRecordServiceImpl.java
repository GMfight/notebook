package com.notebook.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.mapper.UserRecord;
import com.notebook.service.UserRecordService;
@Service
public class UserRecordServiceImpl implements UserRecordService{

	@Autowired
	private UserRecord userRecordMapper;
	@Override
	public void addItem(String accountId, String recordId) {
		String cguid=new Date().getTime()+accountId+recordId;
		userRecordMapper.addItem(accountId, recordId, cguid);
	}

	@Override
	public void delItem(String accountId, String recordId) {
		userRecordMapper.delItem(accountId, recordId);
	}

}
