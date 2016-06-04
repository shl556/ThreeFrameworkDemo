package com.bar3.strustDemo.upload;

import com.opensymphony.xwork2.ActionSupport;
//strust会自动对get请求中的中文参数进行根据xml配置的编码方式自动解码转码
public class URLparamTest extends ActionSupport{
	public String userName;
	public String nickName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String execute() throws Exception {
        System.out.println("userName:"+userName);
        System.out.println("nickName:"+nickName);
		return super.execute();
	}
}
