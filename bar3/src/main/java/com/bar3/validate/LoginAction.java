package com.bar3.validate;

import com.opensymphony.xwork2.*;

// 继承ActionSupport来实现Action
/*
 * Action类不需要继承任何接口或者类，也不需要提供execute方法，只要提供返回String的无参public方法就可以。
 * 实现Action接口可以确保标准的返回值。ActionSupport实现了Action、validate等接口，继承该类可以方便开发Action。
 * Action类中的属性可以用于封装请求参数或者处理结果，strust通过对应属性的set方法将请求参数赋值给action中
 * 对应的属性，通过get方法获取属性。
 */
public class LoginAction extends ActionSupport
{
	//下面是用于封装用户请求参数的两个属性
	private String username;
	private String password;
	// username属性的getter和setter方法
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password属性的getter和setter方法
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		if (getUsername()==null||getUsername().equals("")) {
			return INPUT;
		}
		// 当用户请求参数的username等于crazyit，密码请求参数为leegang时，
		// 返回success字符串，否则返回error字符串
		if (getUsername().equals("crazyit")
			&& getPassword().equals("leegang"))
		{
			// 通过ActionContext对象访问Web应用的HTTP Session
			ActionContext.getContext().getSession()
				.put("user" , username);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	   public String doTest(){
		   return SUCCESS;
	   }
	   public void validateDoTest(){
		   addFieldError("username", "测试验证框架");
	   }
	// 完成输入校验需要重写的validate方法
		/*
		 * validate方法是没有返回值的，那么当验证后，如果有数据没有通过验证，该返回到什么页面呢？这就需要在struts.xml中的Action配置里面，
		 * 添加一个名称为input的result配置，也就是说，如果validate方法中，有数据没有通过验证，fieldErrors域不为空，
		 * 那么会自动跳转回到该action中名称为input的result所配置的页面.
		 * 
		 * validate()方法会在excute()方法执行前执行。
		 * 
		 * 注意：即使类型转换失败，系统并不是直接返回input逻辑视图，依然会调用Action的validate方法来进行输入校验。
		 * validate()方法会对action中的所有 逻辑处理方法起作用  比如：execute(),login(),即调用任何一个逻辑方法之前都会调用validate方法进行效验
		 * 也可自定义针对某个逻辑处理方法的效验，如逻辑方法为doTest,自定义的效验方法就是validateDoTest,注意大小写。当调用doTest
		 * 方法时会先调用该方法的效验方法，再调用validate（）方法。如果不想重复执行效验，可以不写excute方法，不写validate方法，如果写excute方法，可以将
		 * validate方法改为validateExecute方法。 
		 */
		/*@Override	
		public void validate()
			{
				// 如果用户名为空，或者用户名为空字符串
				if (getUsername() == null ||
					getUsername().trim().equals(""))
				{
					// 添加校验错误提示，使用getText方法来提示信息国际化
					addFieldError("username", getText("user.required"));
				}
				// 当密码为空，或者密码为空字符串时，添加表单校验错误
				if (getPassword() == null ||
					getPassword().trim().equals(""))
				{
					addFieldError("password", getText("pass.required"));
				}
			}
			*/
		/*public void validateExecute()
		{
			// 如果用户名为空，或者用户名为空字符串
			if (getUsername() == null ||
					getUsername().trim().equals(""))
			{
				// 添加校验错误提示，使用getText方法来提示信息国际化
				addFieldError("username", getText("user.required"));
			}
			// 当密码为空，或者密码为空字符串时，添加表单校验错误
			if (getPassword() == null ||
					getPassword().trim().equals(""))
			{
				addFieldError("password", getText("pass.required"));
			}
		}*/
}
