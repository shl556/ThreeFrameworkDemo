package com.bar3.strustDemo.tags;

import com.opensymphony.xwork2.*;


public class ProAction extends ActionSupport
{
	private String book;

	public void setBook(String book)
	{
		this.book = book;
	}
	public String getBook()
	{
		return this.book;
	}
	// 处理用户请求，保存用户参数，并返回SUCCESS
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		ctx.put("book" , getBook());
		return SUCCESS;
	}
}
