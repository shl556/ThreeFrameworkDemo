package com.shl.javabeans.tools;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.shl.sql.BaseDao;
import com.shl.sql.QureyResult;

/**
 * @ClassName: UpdatePost
 * @Description: 主题增，删，改的操作bean
 * @author: shl
 * @date: 2015-12-12 下午3:55:37
 */
public class UpdatePost {
	/**
	 * @Fields userid : 用户id
	 */
	private int userid;
	/**
	 * @Fields title : 标题
	 */
	private String title;
	/**
	 * @Fields content : 内容
	 */
	private String content;
	/**
	 * @Fields kindid : 版块id
	 */
	private int kindid;
	/**
	 * @Fields postid : 主题id
	 */
	private int postid;

	/**
	 * @param postid
	 *            the postid to set
	 */
	public void setPostid(int postid) {
		this.postid = postid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param kindid
	 *            the kindid to set
	 */
	public void setKindid(int kindid) {
		this.kindid = kindid;
	}

	/**
	 * @Description 执行增加主题操作
	 * @return int 数据库受影响的行数，若失败返回-1
	 * @throws Exception
	 */
	public int getAddPost() throws Exception {
		String sql = "insert into weipost values(seq_postid.nextval,?,?,?,default,default,?)";
		int doupdate = -1;
//		java.util.Date utildate = new java.util.Date();
//		java.sql.Date sqlDate = new java.sql.Date(utildate.getTime());
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(
				userid, title, content, kindid));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	/**
	 * @Description 执行修改主题操作
	 * @return int 数据库受影响的行数，若失败返回-1
	 * @throws Exception   
	 */
	public int getUpdatePost() throws Exception {
		String sql = "update weipost a set a.title = ?,a.postcontent= ?,a.modifytime= default where a.postid=?";
		int doupdate = -1;
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(
				title,content,postid));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	/**
	 * @Description 执行删除主题操作，主题下的回复也会被删除
	 * @return int 数据库受影响的行数，若失败返回-1
	 * @throws Exception   
	 */
	public int getDeletePost() throws Exception {
		String sql = "delete weireply a where a.postid=?";
		int doupdate = -1;
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(postid));
		doupdate = BaseDao.doUpdate(sql, paramList);
		sql="delete weipost a where a.postid=?";
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
	}
	
	/**
	 * @Description 根据postID查找主题的标题和内容
	 * @return String[] 返回有标题和内容组成的数组
	 * @throws Exception   
	 */
	public String[] getPostContent() throws Exception{
		String sql ="select a.title,a.postcontent from weipost a where a.postid=?";
		ArrayList<Object> paramList=new ArrayList<Object>();
		String[] replyContent =new String[2];
		paramList.add(this.postid);
		QureyResult result=null;
		ResultSet res =null;
		try{
			result=BaseDao.doQueuy(sql, paramList);
			res=result.getResultSet();
			if(res.next()){
			replyContent[0]=res.getString(1);
			replyContent[1]=res.getString(2);
			}
		}finally{
			res.close();
			result.getConnection().close();
		}
		return replyContent;
	}
}
