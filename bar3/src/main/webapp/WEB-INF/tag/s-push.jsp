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
	<title> 使用s:push将对象放入ValueStack栈顶 </title>
</head>
<body>
<!-- 使用bean标签创建一个JavaBean实例，
	指定var属性，并将其放入Stack Context中 -->
<s:bean name="com.bar3.strustDemo.tags.Person" var="p">
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/>
</s:bean>
<!-- 将Stack Context中的p对象放入ValueStack栈顶-->
<s:push value="#p">
	<!-- 输出ValueStack栈顶对象的name和age属性 -->
	ValueStack栈顶对象的name属性：<s:property value="name"/><br />
	ValueStack栈顶对象的age属性：<s:property value="age"/><br />
</s:push>
</body>
</html>