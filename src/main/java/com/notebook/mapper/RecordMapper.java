package com.notebook.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.notebook.domain.Record;

@Mapper
public interface RecordMapper {
	@Select("select * from records where recordId=#{recordId}")
	Record getRecordById(String recordId);
//	创建记录
	@Insert("inser into record(cguid,recordId,userId,content,agreeNum,cTime,cAddress,cTheme,imgList) values()")
	void createRecord(Record record);
	
//	修改记录（点赞数）
	@Update("")
	void modRecord(Record record);
	
//	删除记录
	@Delete("")
	void delRecord(String recordId);
}
