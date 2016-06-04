package com.bar3.strustDemo.freemarker;

import com.opensymphony.xwork2.*;

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
public class GetBooksAction extends ActionSupport
{
	// 用于封装全部图书的属性
	private static String[] books;
	// 用于初始化books属性的初始化块
	static{
		books = new String[]{
		"疯狂Java讲义" ,
		"轻量级Java EE企业应用实战",
		"疯狂Ajax讲义",
		"疯狂Android讲义" };
	}
	// 返回books属性的getter方法
	public String[] getBooks()
	{
		return books;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		String user = (String)ActionContext
			.getContext().getSession().get("user");
		if (user != null && user.equals("crazyit"))
		{
			return SUCCESS;
		}
		else
		{
			return LOGIN;
		}
	}
}
