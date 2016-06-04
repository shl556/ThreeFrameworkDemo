package com.bar3.strustDemo.upload;

import java.io.*;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.apache.struts2.*;
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
public class UploadAction2 extends ActionSupport
{
	private String title;
	// 使用File数组封装多个文件域对应的文件内容
	private File[] upload;
	// 使用字符串数组封装多个文件域对应的文件类型
	private String[] uploadContentType;
	// 使用字符串数组封装多个文件域对应的文件名字
	private String[] uploadFileName;
	// 接受依赖注入的属性
	private String savePath;
	// title属性的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	// upload属性的setter和getter方法
	public void setUpload(File[] upload)
	{
		this.upload = upload;
	}
	public File[] getUpload()
	{
		return this.upload;
	}
	// uploadContentType属性的setter和getter方法
	public void setUploadContentType(String[] uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadContentType()
	{
		return this.uploadContentType;
	}
	// uploadFileName属性的setter和getter方法
	public void setUploadFileName(String[] uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
	public String[] getUploadFileName()
	{
		return this.uploadFileName;
	}
	// savePath属性的setter和getter方法
	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}
	public String getSavePath()
	{
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	@Override
	public String execute() throws Exception
	{
		// 取得需要上传的文件数组
		File[] files = getUpload();
		// 遍历每个需要上传的文件
		for (int i = 0 ; i < files.length ; i++)
		{
			String newName = UUID.randomUUID() + uploadFileName[i]
				.substring(uploadFileName[i].lastIndexOf("."));
			// 以服务器的文件保存地址和随机文件名建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(getSavePath()
				+ "\\" + newName);
			// 以每个需要上传的文件建立文件输入流
			FileInputStream fis = new FileInputStream(files[i]);
			// 将每个需要上传的文件写到服务器对应的文件中
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0)
			{
				fos.write(buffer , 0 , len);
			}
			fos.close();
			getUploadFileName()[i] = newName;
		}
		return SUCCESS;
    }
}
