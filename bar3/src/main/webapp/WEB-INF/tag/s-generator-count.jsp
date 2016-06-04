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
	<title> 使用s:generator生成集合 </title>
</head>
<body>
<!-- 使用generator将一个字符串解析成一个集合，指定了var和count属性 -->
<s:generator val="'Struts 2权威指南,轻量级Java EE企业应用实战
	,疯狂Ajax讲义'" separator="," var="books" count="2"/>
<table border="1" width="300">
<!-- 迭代输出Stack Congtext中的books集合 -->
<s:iterator value="#books">
	<tr>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
${requestScope.books}
</body>
</html>