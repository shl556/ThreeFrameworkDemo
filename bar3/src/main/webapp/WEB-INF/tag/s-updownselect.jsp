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
	<title> 使用s:updownselect生成可上下移动选项的下拉选择框 </title>
</head>
<body>
<s:form>
<!-- 使用简单集合来生成可上下移动选项的下拉选择框 -->
<s:updownselect name="a" label="请选择您喜欢的图书" labelposition="top"
	moveUpLabel="向上移动"
	list="{'疯狂Java讲义' , '轻量级Java EE企业应用实战',
	'疯狂Ajax讲义'}"/>
<!-- 使用Map对象来生成可上下移动选项的下拉选择框 
	 且使用emptyOption="true"增加一个空选项-->
<s:updownselect name="b" label="请选择您想选择出版日期" labelposition="top"
	moveDownLabel="向下移动" list="#{'疯狂Java讲义':'2008年10月',
	'轻量级Java EE企业应用实战':'2011月3月',
	'疯狂Ajax讲义':'2007年6月'}"
	listKey="key"
	emptyOption="true"
	listValue="value"/>
<s:bean name="org.crazyit.struts2.service.BookService" id="bs"/>
<!-- 使用集合里放多个JavaBean实例来可上下移动选项的下拉选择框 -->
<s:updownselect name="c" label="请选择您喜欢的图书的作者" labelposition="top"
	selectAllLabel="全部选择" multiple="true"
	list="#bs.books"
	listKey="author"
	listValue="name"/>
</s:form>
</body>
</html>