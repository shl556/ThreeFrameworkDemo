package com.bar3.validate;

public class BookService
{
	//以数组模拟从持久存储设备（数据库）中取出的数据
	private String[] books = new String[] {
			"疯狂Java讲义" ,
			"疯狂Android讲义" ,
			"轻量级Java EE企业应用实战",
			"疯狂Ajax讲义",
			"疯狂XML讲义",
		};
	//业务逻辑方法，该方法返回全部图书
	public String[] getLeeBooks()
	{
		return books;
	}
}

