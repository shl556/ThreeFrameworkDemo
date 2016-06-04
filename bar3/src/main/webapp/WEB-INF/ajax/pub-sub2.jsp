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
    <title>Pub-Sub模型</title>
	<sx:head/>
</head>
<body>
<h3>Pub-Sub模型</h3>
<!-- 定义发布事件的提交按钮 -->
<sx:submit type="submit" value="更新" 
	notifyTopics="/change"/>
<!-- 定义2个订阅事件的Struts 2标签 -->
<sx:div id="t1" cssStyle="background-color:#bbbbbb;width:360px;
	height:80px" listenTopics="/change" href="book"/>
<sx:div id="t2" cssStyle="border:2px solid black;width:360px;
	height:120px" listenTopics="/change" href="price"/>
</body>
</html>