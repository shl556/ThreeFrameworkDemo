package com.bar3.OGNLDemo;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{
	private static final long serialVersionUID = -5808037703808170288L;
	
	private int userId;   //编号
	private String userName; //姓名
	private String password; //密码
	private Date birthday = new Date(); //生日：格式yyyy-MM-dd,默认为当前时间
	private int sex;   //性别：0男，1女
	private int[] hobby; //爱好,数组
	private int city; //所属 城市
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int[] getHobby() {
		return hobby;
	}
	public void setHobby(int[] hobby) {
		this.hobby = hobby;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
}
