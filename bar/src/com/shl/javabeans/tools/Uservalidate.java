package com.shl.javabeans.tools;
import com.shl.javabeans.entity.User;
import com.shl.sql.*;
import java.io.Serializable;
import java.sql.*;
import java.sql.Date;
import java.util.*;
 
/**
 * @ClassName: Uservalidate
 * @Description:验证用户名，密码是否有效的工具bean
 * @author: shl
 * @date: 2015-12-11 下午2:25:43
 *
 */
public class Uservalidate implements Serializable{
	/**  
	 * @Fields lgname : 用户登陆名
	 */  
	private String lgname;
	
    /**  
     * @Fields lgpass : 用户登陆密码  
     */  
    private String lgpass;
    /**  
     * @Fields user : 记过验证的用户对象
     */  
    private User user;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the lgname
	 */
	public String getLgname() {
		return lgname;
	}
	/**
	 * @param lgname the lgname to set
	 */
	public void setLgname(String lgname) {
		this.lgname = lgname;
	}
	/**
	 * @param lgpass the lgpass to set
	 */
	
	public void setLgpass(String lgpass) {
		this.lgpass = lgpass;
	}
    
	
	/**
	 * @Description: 验证用户名，密码是否有效
	 * @return boolean
	 * @throws Exception   
	 */
	public boolean isvalid() throws Exception{
		boolean valid=false;
		QureyResult result=null;
		ResultSet res=null;
		try{
			List<Object> paramList =new ArrayList<Object>();
			paramList.add(lgname);
			paramList.add(lgpass);
			String sql ="select * from weiuser where lgname = ? and lgpass = ?";
			result=BaseDao.doQueuy(sql, paramList);
			res=result.getResultSet();
			if(res.next()){
				valid=true;
				int userid =res.getInt(1);
				String lgname =res.getString(2);
				String lgpass =res.getString(3);
				int sex =res.getInt(4);
				String nickname =res.getString(5);
				String headname =res.getString(6);
				Date registertime =res.getDate(7);
				user=new User(userid,lgname,lgpass,sex,nickname,headname,registertime);
			}
		}finally{
			res.close();
			result.getConnection().close();
		}
		return valid;
	}
//	public Uservalidate(){
//		this.lgname="ndx01";
//		this.lgpass="ndx01";
//		try {
//			System.out.println(isvalid());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args) {
//		Uservalidate aUservalidate=new Uservalidate();
//	}
}
