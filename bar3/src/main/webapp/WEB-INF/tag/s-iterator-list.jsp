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
	<title> 使用s:iterator迭代List集合 </title>
</head>
<body>
<table border="1" width="300">
<!-- 迭代输出List集合 -->
<s:iterator value="{'疯狂Java讲义','轻量级Java EE企业应用实战',
	'疯狂Android讲义','疯狂Ajax讲义'}" var="book" begin="1" end="3">
	<tr>
		<%-- <td><s:property value="book"/></td> --%>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>