package com.bar3.strustDemo.upload;

import java.io.*;
import java.util.*;

import com.opensymphony.xwork2.*;

import org.apache.struts2.*;

public class UploadAction extends ActionSupport
{
	// 封装文件标题请求参数的属性
	private String title;
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 直接在struts.xml文件中配置的属性
	private String savePath;
	// 接受struts.xml文件配置值的方法
	public void setSavePath(String value)
	{
		this.savePath = value;
	}
	// 返回上传文件的保存位置
	private String getSavePath() throws Exception
	{
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	// 定义该Action允许上传的文件类型
	private String allowTypes;
	// allowTypes的setter和getter方法
	public String getAllowTypes()
	{
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes)
	{
		this.allowTypes = allowTypes;
	}


	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// upload的setter和getter方法
	public void setUpload(File upload)
	{
		this.upload = upload;
	}
	public File getUpload()
	{
		return this.upload;
	}

	// uploadContentType的setter和getter方法
	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}
	public String getUploadContentType()
	{
		return this.uploadContentType;
	}

	// uploadFileName的setter和getter方法
	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
	public String getUploadFileName()
	{
		return this.uploadFileName;
	}

	@Override
	public String execute() throws Exception
	{
		/*// 将允许上传文件类型的字符串以英文逗号（,）分解成字符串数组
		// 从而判断当前文件类型是否允许上传
		String filterResult = filterType(getAllowTypes().split(","));
		// 如果当前文件类型不允许上传
		if (filterResult != null)
		{
			addFieldError("upload" , "您要上传的文件类型不正确！");
			return filterResult;
		}
		//过滤文件大小，也可通过设置strust.multipart.maxSizze属性设置上传文件的最大大小，该属性对整个应用有效
		if(getUpload().length()>2024){
			addFieldError("upload", "您要上传的文件超过2M");
			return INPUT;
		}*/
		String newName = UUID.randomUUID() + uploadFileName
			.substring(uploadFileName.lastIndexOf("."));
		//以服务器的文件保存地址和随机文件名建立上传文件输出流
		FileOutputStream fos = new FileOutputStream(getSavePath()
			+ "\\" + newName);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer , 0 , len);
		}
		setUploadFileName(newName);
		return SUCCESS;
	}
	/**
	 * 过滤文件类型
	 * @param types 系统所有允许上传的文件类型
	 * @return 如果上传文件的文件类型允许上传，返回null，否则返回input字符串
	 */
	public String filterType(String[] types)
	{
		//获取希望上传的文件类型
		String fileType = getUploadContentType();
		for (String type : types)
		{
			if (type.equals(fileType))
			{
				return null;
			}
		}
		return INPUT;
	}

}
