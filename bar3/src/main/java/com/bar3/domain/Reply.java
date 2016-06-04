package com.bar3.domain;


import java.util.Date;

/**
* @ClassName: Reply
* @Description:表示回复的实体类 
* @author shl
* @date 2016年2月12日 下午8:16:43
*/
public class Reply implements java.io.Serializable {

	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = -58649447409198285L;
	/**
	* @Fields Id :回复id 
	*/
	private long Id;
	/**
	* @Fields version :版本控制 
	*/
	private Integer version;
	/**
	* @Fields replyContent : 回复内容
	*/
	private String replyContent;
	/**
	* @Fields creatTime :创建时间 
	*/
	private Date creatTime;
	/**
	* @Fields modifyTime :修改时间 
	*/
	private Date modifyTime;
	/**
	* @Fields user :发表回复的用户 
	*/
	private User user;
	/**
	* @Fields post :该回复的主题 
	*/
	private Post post;

	public Reply() {
	}

	public Reply(User user, Post post) {
		this.user = user;
		this.post = post;
	}

	public Reply(String replyContent, Date creatTime, Date modifyTime, User user, Post post) {
		this.replyContent = replyContent;
		this.creatTime = creatTime;
		this.modifyTime = modifyTime;
		this.user = user;
		this.post = post;
	}

	public long getId() {
		return this.Id;
	}

	private void setId(long Id) {
		this.Id = Id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("Id").append("='").append(getId()).append("' ");
		buffer.append("replyContent").append("='").append(getReplyContent()).append("' ");
		buffer.append("creatTime").append("='").append(getCreatTime()).append("' ");
		buffer.append("modifyTime").append("='").append(getModifyTime()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
