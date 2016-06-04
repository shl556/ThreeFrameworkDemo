<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>上传成功</title>
</head>
<body>
	上传成功!<br>
	<!-- 输出上传的表单里的文件标题属性 -->
	文件标题:<s:property value=" + title"/><br>
	<%-- <!-- 根据上传文件的文件名，在页面上显示上传的图片 -->
	文件为：<img src='upload/<s:property value="uploadFileName"/>'/><br> --%>
	<s:iterator value="uploadFileName" var="imageFile">
	<!-- 根据上传文件的文件名，在页面上显示上传的图片 -->
	文件为：<img src='upload/${imageFile}'/><br>
	</s:iterator>
</body>
</html>
