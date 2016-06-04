package com.bar3.strustDemo.convert;

import com.opensymphony.xwork2.*;

import java.util.*;

public class RegistAction extends ActionSupport
{
	// 值对象用于封装请求参数的4个属性
	private String name;
	private String pass;
	private int age;
	private Date birth;
	// 无参数的构造器
	public RegistAction()
	{
	}
	// 初始化全部属性的构造器
	public RegistAction(String name , String pass ,
		int age , Date birth)
	{
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.birth = birth;
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

	// pass的setter和getter方法
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// birth的setter和getter方法
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	public Date getBirth()
	{
		return this.birth;
	}
    /*private User user=new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
    /*private Map<String, User> users=new HashMap<String, User>();

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}*/
   /* private List<User> users=new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/
    
}
