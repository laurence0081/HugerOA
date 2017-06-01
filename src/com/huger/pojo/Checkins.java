package com.huger.pojo;

import com.huger.user.util.PageParameter;

public class Checkins {
	Integer id;
	Integer userId;
	String realname;
	String signTime;
	String imgURL;
	String cellphone;
	String description;
	String imgURLEX;
	String location;
	Integer longitude;
	Integer latitude;
	Integer type;
	Integer department;
	Integer projectId;
	String projectName;
	Integer customerId;
	String customerName;
	
	public PageParameter page;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSignTime() {
		return signTime;
	}
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgURLEX() {
		return imgURLEX;
	}
	public void setImgURLEX(String imgURLEX) {
		this.imgURLEX = imgURLEX;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	
	public String toString(){
		String result = "{\"id\":\""+id+"\",\"userId\":\""+userId+"\",\"realname\":\""+
	    realname+"\",\"signTime\":\""+signTime+"\",\"cellphone\":\""+cellphone+"\"imgURL\":\""+
		imgURL+"\",\"description\":\""+description+"\",\"imgURLEX\":\""+imgURLEX +
		"\",\"location\":\""+location+"\",\"longitude\":\""+longitude+"\",\"type\":\""+type+
		"\",\"projectId\":\""+projectId+"\",\"projectName\":\""+projectName+"\",\"customerId\":\""+customerId +
		"\",\"customerName\":\""+customerName+"\",\"department\":\""+department+"\"}";
		
		return result;
	}
}
