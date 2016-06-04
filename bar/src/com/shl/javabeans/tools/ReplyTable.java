package com.shl.javabeans.tools;

import java.io.Serializable;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.shl.javabeans.entity.ReplyTableRow;
import com.shl.sql.BaseDao;
import com.shl.sql.QureyResult;

/**
 * @ClassName: ReplyTable
 * @Description:保存指定postid的回复信息的bean
 * @author: shl
 * @date: 2015-12-12 下午1:37:19
 */
public class ReplyTable implements Serializable {
	/**
	 * @Fields postid :
	 */
	private int postid;
	/**
	 * @param postid the postid to set
	 */
	public void setPostid(int postid) {
		this.postid = postid;
	}
	/**
	 * @Fields table :
	 */
	private ArrayList<ReplyTableRow> replyTable;

	/**
	 * @Description 汇总给定postID的回复信息
	 * @return  给定postID的回复信息
	 * @throws Exception 
	 */
	public ArrayList<ReplyTableRow> getTableRows() throws Exception {
		replyTable = new ArrayList<ReplyTableRow>();
		String sqlpost="select b.userid,b.nickname,b.headname,b.registertime,a.postcontent," +
				"a.postid,a.createtime,a.modifytime from weipost a,weiuser b where " +
				"a.userid =b.userid and a.postid=?";
		String sqlreply = "select b.userid,b.nickname,b.headname,b.registertime," +
				"a.replycontent,a.replyid,a.createtime,a.modifytime from weireply a," +
				"weiuser b where a.userid=b.userid and a.postid=? order by a.modifytime desc";
		ArrayList<Object> paramList = new ArrayList<Object>(
				Arrays.asList(postid));
		getAddResult(sqlpost, paramList);
		getAddResult(sqlreply, paramList);
		return this.replyTable;
	}
	/**
	 * @Description 将查询结果增加到集合中
	 * @param sql sql语句
	 * @param paramList 参数列表
	 * @throws Exception   
	 */
	private void getAddResult(String sql,ArrayList<Object> paramList) throws Exception{
		QureyResult result = null;
		ResultSet res = null;
		try {
			result = BaseDao.doQueuy(sql, paramList);
			res = result.getResultSet();
			while (res.next()) {
				int userid =res.getInt(1);
				String nickname =res.getString(2);
				String headname =res.getString(3);
				Date registerTime =res.getDate(4);
				String content =res.getString(5);
				int replyid=res.getInt(6);
				java.util.Date createTime =res.getTimestamp(7);
				Date modifyTime =res.getTimestamp(8);
				replyTable.add(new ReplyTableRow(userid, nickname, headname, registerTime, 
						 replyid,content, createTime, modifyTime));
			}
		} finally {
			res.close();
			result.getConnection().close();
		}
	}
	public ReplyTable(){
		this.postid=2;
		ArrayList<ReplyTableRow> a;
		try {
			a = getTableRows();
		
		for(ReplyTableRow r:a){
		System.out.println(r.getNickname()+" "+r.getContent());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
		ReplyTable b =new ReplyTable();
		System.out.println("sun");
	}
}
