package com.bar3.strustDemo;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;

/*
 * strust采用声明式异常处理，execute方法抛出所有的异常，异常通过拦截器捕获，并将异常
 * 信息作为拦截器实例的属性存储在拦截器实例中，捕获异常后系统会自动将捕获异常的拦截器实例对象
 * 压入栈顶，可以通过exception或者exceptionStack访问具体的异常信息。异常的声明处理在
 * xml文件中使用global-exception-mappings和exception-mapping元素配置。
 */
public class ExceptionDemo implements Action{
	// 使用两个属性来封装用户的请求参数
		private String username;
		private String password;
		// 使用tip属性来封装服务器处理后的结果
		private String tip;
		// username属性的setter和getter方法
		public void setUsername(String username)
		{
			this.username = username;
		}
		public String getUsername()
		{
			return (this.username);
		}
		// password属性的setter和getter方法
		public void setPassword(String password)
		{
			this.password = password;
		}
		public String getPassword()
		{
			return (this.password);
		}
		// tip属性的setter和getter方法
		public void setTip(String tip)
		{
			this.tip = tip;
		}
		public String getTip()
		{
			return tip;
		}
		// 处理用户请求的execute方法，该方法抛出所有异常类型
		public String execute() throws Exception
		{
			if(StringUtils.isEmpty(getUsername())){
//				return INPUT;
				//测试未知处理器
				return "sun";
			}
			// 手动抛出异常
			if (getUsername().equalsIgnoreCase("user"))
			{
				throw new MyException("自定义异常");
			}
			// 手动抛出异常
			if (getUsername().equalsIgnoreCase("sql"))
			{
				throw new java.sql.SQLException("用户名不能为SQL");
			}
			if (getUsername().equals("crazyit")
				&& getPassword().equals("leegang") )
			{
				setTip("哈哈，服务器提示！");
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
		}
}
