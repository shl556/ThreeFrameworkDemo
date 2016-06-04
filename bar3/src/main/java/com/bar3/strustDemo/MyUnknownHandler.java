package com.bar3.strustDemo;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.config.entities.*;
import org.apache.struts2.dispatcher.*;
/*
 * 当用户请求为止action或者调用指定action里的未知方法或者action处理结束后返回一个未知result时
 * strust允许使用未知处理器来处理这些情况。只要定义一个实现了UnknownHandler接口的action，并在xml
 * 文件中配置该action即可。当出现以上情况时，系统会自动调用该action的相关方法
 */
public class MyUnknownHandler implements UnknownHandler
{
	/**
	 * @param namespace 用户请求的Action所在的命名空间。
	 * @param actionName 用户请求的Action的名字。
	 * @return 该Action最后生成的ActionConfig，可以返回null。
	 */
	public ActionConfig handleUnknownAction(String namespace,
		String actionName) throws XWorkException
	{
		//...加入处理
		return null;
	}
	/**
	 * @param action 用户请求的Action对象。
	 * @param methodName 用户请求的Action的方法名
	 * @return 该Action的该方法处理后返回的Result。
	 */
	public Object handleUnknownActionMethod(Object action,
		String methodName)throws NoSuchMethodException
	{
		//...加入处理
		return "";
	}
	/**
	 * @param actionContext 该Result所在ActionContext。
	 * @param actionName 该Result所在的Action名。
	 * @param actionConfig 该Result所在ActionContext。
	 * @param resultCode 该Result所对应的逻辑视图字符串。
	 * @return 将要被处理的结果，可以返回null。
	 */
	public Result handleUnknownResult(ActionContext actionContext,
		String actionName, ActionConfig actionConfig,
		String resultCode) throws XWorkException
	{
		actionContext.put("action" , actionName);
		actionContext.put("result" , resultCode);
		//总是转入unknownResult.jsp页面
		return new ServletDispatcherResult(
			"/WEB-INF/strustDemo/unknownResult.jsp");
	}
}
