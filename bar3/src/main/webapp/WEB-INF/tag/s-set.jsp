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
	<title> ʹ��s:set�����±��� </title>
</head>
<body>
<!-- ʹ��bean��ǩ����һ��JavaBeanʵ�� -->
<s:bean name="com.bar3.strustDemo.tags.Person" id="p">
	<!-- ʹ��param��ǩΪJavaBeanʵ��������� -->
	<s:param name="name" value="'yeeku'"/>
	<s:param name="age" value="29"/>
</s:bean>
<!-- scope���Խ���5��ֵ��application��session��request��page��action��Ĭ��Ϊaction -->
��Stack Context�е�pֵ����Ĭ�Ϸ�Χ�ڡ�<br />
<s:set value="#p" name="xxx"/>
<s:property value="#xxx.name"/><br />
<s:property value="#xxx.age"/><hr />
��Stack Context�е�pֵ����application��Χ�ڡ�<br />
<s:set value="#p" name="xxx" scope="application"/>
<s:property value="#attr.xxx.name"/><br />
<s:property value="#attr.xxx.age"/><hr />
��Stack Context�е�pֵ����session��Χ�ڡ�<br />
<s:set value="#p" name="xxx" scope="session"/>
<!-- ʹ��JSP2.0���ʽ����ֱ�ӷ���session�е����� -->
${sessionScope.xxx.name}<br />
${sessionScope.xxx.age}<br />
<s:debug></s:debug>
</body>
</html>