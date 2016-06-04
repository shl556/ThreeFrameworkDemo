package com.shl.javabeans.tools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.shl.sql.BaseDao;

public class UserRegister implements Serializable {
	/**
	 * @Fields lgname : 用户登陆名
	 */
	private String lgname;
	/**
	 * @Fields lgpass : 用户登陆密码
	 */
	private String lgpass;
	/**
	 * @Fields sex : 用户性别
	 */
	private int sex;
	/**
	 * @Fields nickname : 用户昵称
	 */
	private String nickname;
	/**
	 * @Fields headname : 用户头像文件名
	 */
	private String headname;
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
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @param headname the headname to set
	 */
	public void setHeadname(String headname) {
		this.headname = headname;
	}
    public int getUserRegister() throws Exception{
    	String sql ="insert into weiuser values(seq_userid.nextval,?,?,?,?,?,default)";
    	int doupdate = -1;
		@SuppressWarnings("unchecked")
		ArrayList<Object> paramList = new ArrayList<Object>(Arrays.asList(
				lgname,lgpass,sex,nickname,headname));
		doupdate = BaseDao.doUpdate(sql, paramList);
		return doupdate;
    }
}
