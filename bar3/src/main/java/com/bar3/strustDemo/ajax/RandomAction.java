package com.bar3.strustDemo.ajax;

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
public class RandomAction extends ActionSupport
{
	private String data;
	public String getRdmStr()
	{
		String result = Math.round(Math.random() * 10000) + "";
		// 返回data和随机字符串连缀而成的字符串
		return data != null && !data.equals("")
			? data + result : result;
	}

	public void setData(String data)
	{
		this.data = HTMLDecoder.decode(data);
	}
	public String getData()
	{
		 return this.data;
	}
}
