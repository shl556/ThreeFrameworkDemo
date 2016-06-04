package com.bar3.validate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.ValidationInterceptor;

public class UserAction extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行execute方法");
		return SUCCESS;
	}
	
	
}
