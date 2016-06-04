package com.bar3.OGNLDemo;

import java.io.Serializable;

public class CityBean implements Serializable{
	private static final long serialVersionUID = -6562852059776509594L;
	
	private int cityId;
	private String cityValue;
	
	public CityBean(int cityId, String cityValue) {
		super();
		this.cityId = cityId;
		this.cityValue = cityValue;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityValue() {
		return cityValue;
	}
	public void setCityValue(String cityValue) {
		this.cityValue = cityValue;
	}
}
