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
	<title> ʹ��s:bean��ǩ����Java Beanʵ�� </title>
</head>
<body>
<!-- ʹ��bean��ǩ����һ��com.bar3.strustDemo.tags.Person���ʵ�� -->
<s:bean name="com.bar3.strustDemo.tags.Person">
	<!-- ʹ��param��ǩΪlee.Person���ʵ��������� -->
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/> 
	<!-- ��Ϊ��bean��ǩ�ڣ�Personʵ��λ��ValueStack��ջ����
		�ʿ���ֱ�ӷ���Personʵ�� -->
	Personʵ����nameΪ��<s:property value="name"/><br />
	Personʵ����ageΪ��<s:property value="age"/>
</s:bean>
</body>
</html>