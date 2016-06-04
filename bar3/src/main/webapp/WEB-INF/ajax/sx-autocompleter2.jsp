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
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
    <title>自动完成</title>
	<sx:head/>
</head>
<body>
<h3>将两个sx:autocompleter关联起来</h3>
<form id="selectForm">
请选择您喜欢的作者：<br />
<sx:autocompleter 
	name="author" 
	list="{'李刚','Rod Johnson' , 'David Flanagan'}"  
	value="李刚"
	notifyTopics="/books"
	forceValidOption="true"/>
</form>
请选择您喜欢的图书：<br />
<sx:autocompleter 
	name="book"
	href="getBooks" 
	cssStyle="width: 240px;"
	autoComplete="false"
	formId="selectForm"
	listenTopics="/books"
	forceValidOption="true"/>
</body>
</html>