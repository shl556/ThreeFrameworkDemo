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
	<title> 使用s:append标签拼接两个集合 </title>
</head>
<body>
<!-- 使用append标签将两个集合拼接成新的集合，
	新集合的名字是newList -->
<s:append var="newList">
	<s:param value="{'疯狂Java讲义',
		'轻量级Java EE企业应用实战','疯狂Ajax讲义'}" />
	<s:param value="{'http://www.leegang.org', 
		'http://www.crazyit.org'}" />
</s:append>
<table border="1" width="260">
<!-- 使用iterator迭代newList集合 -->
<s:iterator value="#newList" status="st">
	<tr>
		<td><s:property value="#st.count"/></td>
		<td><s:property/></td>
	</tr>
</s:iterator>
</body>
</html>