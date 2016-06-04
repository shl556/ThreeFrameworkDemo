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
	<title> 使用s:optgroup生成下拉选择框的选项组 </title>
</head>
<body>
<s:form>
<!-- 直接使用Map为列表框生成选项 -->
<s:select label="选择您喜欢的图书" name="book" size="7"
	list="#{'疯狂Android讲义':'李刚','轻量级Java EE企业应用实战':'李刚',
		'疯狂Ajax讲义':'李刚'}"
	listKey="value"
	listValue="key" >
	<!-- 使用Map对象来生成选择框的选项组 -->
	<s:optgroup label="Rod Johnson"
		list="#{'Expert One-on-One J2EE Design and Development':'Johnson'}"
		listKey="value"
		listValue="key"/>
	<s:optgroup label="David Flanagan"
		list="#{'JavaScript: The Definitive Guide':'David'}"
		listKey="value"
		listValue="key"/>
</s:select>
</s:form>
</body>
</html>