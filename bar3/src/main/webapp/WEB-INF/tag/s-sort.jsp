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
	<title> 使用s:sort对集合元素进行排序 </title>
</head>
<body>
<!-- 定义一个Comparator实例 -->
<s:bean var="comparator" name="com.bar3.strustDemo.tags.MyComparator"/>
<!-- 使用自定义的排序规则对目标集合进行排序 -->
<s:sort source="{'轻量级Java EE企业应用实战',
	'疯狂Ajax讲义','疯狂Java讲义',
	'疯狂XML讲义'}" 
	comparator="#comparator"
	var="sortedList"/>
输出page范围的sortedList属性：<br/>
${pageScope.sortedList}
<table border="1" width="300">
<!-- 迭代page范围内的sortedList属性 -->
<s:iterator status="st" value="#attr.sortedList">	
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>