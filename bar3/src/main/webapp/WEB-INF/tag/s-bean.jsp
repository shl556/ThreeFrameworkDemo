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
	<title> 使用s:bean标签创建Java Bean实例 </title>
</head>
<body>
<!-- 使用bean标签创建一个com.bar3.strustDemo.tags.Person类的实例 -->
<s:bean name="com.bar3.strustDemo.tags.Person">
	<!-- 使用param标签为lee.Person类的实例传入参数 -->
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/> 
	<!-- 因为在bean标签内，Person实例位于ValueStack的栈顶，
		故可以直接访问Person实例 -->
	Person实例的name为：<s:property value="name"/><br />
	Person实例的age为：<s:property value="age"/>
</s:bean>
</body>
</html>