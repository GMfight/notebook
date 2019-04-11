package com.notebook.domain;

import java.util.Date;
import java.util.List;

public class Record {
//	记录索引/id
	private String recordId;
//	发布用户
	private String userId;
//	记录内容
	private String rContent;
//	点赞数
	private String rAgreeNum;
//	创建时间
	private Date rTime;
//	创建地点
	private String rAddress;
//	主题
	private int rTheme;
//	图片列表
	private String rImgList;
//	是否显示 0显示 1隐藏
	private int rShow;
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrAgreeNum() {
		return rAgreeNum;
	}
	public void setrAgreeNum(String rAgreeNum) {
		this.rAgreeNum = rAgreeNum;
	}
	public Date getrTime() {
		return rTime;
	}
	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public int getrTheme() {
		return rTheme;
	}
	public void setrTheme(int rTheme) {
		this.rTheme = rTheme;
	}
	public String getrImgList() {
		return rImgList;
	}
	public void setrImgList(String rImgList) {
		this.rImgList = rImgList;
	}
	public int getrShow() {
		return rShow;
	}
	public void setrShow(int rShow) {
		this.rShow = rShow;
	} 
	
}
