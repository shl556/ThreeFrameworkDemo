package com.bar3.strustDemo;

import com.opensymphony.xwork2.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.*;

import javax.servlet.http.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
// 处理用户请求的Action
public class ServletResponseAwareDemo
	implements Action , ServletResponseAware
{
	// 需要访问的HttpSerlvetResponse对象
	private HttpServletResponse response;
	// 封装请求参数的两个属性。
	private String username;
	private String password;
	// username属性的getter和setter方法
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password属性的setter和getter方法
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	// 实现ServletResponseAware接口必须实现的方法
	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		// 在该方法内就可以访问该Web应用对客户的响应对象
		this.response = response;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception
	{
		if(StringUtils.isEmpty(getUsername())){
			return INPUT;
		}
		// 创建一个Cookie对象
		Cookie c = new Cookie("username" , getUsername());
		// 设置Cookie对象的最大生存时间
		c.setMaxAge(60 * 60);
		// 使用HttpServletResponse添加Cookie对象
		response.addCookie(c);
		System.out.println("设置cookie");
		return SUCCESS;
	}
}
