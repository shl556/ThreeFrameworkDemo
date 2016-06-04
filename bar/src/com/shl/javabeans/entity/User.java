package com.shl.javabeans.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int userId; //用户ID
	private String lgName; //用户名
	private String lgPass; //密码
	private int sex; //性别
	private String nickName; //昵称
	private String headName; //头像
	private Date registerTime; //注册时间
	
	/**
	 * @param userId
	 * @param lgName
	 * @param lgPass
	 * @param sex
	 * @param nickName
	 * @param headName
	 * @param registerTime
	 */
	public User(int userId, String lgName, String lgPass, int sex,
			String nickName, String headName, Date registerTime) {
		super();
		this.userId = userId;
		this.lgName = lgName;
		this.lgPass = lgPass;
		this.sex = sex;
		this.nickName = nickName;
		this.headName = headName;
		this.registerTime = registerTime;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the lgName
	 */
	public String getLgName() {
		return lgName;
	}
	/**
	 * @param lgName the lgName to set
	 */
	public void setLgName(String lgName) {
		this.lgName = lgName;
	}
	/**
	 * @return the lgPass
	 */
	public String getLgPass() {
		return lgPass;
	}
	/**
	 * @param lgPass the lgPass to set
	 */
	public void setLgPass(String lgPass) {
		this.lgPass = lgPass;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the headName
	 */
	public String getHeadName() {
		return headName;
	}
	/**
	 * @param headName the headName to set
	 */
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	/**
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * @param registerTime the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
}
