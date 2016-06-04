<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 使用s:url生成URL地址 </title>
</head>
<body>
<h2>使用s:url生成URL地址</h2>
只指定value属性的形式。<br />
<s:url value="editGadget.action"/>
<hr />
指定action属性,且使用param传入参数的形式。<br />
<s:url action="showBook">
    <s:param name="author" value="'yeeku'" />
</s:url>
<hr />
既不指定action属性,也不指定value属性,且使用param传入参数的形式。<br />
<s:url includeParams="get"  >
    <s:param name="id" value="'22'"/>
</s:url>
<hr />
同时指定action属性和value属性,且使用param传入参数的形式。<br />
<s:url action="showBook" value="xxxx">
    <s:param name="author" value="'yeeku'" />
</s:url>
</body>
</html>