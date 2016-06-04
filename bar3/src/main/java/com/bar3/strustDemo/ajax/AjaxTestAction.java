package com.bar3.strustDemo.ajax;

import com.opensymphony.xwork2.ActionSupport;

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
public class AjaxTestAction extends ActionSupport
{
	private static int counter = 0;
	// 封装请求参数的属性
	private String data;
	public long getServerTime()
	{
		return System.currentTimeMillis();
	}

	public int getCount()
	{
		return ++counter;
	}

	// data属性的setter和getter方法
	public void setData(String data)
	{
		// 将Dojo的请求参数转换成正常字符
		this.data = HTMLDecoder.decode(data);
	}
	public String getData()
	{
		return this.data;
	}
}
