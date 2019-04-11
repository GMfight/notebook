package com.notebook.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.domain.User;
import com.notebook.mapper.FuncMapper;
import com.notebook.service.FuncService;

@Service
public class FuncServiceImpl implements FuncService{
	@Autowired
	private FuncMapper funcMapper;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return funcMapper.getAll();
	}

}
