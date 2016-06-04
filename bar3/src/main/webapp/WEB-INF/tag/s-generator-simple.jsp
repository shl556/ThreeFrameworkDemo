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
<!-- 使用s:generator标签将一个字符串解析成集合,可以给converter属性指定一个实现了Converter接口的对象，从而将字符串转换成其他对象-->
<table border="1" width="240">
<!-- 使用generator标签将指定字符串解析成List集合
	在generator标签内，得到的List集合位于ValueStack顶端 -->
<s:generator val="'疯狂Java讲义,轻量级Java EE企业应用实战,
	疯狂Ajax讲义'" separator=",">
<!-- 没有指定迭代哪个集合，直接迭代ValueStack顶端的集合 -->
<s:iterator status="st">
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>
</s:generator>
</table>
</body>
</html>