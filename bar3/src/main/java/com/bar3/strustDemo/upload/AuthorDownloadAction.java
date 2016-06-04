package com.bar3.strustDemo.upload;

import org.apache.struts2.*;

import com.opensymphony.xwork2.*;

import java.io.*;

/*
 * 对于get请求strust会根据xml文件配置的编码方式自动进行转码，无需二次解码
 * 另一方面写入响应头中的filename为了能让响应头被浏览器正确读取，必须由应用的编码方式转码至ISO格式，
 * 只有这样才能保证用户看到的下载文件名没有中文乱码问题。
 * 如果inputPath对应的路径没有资源就会抛出异常
 */
public class AuthorDownloadAction extends ActionSupport
{
	//资源路径、文件类型和下载文件名通过url参数传递进来
	// 代表下载文件的资源路径
	private String inputPath;
	// 代表下载文件的文件类型
	private String contentType;
	// 代表服务器写入效应头中的filename属性，即用户可以看到的下载的文件的名字
	private String downFileName;
	// inputPath的setter和getter方法
	public void setInputPath(String inputPath)
		throws Exception
	{
	    this.inputPath=inputPath;
	}
	public String getInputPath()
	{
		return inputPath;
	}

	// contentType的setter和getter方法
	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}
	public String getContentType()
	{
		return this.contentType;
	}

	// downFileName的setter和getter方法
	public void setDownFileName(String downFileName)
		throws Exception
	{
		// 处理请求参数的解码
		this.downFileName=new String(downFileName.getBytes("UTF-8"),"iso-8859-1");
	}
	public String getDownFileName()
	{
		return this.downFileName;
	}
	/*
	定义一个返回InputStream的方法，
	该方法将作为被下载文件的入口，由strust调用该方法向客户端返回一个输入流
	且需要配置stream类型结果时指定inputName参数，
	inputName参数的值就是方法去掉get前缀、首字母小写的字符串
	*/
	public InputStream getTargetFile() throws Exception
	{
		//ServletContext提供getResourceAsStream()方法
		//返回指定文件对应的输入流
		return ServletActionContext.getServletContext()
			.getResourceAsStream(inputPath);
	}
	public String execute()
	{
		System.out.println("执行打印");
		System.out.println("downfileName:"+downFileName);
		System.out.println("inputPate:"+inputPath);
		System.out.println("contentType:"+contentType);
		//对下载实现权限控制
		/*// 取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 通过ActionContext访问用户的HttpSession
		String user = (String)ctx.getSession().get("user");
		// 判断Session里的user是否通过检查
		if ( user !=  null && user.equals("crazyit"))
		{
			return SUCCESS;
		}
		ctx.put("tip" , "您还没有登录，或用户名不正确，请重新登录！");
		return LOGIN;*/
		return SUCCESS;
	}
}
