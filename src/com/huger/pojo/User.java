package com.huger.pojo;

import com.huger.user.util.PageParameter;

public class User {
	Integer id;
	String password;
	String imgURL;
	Integer sex;
	String cellphone;
	String realname;
	String jobtitle;
	Integer group;
	Integer type;
	public PageParameter page;

	public User(){
		realname = "未设置";
		imgURL = "http://101.201.43.202:20161/default.jpg";
		sex = 0;
		cellphone = "未设置";
	}


	public Integer getGroup() {
		return group;
	}
	public void setGroup(Integer group) {
		this.group = group;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}

	public String toString(){
		String result ="";
		String sexStr = "女";
		if(sex == 1 ) sexStr = "男";
		result = "{\"id\":\""+id+"\",\"password\":\""+password+"\",\"imgURL\":\""+imgURL+"\",\"sex\":\""+sexStr+"\","
				+"\"cellphone\":\""+cellphone+"\"realname\":\""+realname+"\",\"jobtitle\":\""+jobtitle+"\",\"type\":\""+type +"\"}";
		
		return result;
	}
}
