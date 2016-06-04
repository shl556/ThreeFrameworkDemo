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
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 使用s:doubleselect生成级联下拉列表框 </title>
</head>
<body>
<!-- 创建一个复杂的Map对象，key为普通字符串，value为List集合 -->
<s:set name="bs" value="#{'李刚': {'疯狂Android讲义', 
	'轻量级Java EE企业应用实战','疯狂Ajax讲义'},
	'David': {'JavaScript: The Definitive Guide'},
	'Johnson': {'Expert One-on-One J2EE Design and Development'}}"/>
<!-- 使用Map对象来生成级联列表框 -->
<s:form action="x">
	<s:doubleselect
		label="请选择您喜欢的图书"
		size="3"
		name="author" list="#bs.keySet()"
		doubleList="#bs[top]" 
		doubleSize="3"
		doubleName="book"/>	
</s:form>
</body>
</html>