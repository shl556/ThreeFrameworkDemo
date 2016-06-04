package com.bar3.strustDemo.ajax;

import java.io.*;

import com.opensymphony.xwork2.*;


public class GuessNumberAction extends ActionSupport
{
	// 封装请求参数的num属性
    private int num;
	private String name;
	// 代表服务器响应的InputStream
	private InputStream inputStream;
	// 省略num和name属性的setter和getter方法

	// num的setter和getter方法
	public void setNum(int num)
	{
		this.num = num;
	}
	public int getNum()
	{
		return this.num;
	}

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public InputStream getInputStream()
	{
		return this.inputStream;
	}
    public String execute() throws Exception
	{
		// 查看是否可以正确获取name请求参数
		System.out.println("---" + getName());
		long result = Math.round(Math.random() * 7);
		// 如果猜的数字正确
		if (result == num)
		{
			 inputStream = new ByteArrayInputStream(
				 "恭喜你，您猜对了！".getBytes("utf-8"));
		}
		else
		{
			 inputStream = new ByteArrayInputStream(
				 ("不好意思，您猜错了，服务器数字是：" + result)
				 .getBytes("utf-8"));
		}
		return SUCCESS;
    }
}
