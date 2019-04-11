package com.notebook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.common.ConstParams;
import com.notebook.common.ResponseUtil;
import com.notebook.domain.Record;
import com.notebook.serviceImpl.RecordServiceImpl;
import com.notebook.serviceImpl.UserRecordServiceImpl;


@RestController
public class RecordsManager {
	private final Logger loger=LoggerFactory.getLogger(RecordsManager.class);
	@Autowired RecordServiceImpl recordServiceImpl;
	@Autowired UserRecordServiceImpl userRecordServiceImpl;
	
	@PostMapping(value="/record")
	public Map addRecord(HttpServletRequest req,String content,List imgList){
		String accountId=(String) req.getSession().getAttribute(ConstParams.USER_SESSIONKEY);
		String address="";
		recordServiceImpl.addRecord(accountId, content, imgList, address);	
		return ResponseUtil.booleanMessage(true);	
	}
	
	@PutMapping(value="/record")
	public Map modRecord(String recordId,String method){
		recordServiceImpl.modRecord(recordId, method);
		return ResponseUtil.booleanMessage(true);
	}
	@GetMapping(value="/record/{recordId}")
	public Map getRecordById(@PathVariable(value="recordId")String recordId){
		return ResponseUtil.objMessage(recordServiceImpl.getRecordById(recordId));
	}
}
