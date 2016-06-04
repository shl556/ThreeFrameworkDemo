<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title> 使用s:token防止重复提交 </title>
</head>
<body>
<s:form action="pro">
	<!-- 普通表单域 -->
	<s:textfield name="book" key="book"/>
	<!-- 用于防刷新的token -->
	<s:token/>
	<s:submit value="提交"/>
</s:form>
</body>
</html>