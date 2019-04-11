package com.notebook.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notebook.common.ConstParams;
import com.notebook.domain.Record;
import com.notebook.mapper.RecordMapper;
import com.notebook.service.RecordService;
@Service
public class RecordServiceImpl implements RecordService{
	@Autowired RecordMapper recordMapper;
	@Override
	public boolean delRecord(String recordId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Record addRecord(String accountId, String content,
			List<String> imgList, String address) {
		// TODO Auto-generated method stub
		Record record=new Record();
		record.setUserId(accountId);
		record.setrContent(content);
		record.setrAddress(address);
		String imgStr="";
		if(imgList!=null&&imgList.size()>0){
			for(int i=0;i<imgList.size();i++){
				imgStr=imgStr+","+imgList.get(i);
			}
		}
		record.setrImgList(imgStr);
		recordMapper.createRecord(record);
		return null;
	}

	@Override
	public boolean modRecord(String recordId, String method) {
		// TODO Auto-generated method stub
		Record record=recordMapper.getRecordById(recordId);
		if(ConstParams.HIDE.equals(method)){
//			隐藏记录
//			record.setrShow(ConstParams.HIDE_VALUE);
		}else{
//			显示记录
//			record.setrShow(ConstParams.SHOW_VALUE);
		}
		recordMapper.modRecord(record);
		return true;
	}

	@Override
	public Record getRecordById(String recordId) {
		return recordMapper.getRecordById(recordId);
		
	}

}
