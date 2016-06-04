package com.bar3.domain;


import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


/**
* @ClassName: Post
* @Description: 表示主题的实体类
* @author shl
* @date 2016年2月12日 下午8:16:02
*/
@Entity
public class Post implements java.io.Serializable {

	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = 5915199248510175385L;
	/**
	* @Fields Id :主题id 
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	/**
	* @Fields version :版本控制 
	*/
	@Version
	private Integer version;
	/**
	* @Fields title : 主题标题
	*/
	private String title;
	/**
	* @Fields postContent :主题内容 
	*/
	private String postContent;
	/**
	* @Fields createTime :发表时间 
	*/
	private Date createTime;
	/**
	* @Fields modifyTime :最后修改时间 
	*/
	private Date modifyTime;
	/**
	* @Fields replys : 该主题的所有回复
	*/
	private Set<Reply> replys=new TreeSet<Reply>();
	/**
	* @Fields replySum : 该主题下的回复总数
	*/
	private Integer replySum;
	/**
	* @Fields kind :该主题所属的版块 
	*/
	private Kind kind;
	/**
	* @Fields user :发表该主题的用户 
	*/
	private User user;

	public Post() {
	}

	public Post(String title, Kind kind, User user) {
		this.title = title;
		this.kind = kind;
		this.user = user;
	}

	public Post(String title, String postContent, Date createTime, Date modifyTime, Kind kind, User user) {
		this.title = title;
		this.postContent = postContent;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.kind = kind;
		this.user = user;
	}
    
	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostContent() {
		return this.postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getReplySum() {
		return this.replySum;
	}

	public void setReplySum(Integer replySum) {
		this.replySum = replySum;
	}

	public Kind getKind() {
		return this.kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("Id").append("='").append(getId()).append("' ");
		buffer.append("title").append("='").append(getTitle()).append("' ");
		buffer.append("postContent").append("='").append(getPostContent()).append("' ");
		buffer.append("createTime").append("='").append(getCreateTime()).append("' ");
		buffer.append("modifyTime").append("='").append(getModifyTime()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
