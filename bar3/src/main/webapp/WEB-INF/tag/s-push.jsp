<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
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
	<title> ʹ��s:push���������ValueStackջ�� </title>
</head>
<body>
<!-- ʹ��bean��ǩ����һ��JavaBeanʵ����
	ָ��var���ԣ����������Stack Context�� -->
<s:bean name="com.bar3.strustDemo.tags.Person" var="p">
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/>
</s:bean>
<!-- ��Stack Context�е�p�������ValueStackջ��-->
<s:push value="#p">
	<!-- ���ValueStackջ�������name��age���� -->
	ValueStackջ�������name���ԣ�<s:property value="name"/><br />
	ValueStackջ�������age���ԣ�<s:property value="age"/><br />
</s:push>
</body>
</html>