package com.bar3.strustDemo.convert;



import java.util.Date;

import com.opensymphony.xwork2.*;

/*
 * 希望有错误提示，action必须继承自ActionSupport，因为strust实际上是把错误信息
 * 方法ActionSupport的filedErrorMessages属性中，没有这个属性就无法显示错误消息
 */
public class LoginAction extends ActionSupport
{
	/*// 封装请求参数的Map对象
	private User user;
	private String tip;
	// user属性的setter和getter方法
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return this.user;
	}
	// tip的setter和getter方法
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		if(getUser()==null){
			return INPUT;
		}
		// 调用user属性的name、pass进行判断
		if (getUser().getName().equals("crazyit")
			&& getUser().getPass().equals("leegang"))
		{
			setTip("登录成功");
			return SUCCESS;
		}
		else
		{
			setTip("登录失败");
			return ERROR;
		}
	}*/
	
	/*// 使用全局类型转换器将字符串请求参数直接转换成一个User实例
		private User user;
		// 封装customer请求参数的属性
		private User customer;
		// 封装birth请求参数的属性
		private Date birth;
		// 封装Action处理结果的tip属性
		private String tip;

		// 无参数的构造器
		public LoginAction()
		{
		}

		// user属性的setter和getter方法
		public void setUser(User user)
		{
			this.user = user;
		}
		public User getUser()
		{
			return this.user;
		}

		// customer属性的setter和getter方法
		public void setCustomer(User customer)
		{
			this.customer = customer;
		}
		public User getCustomer()
		{
			return this.customer;
		}

		// birth属性的setter和getter方法
		public void setBirth(Date birth)
		{
			this.birth = birth;
		}
		public Date getBirth()
		{
			return this.birth;
		}

		// tip属性的setter和getter方法
		public void setTip(String tip)
		{
			this.tip = tip;
		}
		public String getTip()
		{
			return this.tip;
		}

		// 处理用户请求的execute方法
		public String execute() throws Exception
		{
			if(getUser()==null){
				return INPUT;
			}
			// 调用user属性的name属性和pass属性进行判断
			if (getUser().getName().equals("crazyit")
				&& getUser().getPass().equals("leegang") )
			{
				setTip("转换成功");
				return SUCCESS;
			}
			else
			{
				setTip("转换失败");
				return ERROR;
			}
		}*/
	
	private User[] users;
	// 封装birth请求参数的属性
	private Date birth;
	// 封装Action处理结果的tip属性
	private String tip;

	// users的setter和getter方法
	public void setUsers(User[] users)
	{
		this.users = users;
	}
	public User[] getUsers()
	{
		return this.users;
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

	// tip的setter和getter方法
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		if(getUsers()==null){
			return INPUT;
		}
		// 调用users数组的第一个元素的name属性和pass属性进行判断
		if (getUsers()[0].getName().equals("crazyit")
			&& getUsers()[0].getPass().equals("leegang") )
		{
			setTip("转换成功");
			return SUCCESS;
		}
		else
		{
			setTip("转换失败");
			return ERROR;
		}
	}
}
