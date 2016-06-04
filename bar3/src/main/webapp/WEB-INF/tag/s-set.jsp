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
	<title> 使用s:set设置新变量 </title>
</head>
<body>
<!-- 使用bean标签定义一个JavaBean实例 -->
<s:bean name="com.bar3.strustDemo.tags.Person" id="p">
	<!-- 使用param标签为JavaBean实例传入参数 -->
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/>
</s:bean>
<!-- scope可以接受5个值，application，session，request，page和action，默认为action -->
将Stack Context中的p值放入默认范围内。<br />
<s:set value="#p" name="xxx"/>
<s:property value="#xxx.name"/><br />
<s:property value="#xxx.age"/><hr />
将Stack Context中的p值放入application范围内。<br />
<s:set value="#p" name="xxx" scope="application"/>
<s:property value="#attr.xxx.name"/><br />
<s:property value="#attr.xxx.age"/><hr />
将Stack Context中的p值放入session范围内。<br />
<s:set value="#p" name="xxx" scope="session"/>
<!-- 使用JSP2.0表达式语言直接访问session中的属性 -->
${sessionScope.xxx.name}<br />
${sessionScope.xxx.age}<br />
<s:debug></s:debug>
</body>
</html>