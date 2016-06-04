package com.bar3.strustDemo;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.*;

// 处理用户请求的Action类
public class ActionContextDemo extends ActionSupport
{
	// 封装用户请求参数的username和password属性
	private String username;
	private String password;
	// username属性对应的setter和getter方法
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password属性对应的setter和getter方法
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	// 下面是处理用户请求的execute方法
	public String execute() throws Exception
	{
		if(StringUtils.isEmpty(getUsername())){
			return INPUT;
		}
		// 获取ActionContext实例，通过该实例访问Servlet API
		ActionContext ctx = ActionContext.getContext();
		// 获取ServletContext里的counter属性
		Integer counter = (Integer)ctx
			.getApplication().get("counter");
		// 如果counter属性为null，设置该counter属性为1
		if (counter == null)
		{
			counter = 1;
		}
		// 否则，将counter加1
		else
		{
			counter = counter + 1;
		}
		// 将增加1后的counter值设置成counter属性
		ctx.getApplication().put("counter" , counter);
		// 将登录用的username属性设置成一个HttpSession属性
		ctx.getSession().put("user" , getUsername());
		// 如果用户名为crazyit，密码为leegang
		if (getUsername().equals("crazyit")
			&& getPassword().equals("leegang") )
		{
			// 直接设置HttpServletRequest属性，
			// request.setAttribute("tip" , "服务器提示：您已经成功的登录");
			// 下面代码的作用类似于设置HttpServletRequest属性
//			ctx.put("tip" , "服务器提示：您已经成功的登录");
			addActionMessage("恭喜您成功登陆");
			return SUCCESS;
		}
		else
		{
			// 通过ActionContext设置HttpServletRequest属性
//			ctx.put("tip" , "服务器提示：登录失败");
			addActionError("登陆失败,请重新输入");
			return ERROR;
		}
	}
    /*private User user=new User();
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception
	{
		String userName=user.getUsername();
		if(StringUtils.isEmpty(userName)){
			return INPUT;
		}
		// 获取ActionContext实例，通过该实例访问Servlet API
		ActionContext ctx = ActionContext.getContext();
		// 获取ServletContext里的counter属性
		Integer counter = (Integer)ctx
			.getApplication().get("counter");
		// 如果counter属性为null，设置该counter属性为1
		if (counter == null)
		{
			counter = 1;
		}
		// 否则，将counter加1
		else
		{
			counter = counter + 1;
		}
		// 将增加1后的counter值设置成counter属性
		ctx.getApplication().put("counter" , counter);
		// 将登录用的username属性设置成一个HttpSession属性
		ctx.getSession().put("user" , userName);
		// 如果用户名为crazyit，密码为leegang
		if (userName.equals("crazyit")
			&& user.getPassword().equals("leegang") )
		{
			// 直接设置HttpServletRequest属性，
			// request.setAttribute("tip" , "服务器提示：您已经成功的登录");
			// 下面代码的作用类似于设置HttpServletRequest属性
			ctx.put("tip" , "服务器提示：您已经成功的登录");
//			addActionMessage("恭喜您成功登陆");
			return SUCCESS;
		}
		else
		{
			// 通过ActionContext设置HttpServletRequest属性
			ctx.put("tip" , "服务器提示：登录失败");
//			addActionError("登陆失败,请重新输入");
			return ERROR;
		}
	}*/
}
