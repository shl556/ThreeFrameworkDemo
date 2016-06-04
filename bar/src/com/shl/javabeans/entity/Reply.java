package com.shl.javabeans.entity;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
	private int replyId; //回帖ID
	private int userId; //用户ID(引用用户表的用户ID)
	private String replyContent; //内容
	private Date createTime; //回帖时间
	private Date modifyTime; //修改时间
	private int postId; //主贴ID（引用帖子表的帖子ID）
	/**
	 * @param replyId
	 * @param userId
	 * @param replyContent
	 * @param createTime
	 * @param modifyTime
	 * @param postId
	 */
	public Reply(int replyId, int userId, String replyContent, Date createTime,
			Date modifyTime, int postId) {
		super();
		this.replyId = replyId;
		this.userId = userId;
		this.replyContent = replyContent;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.postId = postId;
	}
	/**
	 * @return the replyId
	 */
	public int getReplyId() {
		return replyId;
	}
	/**
	 * @param replyId the replyId to set
	 */
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	 * @return the replyContent
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * @param replyContent the replyContent to set
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
}
