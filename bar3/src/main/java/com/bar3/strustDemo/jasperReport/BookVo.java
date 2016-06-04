package com.bar3.strustDemo.jasperReport;


public class BookVo
{
	private Integer id;
	private String name;
	private String author;


	// 无参数的构造器
	public BookVo()
	{
	}
	// 初始化全部属性的构造器
	public BookVo(Integer id , String name , String author)
	{
		this.id = id;
		this.name = name;
		this.author = author;
	}

	// id属性的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name属性的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// author属性的setter和getter方法
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
	}
}
