package com.shl.javabeans.entity;

import java.io.Serializable;

public class Kind implements Serializable{
	private int kindid; //分类ID
	private String kindName; //分类名称
	private int parentKindId; //父分类ID
	
	/**
	 * 
	 */
	public Kind() {
		super();
	}
	/**
	 * @param kindId
	 * @param kindName
	 * @param parentKindId
	 */
	public Kind(int kindId, String kindName, int parentKindId) {
		super();
		this.kindid = kindId;
		this.kindName = kindName;
		this.parentKindId = parentKindId;
	}
	/**
	 * @return the kindId
	 */
	public int getKindid() {
		return kindid;
	}
	/**
	 * @param kindId the kindId to set
	 */
	public void setKindid(int kindId) {
		this.kindid = kindId;
	}
	/**
	 * @return the kindName
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * @param kindName the kindName to set
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * @return the parentKindId
	 */
	public int getParentKindId() {
		return parentKindId;
	}
	/**
	 * @param parentKindId the parentKindId to set
	 */
	public void setParentKindId(int parentKindId) {
		this.parentKindId = parentKindId;
	}
//	@Override
//	public int compareTo(Kind o) {
//		return this.kindId-o.getKindId();
//	}	
}
