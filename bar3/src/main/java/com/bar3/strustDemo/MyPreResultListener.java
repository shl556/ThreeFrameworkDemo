package com.bar3.strustDemo;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.*;

import java.util.*;
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
public class MyPreResultListener implements PreResultListener
{
	// 定义在处理Result之前的行为
	public void beforeResult(ActionInvocation invocation
		, String resultCode)
	{
		// 打印出执行结果
		System.out.println("返回的逻辑视图为:" + resultCode);
	}
}
