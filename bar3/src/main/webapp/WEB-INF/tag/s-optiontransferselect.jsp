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
	<title> 使用s:optiontransferselect生成可移动列表项的下拉列表框 </title>
</head>
<body>
<s:form>
<!-- 使用简单集合对象来生成可移动的下拉列表框 -->
 <s:optiontransferselect 
  	label="请选择你喜欢的图书"
	name="cnbook" 
	leftTitle="中文图书："
	rightTitle="外文图书"
	list="{'疯狂Java讲义' ,'疯狂Android讲义',
		'轻量级Java EE企业应用实战','疯狂Ajax讲义'}" 
	multiple="true"
	addToLeftLabel="向左移动"
	selectAllLabel="全部选择"
	addAllToRightLabel="全部右移"
	headerKey="cnKey"
	headerValue="--- 选择中文图书 ---"
	emptyOption="true"
	doubleList="{'Expert One-on-One J2EE Design and Development',
		'JavaScript: The Definitive Guide'}" 
	doubleName="enBook"
	doubleHeaderKey="enKey"
	doubleHeaderValue="--- 选择外文图书 ---" 
	doubleEmptyOption="true"
	doubleMultiple="true"
/>
</s:form>
</body>
</html>