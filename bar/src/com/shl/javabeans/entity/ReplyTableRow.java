package com.shl.javabeans.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: ReplyTableRow
 * @Description:
 * @author: shl
 * @date: 2015-12-13 下午8:41:28
 */
public class ReplyTableRow implements Serializable {
	/**
	 * @Fields userid :用户id
	 */
	private int userid;
	/**
	 * @Fields nickname :用户昵称
	 */
	private String nickname;
	/**
	 * @Fields headname : 用户头像文件名
	 */
	private String headname;
	/**
	 * @Fields registerTime : 用户注册时间
	 */
	private Date registerTime;
	/**  
	 * @Fields replyid : 回复id
	 */  
	private int replyid;
	/**
	 * @Fields content : 回复内容
	 */
	private String content;
	/**
	 * @Fields createTime : 回复发表时间
	 */
	private Date createTime;
	/**
	 * @Fields modifyTime : 回复修改时间
	 */
	private Date modifyTime;

	
	/**
	 * @param userid
	 * @param nickname
	 * @param headname
	 * @param registerTime
	 * @param replyid
	 * @param title
	 * @param content
	 * @param createTime
	 * @param modifyTime
	 */
	public ReplyTableRow(int userid, String nickname, String headname,
			Date registerTime, int replyid, String content,
			java.util.Date createTime, Date modifyTime) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.headname = headname;
		this.registerTime = registerTime;
		this.replyid = replyid;
		this.content = content;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the replyid
	 */
	public int getReplyid() {
		return replyid;
	}

	/**
	 * @param replyid the replyid to set
	 */
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the headname
	 */
	public String getHeadname() {
		return headname;
	}

	/**
	 * @param headname
	 *            the headname to set
	 */
	public void setHeadname(String headname) {
		this.headname = headname;
	}

	/**
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
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
	 * @param modifyTime
	 *            the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
