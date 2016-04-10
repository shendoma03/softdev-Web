package com.softdev.core.bean;

public class Farm {

	private int farmId;
	private String name;
	private String location;
	private double total_land_area;
	private int no_section;
	
	
	public int getFarmId() {
		return farmId;
	}
	public void setFarmId(int farmId) {
		this.farmId = farmId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getTotal_land_area() {
		return total_land_area;
	}
	public void setTotal_land_area(double total_land_area) {
		this.total_land_area = total_land_area;
	}
	public int getNo_section() {
		return no_section;
	}
	public void setNo_section(int no_section) {
		this.no_section = no_section;
	}
	
}
