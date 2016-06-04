package com.bar3.validate;

import com.opensymphony.xwork2.ActionSupport;

public class InnerValidatorAction extends ActionSupport {

	private int age;
	private String name;
	private int min1;
	private int max1;
	private int min2;
	private int max2;
	private double sal;
	private String email;
	private String url;
	private String mycode;
	private String myname;
	
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMycode() {
		return mycode;
	}
	public void setMycode(String mycode) {
		this.mycode = mycode;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public int getMin1() {
		return min1;
	}
	public void setMin1(int min1) {
		this.min1 = min1;
	}
	public int getMax1() {
		return max1;
	}
	public void setMax1(int max1) {
		this.max1 = max1;
	}
	public int getMin2() {
		return min2;
	}
	public void setMin2(int min2) {
		this.min2 = min2;
	}
	public int getMax2() {
		return max2;
	}
	public void setMax2(int max2) {
		this.max2 = max2;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
