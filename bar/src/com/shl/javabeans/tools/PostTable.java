package com.shl.javabeans.tools;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.shl.javabeans.entity.PostTableRow;
import com.shl.sql.BaseDao;
import com.shl.sql.QureyResult;

/**
 * @ClassName: PostTable
 * @Description:收集汇总指定kindid版块下的主题信息
 * @author: shl
 * @date: 2015-12-12 上午10:06:04
 */
public class PostTable implements Serializable{
	/**
	 * @Fields kindid : 指定版块的kindid
	 */
	private int kindid;
	
	/**  
	 * @Fields postTable : 指定版块的主题汇总信息集合
	 */  
	private ArrayList<PostTableRow> postTable;
	/**
	 * @Description 获取指定版块的主题汇总信息集合
	 * @return  ArrayList<PostTableRow> 
	 * @throws Exception 
	 */
	/**
	 * @param kindid the kindid to set
	 */
	public void setKindid(int kindid) {
		this.kindid = kindid;
	}
	public ArrayList<PostTableRow> getPostTable() throws Exception{
		postTable=new ArrayList<PostTableRow>();
		String sql = "select a.postid,a.title,b.nickname from weipost a,weiuser b " +
				"where a.kindid=? and a.userid=b.userid order by a.createtime desc";
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(kindid));
		QureyResult result = null;
		ResultSet res = null;
		try{
			result = BaseDao.doQueuy(sql, paramList);
			res = result.getResultSet();
			while (res.next()) {
				int postid =res.getInt(1);
				String title =res.getString(2);
				String nickname=res.getString(3);
				int sum =getReplySum(postid);
			    postTable.add(new PostTableRow(postid, title, nickname,sum));
			}
			}finally{
				res.close();
				result.getConnection().close();
			}
		return postTable;
	}
	/**
	 * @Description 计算某主题下的回复总数
	 * @param postid 主题id
	 * @return int 某主题下的回复总数
	 * @throws Exception 
	 */
	private int getReplySum(int postid) throws Exception{
		String sql = "select count(*) from weireply a where a.postid=?";
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(postid));
		QureyResult result = null;
		ResultSet res = null;
		int sum=-1;
		try{
			result = BaseDao.doQueuy(sql, paramList);
			res = result.getResultSet();
			while (res.next()) {
				sum = res.getInt(1);
			}
			}finally{
				res.close();
				result.getConnection().close();
			}
		return sum;
	}
//	public PostTable(){
//		this.kindid=12;
//		try {
//			ArrayList<PostTableRow> a =getPostTable();
//			for(PostTableRow row : a){
//			System.out.println(row.getTitle()+" "+row.getReplysum());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args) {
//		PostTable aPostTable=new PostTable();
//	}
}
