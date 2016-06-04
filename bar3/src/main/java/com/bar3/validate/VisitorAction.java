package com.bar3.validate;

import com.opensymphony.xwork2.ActionSupport;

public class VisitorAction  extends ActionSupport{

	private User user;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
