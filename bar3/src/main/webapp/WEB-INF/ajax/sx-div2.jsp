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
    <title>远程div</title>
    <sx:head/>
</head>
<script type="text/javascript">
function handler(widget, node)
{
	//node代表调用该函数的元素本身
	alert('本地JavaScript函数处理动态Div');
	node.innerHTML = Math.random() > 0.4 ?
		"疯狂Java讲义" : "轻量级Java EE企业应用实战";
}
</script>
<body>
直接使用本页面的JS函数，不再调用远程服务器<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="4000"
	handler="handler">
	初始化文本
</sx:div>
</body>
</html>