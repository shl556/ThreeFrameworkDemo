package com.bar3.strustDemo.freemarker;

import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import freemarker.template.*;

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
//@WebServlet(urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet
{
	// 负责管理FreeMarker模板的Configuration实例，不需要重复创建 Configuration 实例； 它的代价很高，尤其是会丢失缓存。
	//Configuration 实例就是应用级别的单例。
	private Configuration cfg;
	public void init()
	{
		// 初始化FreeMarker配置
		// 创建一个Configuration实例
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDefaultEncoding("UTF-8");
		// 设置FreeMarker的模板文件位置
		cfg.setServletContextForTemplateLoading(
			getServletContext(), "WEB-INF/templates");
		//开发阶段使用HTML_DEBUG_HANDLER模式，发布阶段使用RETHROW_HANDLER，前者会 抛出详细的异常堆栈信息，后者只是简单的抛出异常
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
	}
	// 生成用户响应
	public void service(HttpServletRequest request
		, HttpServletResponse response)
		throws ServletException, IOException
	{
		// 建立数据模型
		Map<String , String> root = new HashMap<String , String>();
		root.put("message", "Hello FreeMarker!");
		// 取得模板文件
		Template t = cfg.getTemplate("test2.ftl");
		// 开始准备生成输出
		// - 使用模板文件的charset作为本页面的charset
		// - 使用text/html MIME-type
		response.setContentType("text/html; charset=" + t.getEncoding());
		Writer out = response.getWriter();
		// 合并数据模型和模板，并将结果输出到out中
		try
		{
			t.process(root, out);
		}
		catch (TemplateException e)
		{
			throw new ServletException("处理Template模板中出现错误" , e);
		}
	}
}
