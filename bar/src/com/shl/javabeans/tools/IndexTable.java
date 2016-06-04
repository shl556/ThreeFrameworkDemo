package com.shl.javabeans.tools;

import java.io.Serializable;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import com.shl.javabeans.entity.IndexTableRow;
import com.shl.javabeans.entity.Kind;
import com.shl.javabeans.entity.Post;
import com.shl.sql.*;
/**
 * @ClassName: IndexTable
 * @Description: 收集汇总每个论坛的信息bean
 * @author: shl
 * @date: 2015-12-11 下午4:36:27
 */
public class IndexTable implements Serializable{
    /**  
     * @Fields table : 各版块信息的集合，键为父版块的名字，值为该版块下各
     * 子版块的信息集合
     */  
    private TreeMap<Kind, ArrayList<IndexTableRow>> table;
    
    /**
     * @Description 返回各版块信息的集合
     * @return HashMap<String, ArrayList<IndexTableRow>>  
     * @throws Exception 
     */
    public TreeMap<Kind, ArrayList<IndexTableRow>> getIndexTable() throws Exception{
    	//查询父类版块信息，将其保存在parentkind集合中
    	table=new TreeMap<Kind, ArrayList<IndexTableRow>>(new KindComparator());
    	ArrayList<Kind> parentKinds=select(0);
    	for(Kind kd:parentKinds){
    	   ArrayList<Kind> childKinds=select(kd.getKindid());
    	   ArrayList<IndexTableRow> tableRows=new ArrayList<IndexTableRow>();
    	   for(Kind chkd:childKinds){
    		   int i=childKinds.indexOf(chkd);
    		   String kindname =chkd.getKindName();
    		   int kindid =chkd.getKindid();
    		   int postsum=getPostSum(kindid);
    		   Post lastPost=getLastPost(kindid);
               String title=null;
               int postid=0;
               String nickname=null;
               Date modifytime=null;
    		   if(lastPost!=null){
    		   title =lastPost.getTitle();
    		   postid =lastPost.getPostid();
    		   nickname =lastPost.getNickname();
    		   modifytime =lastPost.getModifyTime();
               }
    		   tableRows.add(new IndexTableRow(kindname, kindid, postsum, title, postid, nickname, modifytime));
    	   }
    	   table.put(kd,tableRows);
    	}
    	return table;
    }
    
    /**
     * @Description 根据父版块id查询子版块信息
     * @param id 父版块id
     * @return  ArrayList<Kind> 子版块信息集合
     * @throws Exception 
     */
	private ArrayList<Kind> select(int id) throws Exception {
		String sql = "select * from weikind where parentkindid = ?";
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(id));
		QureyResult result = null;
		ResultSet res = null;
		ArrayList<Kind> childKind = new ArrayList<Kind>();
		try{
		result = BaseDao.doQueuy(sql, paramList);
		res = result.getResultSet();
		while (res.next()) {
			int kindid = res.getInt(1);
			String kindname = res.getString(2);
			int parentid = res.getInt(3);
			childKind.add(new Kind(kindid, kindname, parentid));
		}
		}finally{
			res.close();
			result.getConnection().close();
		}
		return childKind;
	}
	/**
	 * @Description 返回指定id版块下的主题总数
	 * @param kindid 版块id
	 * @return int 主题总数
	 * @throws Exception   
	 */
	private  int getPostSum(int kindid) throws Exception{
		String sql = "select count(*) from weipost where kindid = ?";
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(kindid));
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

	/**
	 * @Description 根据给定版块id查找该版块下最近发表的主题
	 * @param kindid 版块id
	 * @return  最近发表的主题post对象
	 * @throws Exception   
	 */
	private Post getLastPost(int kindid) throws Exception {
		String sql = "select a.postid,a.userid,a.title,a.modifytime," +
				"b.nickname from weipost a,weiuser b where a.userid=b.userid " +
				"and kindid =? order by modifytime desc";
		ArrayList<Object> paramList = new ArrayList<Object>(
				Arrays.asList(kindid));
		QureyResult result = null;
		ResultSet res = null;
		Post lastPost = null;
		int sum = -1;
		try {
			result = BaseDao.doQueuy(sql, paramList);
			res = result.getResultSet();
			if(res.next()){
			int postId = res.getInt(1);
			int userId = res.getInt(2);
			String title = res.getString(3);
			Date modifyTime = res.getTimestamp(4);
			String nickname =res.getString(5);
			lastPost = new Post(postId, userId,nickname, title, modifyTime);
			}
		} finally {
			res.close();
			result.getConnection().close();
		}
		return lastPost;
	}
//	public IndexTable() {
//		try {
////			ArrayList<Kind> parentKinds=select(0);
////		for(Kind kd:parentKinds){
////			System.out.println(kd.getKindId()+" "+kd.getKindName());
////		}
////			System.out.println(getPostSum(12));
////			Post a =getLastPost(12);
////			System.out.println(a.getPostId()+" "+a.getTitle()+" "+a.getNickname());
//			HashMap<String, ArrayList<IndexTableRow>> a=getIndexTable();
//			for(String s : a.keySet()){
//				System.out.println(s);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args) throws Exception{
//          IndexTable a =new IndexTable();	
//	}
//	
}
