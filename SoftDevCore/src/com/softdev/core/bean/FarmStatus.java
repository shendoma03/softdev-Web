package com.softdev.core.bean;

import java.util.Date;

public class FarmStatus {
	private int farmStatusId;
	private double analogSmlvl;
	private String smlvl;
	private String wlvl;
	private double temp;
	private String createUser;
	private Date createDate;
	
	public int getFarmStatusId() {
		return farmStatusId;
	}
	public void setFarmStatusId(int farmStatusId) {
		this.farmStatusId = farmStatusId;
	}
	public double getAnalogSmlvl() {
		return analogSmlvl;
	}
	public void setAnalogSmlvl(double analogSmlvl) {
		this.analogSmlvl = analogSmlvl;
	}
	public String getSmlvl() {
		return smlvl;
	}
	public void setSmlvl(String smlvl) {
		this.smlvl = smlvl;
	}
	public String getWlvl() {
		return wlvl;
	}
	public void setWlvl(String wlvl) {
		this.wlvl = wlvl;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
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
