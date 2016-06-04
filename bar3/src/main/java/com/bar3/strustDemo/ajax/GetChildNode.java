package com.bar3.strustDemo.ajax;

import java.util.*;
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
public class GetChildNode extends ActionSupport
{
	// 封装nodeId请求参数的属性
	private String nodeId;
	private List<String> books = new ArrayList<String>();
	// nodeId属性的setter和getter方法
	public String getNodeId()
	{
		return nodeId;
	}
	public void setNodeId(String nodeId)
	{
		this.nodeId = HTMLDecoder.decode(nodeId);
	}
	// books属性的getter方法
	public List<String> getBooks()
	{
		return books;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		System.out.println("-----" + nodeId);
		if (nodeId.equals("book_root"))
		{
			books.clear();
			books.add("李刚");
			books.add("Johnson");
			books.add("David");
		}
		if (nodeId.equals("0"))
		{
			books.clear();
			books.add("疯狂Java讲义");
			books.add("疯狂Android讲义");
			books.add("轻量级Java EE企业应用实战");
		}
		if (nodeId.equals("1"))
		{
			books.clear();
			books.add("Expert One-on-One J2EE"
				+ " Design and Development");
		}
		if (nodeId.equals("2"))
		{
			books.clear();
			books.add("JavaScript权威指南");
		}
		return SUCCESS;
	}
}
