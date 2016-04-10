package com.softdev.core.bean;

import java.util.Date;

public class SprinklerRequest {
	private int sprinklerId;
	private boolean operation;
	private String status;
	private String createUser;
	private Date createDate;

	public SprinklerRequest() {
	}
	
	public int getSprinklerId() {
		return sprinklerId;
	}

	public void setSprinklerId(int sprinklerId) {
		this.sprinklerId = sprinklerId;
	}

	public boolean isOperation() {
		return operation;
	}

	public void setOperation(boolean operation) {
		this.operation = operation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
