package com.softdev.core.bean;

import java.util.Date;

public class FarmOperation {
	private int farmOperationId;
	private String status;
	private String create_user;
	private Date create_date;
	
	public int getFarmOperationId() {
		return farmOperationId;
	}
	public void setFarmOperationId(int farmOperationId) {
		this.farmOperationId = farmOperationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	

}
