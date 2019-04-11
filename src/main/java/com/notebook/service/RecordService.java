package com.notebook.service;

import java.util.List;

import com.notebook.domain.Record;

public interface RecordService {
	Record addRecord(String accountId,String content,List<String> imgList,String address);
	
	boolean modRecord(String recordId,String method);
//	删除记录
	boolean delRecord(String recordId);
	
	Record getRecordById(String recordId);
}
