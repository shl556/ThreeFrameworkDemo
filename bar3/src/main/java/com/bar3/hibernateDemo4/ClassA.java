package com.bar3.hibernateDemo4;

// Generated 2016-2-10 19:40:41 by Hibernate Tools 4.3.1

/**
 * ClassA generated by hbm2java
 */
public class ClassA extends DOClass implements java.io.Serializable {

	private long id;
	private String a1;

	public ClassA() {
	}

	public ClassA(String a1) {
		this.a1 = a1;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getA1() {
		return this.a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

}
