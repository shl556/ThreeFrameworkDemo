package com.shl.javabeans.entity;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable{
	private int postid; //帖子ID
	private int userId; //用户ID(引用用户表的用户ID)
	private String nickname;//用户昵称
	private String title; //标题
	private String postContent; //内容
	private Date createTime; //发帖时间
	private Date modifyTime; //修改时间
	private int kindId; //分类ID（引用分类表的分类ID）
	
	/**
	 * 
	 */
	public Post() {
		super();
	}

	/**
	 * @param postId
	 * @param userId
	 * @param title
	 * @param postContent
	 * @param createTime
	 * @param modifyTime
	 * @param kindId
	 */
	public Post(int postId, int userId, String title, String postContent,
			Date createTime, Date modifyTime, int kindId) {
		super();
		this.postid = postId;
		this.userId = userId;
		this.title = title;
		this.postContent = postContent;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.kindId = kindId;
	}
   
	/**
	 * @param postId
	 * @param userId
	 * @param nickname
	 * @param title
	 * @param modifyTime
	 */
	public Post(int postId, int userId, String nickname, String title,
			Date modifyTime) {
		super();
		this.postid = postId;
		this.userId = userId;
		this.nickname = nickname;
		this.title = title;
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the postId
	 */
	public int getPostid() {
		return postid;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostid(int postId) {
		this.postid = postId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the postContent
	 */
	public String getPostContent() {
		return postContent;
	}
	/**
	 * @param postContent the postContent to set
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the kindId
	 */
	public int getKindId() {
		return kindId;
	}
	/**
	 * @param kindId the kindId to set
	 */
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	
}
