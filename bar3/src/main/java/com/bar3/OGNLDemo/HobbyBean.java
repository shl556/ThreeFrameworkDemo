package com.bar3.OGNLDemo;

import java.io.Serializable;

public class HobbyBean implements Serializable{
	private static final long serialVersionUID = 1246637311503781270L;

	private int hobbyId;
	private String hobbyValue;
	
	public HobbyBean(int hobbyId, String hobbyValue) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyValue = hobbyValue;
	}
	
	public int getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	public String getHobbyValue() {
		return hobbyValue;
	}
	public void setHobbyValue(String hobbyValue) {
		this.hobbyValue = hobbyValue;
	}
}
