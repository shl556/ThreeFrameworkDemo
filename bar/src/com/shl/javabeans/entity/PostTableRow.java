
package com.shl.javabeans.entity;

import java.io.Serializable;

/**
 * @ClassName: PostTableRow
 * @Description:用于保存论坛主题汇总表的单行（即每个主题）信息的bean
 * @author: shl
 * @date: 2015-12-12 上午10:14:47
 */
public class PostTableRow implements Serializable{
    /**  
     * @Fields postid :主题id
     */  
    private int postid;
    /**  
     * @Fields title : 主题标题
     */  
    private String title;
    /**  
     * @Fields nickname :发表该主题的用户昵称 
     */  
    private String nickname;
   
	/**  
     * @Fields replysum : 该主题的回复总数
     */  
    private int replysum;
    /**
   	 * @param postid
   	 * @param title
   	 * @param nickname
   	 * @param replysum
   	 */
   	public PostTableRow(int postid, String title, String nickname, int replysum) {
   		super();
   		this.postid = postid;
   		this.title = title;
   		this.nickname = nickname;
   		this.replysum = replysum;
   	}
	/**
	 * @return the postid
	 */
	public int getPostid() {
		return postid;
	}
	/**
	 * @param postid the postid to set
	 */
	public void setPostid(int postid) {
		this.postid = postid;
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
	 * @return the replysum
	 */
	public int getReplysum() {
		return replysum;
	}
	/**
	 * @param replysum the replysum to set
	 */
	public void setReplysum(int replysum) {
		this.replysum = replysum;
	}
   	
    
}
