package com.notebook.domain;

import java.io.Serializable;

public class Func implements Serializable{

//	用户id，账号
	private String id;
//	用户名称
	private String name;
//	上级服务单位账号
	private String parent_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	//	密码
	private String pwd;

}
