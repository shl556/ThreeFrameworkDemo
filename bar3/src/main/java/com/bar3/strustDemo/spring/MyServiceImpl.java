package com.bar3.strustDemo.spring;

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
// 业务逻辑组件实现类，实现了业务逻辑组件接口
public class MyServiceImpl implements MyService
{
	// 根据用户输入的用户名、密码来判断登录是否成功
	// 实际应用中可能需要通过数据库记录进行判断
	public boolean valid(String username , String pass)
	{
		if (username.equals("crazyit")
			&& pass.equals("leegang") )
		{
			return true;
		}
		return false;
	}
}
