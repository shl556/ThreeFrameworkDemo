package com.bar3.strustDemo.ajax;

import com.opensymphony.xwork2.*;
import java.util.*;


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
	private String author;
	private List<String> books = new ArrayList<String>();
	// author属性的setter和getter方法
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = HTMLDecoder.decode(author);
	}
	// books属性的getter方法
	public List<String> getBooks()
	{
		return books;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		if (author.equals("李刚"))
		{
			books.clear();
			books.add("疯狂Java讲义");
			books.add("轻量级Java EE企业应用实战");
			books.add("疯狂Ajax讲义");
			books.add("疯狂Android讲义");
		}
		else if (author.equals("Rod Johnson"))
		{
			books.clear();
			books.add("Expert One-on-One J2EE"
				+ " Design and Development");
		}
		else if (author.equals("David Flanagan"))
		{
			books.clear();
			books.add("JavaScript权威指南");
		}
		return SUCCESS;
	}
}
