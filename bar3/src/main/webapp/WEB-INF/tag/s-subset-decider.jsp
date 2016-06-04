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
	<title> 使用subset截取子集合 </title>
</head>
<body>
<!-- 定义一个Decider Bean -->
<s:bean var="mydecider" name="com.bar3.strustDemo.tags.MyDecider"/>
<!-- 使用自定义的Decider实例来截取目标集合，生成子集
	指定var属性，将生成的Itertor放入Stack Context中，decider实例必须实现SubsetIteratorFilter.Decider接口-->
<s:subset source="{'疯狂Java讲义','疯狂Android讲义',
	'轻量级Java EE企业应用实战','疯狂Ajax讲义',
	'疯狂XML讲义'}" 
	decider="#mydecider"
	var="newList"/>
直接输出page范围的newList属性：<br/>
${pageScope.newList}
<table border="1" width="300">
<!-- 迭代page范围内的newList属性 -->
<s:iterator status="st" value="#attr.newList">	
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>