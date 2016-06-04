package com.bar3.strustDemo;

import java.util.*;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;

// 过滤方法的拦截器，继承MethodFilterInterceptor抽象类,配置拦截器时可以通过param元素
//配置该拦截器的两个属性，excludeMethods（不需要被拦截的方法）和includeMethods（需要被拦截的方法）
public class MethodFilter extends MethodFilterInterceptor
{
	// 拦截器的名字
	private String name;
	// 为该拦截器设置名字的setter方法
	public void setName(String name)
	{
		this.name = name;
	}
	// 重写doIntercept方法，实现拦截方法拦截逻辑
	public String doIntercept(ActionInvocation invocation) throws Exception
	{
		// 打印执行开始的时间
		System.out.println(name + " 拦截器的动作---------" +
			"开始执行登录Action的时间为：" + new Date());
		// 取得开始执行Action的时间
		long start = System.currentTimeMillis();
		// 执行该拦截器的后一个拦截器，或者直接指定Action的execute方法
		String result = invocation.invoke();
		// 打印执行结束的时间
		System.out.println(name + " 拦截器的动作---------" +
			"执行完登录Action的时间为：" + new Date());
		long end = System.currentTimeMillis();
		// 打印执行该Action所花费的时间
		System.out.println(name + " 拦截器的动作---------" +
			"执行完该Action的事件为" + (end - start) + "毫秒");
		return result;
	}
}
