package com.bar3.domain.annonation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="airports")
public class Airport {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(length=10)
   private long id;
   @Column(length=50,name="airport_name",nullable=false)
   private String name;
   @Column(length=50,name="city_name",nullable=false)
   private String cityName;
   
   
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
   
   
}
