package com.bar3.hibernateDemo4;

// Generated 2016-2-10 19:40:41 by Hibernate Tools 4.3.1

/**
 * ClassB generated by hbm2java
 */
public class ClassB extends DOClass implements java.io.Serializable {

	private long id;
	private String b1;

	public ClassB() {
	}

	public ClassB(String b1) {
		this.b1 = b1;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getB1() {
		return this.b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

}
