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
	<title> s:if标签 </title>
</head>
<body>
<!-- 在Stack Context中定义一个age变量，其值为29 -->
<s:set name="age" value="5"/>
<!-- 如果Stack Context中的age属性大于60 -->
<s:if test="#age>60">
    老年人
</s:if>
<!-- 如果Stack Context中的age属性大于35 -->
<s:elseif test="#age>35">
    中年人
</s:elseif>
<!-- 如果Stack Context中的age属性大于15 -->
<s:elseif test="#age>15">
	青年人
</s:elseif>
<s:else>
    少年
</s:else>
</body>
</html>