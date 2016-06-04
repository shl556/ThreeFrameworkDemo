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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 使用s:date格式化日期 </title>
</head>
<body>
<!-- 使用java.util.Date创建一个日期对象。 -->
<s:bean var="now" name="java.util.Date">
	<s:param name="date" value="1"/>
</s:bean>
nice="false"，且指定format="dd/MM/yyyy"<br />
<!-- nice属性指定是否输出指定日期与当前时刻之间的时差，默认为false，不输出时差，即指定日期是当前日期之前后者之后多少天。
指定nice属性后，format属性无效-->
<!-- 
如果没有指定nice属性和format属性，系统会自动到国际化资源文件中寻找key为strust.date.format的消息，将该消息作为格式化文本
来输出格式化日期
 -->
<s:date name="#now" format="dd/MM/yyyy" nice="false"/><hr />
nice="true"，且指定format="dd/MM/yyyy"<br />
<s:date name="#now" format="dd/MM/yyyy" nice="true"/><hr />
指定nice="true"<br />
<s:date name="#now" nice="true"/><hr />
nice="false"，且没有指定format属性<br />
<s:date name="#now" nice="false"/><hr />
</body>
</html>