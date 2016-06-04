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
	<title> s:iterator标签测试 </title>
</head>
<body>
<table>
<tr>
<td>当前值</td><td>getCount</td><td>getIndex</td><td>isEven</td><td>isFirst</td><td>isLast</td><td>isOdd</td>
</tr>
<s:iterator value="{'疯狂Java讲义','轻量级Java EE企业应用实战',
	'疯狂Ajax讲义' , '疯狂Android讲义'}" status="st">
	<tr>
	<td><s:property/></td>
	<td><s:property value="#st.count"/></td>
	<td><s:property value="#st.index"/></td>
	<td><s:property value="#st.even"/></td>
	<td><s:property value="#st.odd"/></td>
	<td><s:property value="#st.first"/></td>
	<td><s:property value="#st.last"/></td>
	</tr>
</s:iterator>
</table>
<table border="1" width="300">
<!-- 迭代输出List集合 -->
<s:iterator value="{'疯狂Java讲义','轻量级Java EE企业应用实战',
	'疯狂Ajax讲义' , '疯狂Android讲义'}" status="st">
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>

</table>
<table border="1" width="350">
	<tr>
		<th>书名</th>
		<th>作者</th>
	</tr>
<!-- 对指定的Map对象进行迭代输出,并指定status属性 -->
<s:iterator value="#{'疯狂Java讲义':'李刚',
	'轻量级Java EE企业应用实战':'李刚' ,
	'疯狂Ajax讲义':'李刚'}" status="st">
	<!-- 根据当前被迭代元素的索引是否为奇数来决定是否使用背景色 -->
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<!-- 输出Map对象里Entry的key -->
		<td><s:property value="key"/></td>
		<!-- 输出Map对象里Entry的value -->
		<td><s:property value="value"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>