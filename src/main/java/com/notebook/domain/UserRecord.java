package com.notebook.domain;

import java.io.Serializable;

public class UserRecord implements Serializable{
	private String cguid;
	private String recordId;
	private String userId;
	public String getCguid() {
		return cguid;
	}
	public void setCguid(String cguid) {
		this.cguid = cguid;
	}
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
}
