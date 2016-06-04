package com.shl.javabeans.tools;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.shl.sql.BaseDao;
import com.shl.sql.QureyResult;

/**
 * @ClassName: UpdateReply
 * @Description: 回复的增，删，改等操作bean
 * @author: shl
 * @date: 2015-12-12 下午3:31:31
 */
public class UpdateReply implements Serializable{
	/**  
	 * @Fields userId : 用户ID(引用用户表的用户ID)
	 */  
	private int userId;
	/**  
	 * @Fields replyContent : 回帖内容
	 */  
	private String replyContent; 
	/**  
	 * @Fields postId : 主题id
	 */  
	private int postId;
	/**  
	 * @Fields replyId : 回帖id
	 */  
	private int replyId;
	/**
	 * @param replyId the replyId to set
	 */
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @param replyContent the replyContent to set
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	} 
	/**
	 * @Description 执行增加回帖的操作
	 * @return Int 数据库受影响的行数，若操作失败返回-1
	 * @throws Exception 
	 */
	public int getAddReply() throws Exception {
		String sql = "insert into weireply values(seq_replyid.nextval,?,?,default,default,?)";
		int doupdate = -1;
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(
				userId, replyContent, postId));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	/**
	 * @Description 执行修改回复操作
	 * @return int 返回数据库受影响的行数，若操作失败返回-1
	 * @throws Exception   
	 */
	public int getUpdateReply() throws Exception{
		String sql ="update weireply a set a.replycontent =?,a.modifytime= default where a.replyid=?";
		int doupdate =-1;
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(
				replyContent,replyId));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	/**
	 * @Description 执行删除回复操作
	 * @return int 返回数据库受影响的行数，若操作失败返回-1
	 * @throws Exception   
	 */
	public int getDeleteReply() throws Exception{
		String sql ="delete from weireply a where a.replyid=?";
		int doupdate =-1;
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(replyId));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	/**
	 * @Description 根据replyid查找回复内容
	 * @return String 回复内容
	 * @throws Exception   
	 */
	public String getReplyContent() throws Exception{
		String sql ="select a.replycontent from weireply a where a.replyid=?";
		ArrayList<Object> paramList=new ArrayList<Object>();
		String replyContent =null;
		paramList.add(this.replyId);
		QureyResult result=null;
		ResultSet res =null;
		try{
			result=BaseDao.doQueuy(sql, paramList);
			res=result.getResultSet();
			if(res.next()){
			replyContent=res.getString(1);
			}
		}finally{
			res.close();
			result.getConnection().close();
		}
		return replyContent;
	}
}
