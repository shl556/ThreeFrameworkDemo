package com.bar3.OGNLDemo;

import java.io.Serializable;

public class SexBean implements Serializable{
	private static final long serialVersionUID = 7820499326290406687L;
	
	private int sexId;
	private String sexValue;

	public SexBean(int sexId, String sexValue) {
		super();
		this.sexId = sexId;
		this.sexValue = sexValue;
	}
	
	public int getSexId() {
		return sexId;
	}
	public void setSexId(int sexId) {
		this.sexId = sexId;
	}
	public String getSexValue() {
		return sexValue;
	}
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
}
