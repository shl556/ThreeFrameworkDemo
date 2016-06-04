package com.bar3.validate;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class VisitorListAction extends ActionSupport {

	private List<User> userlist;

	@Override
	public String execute() throws Exception {
		System.out.println("1");
		return super.execute();
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	
	
}
