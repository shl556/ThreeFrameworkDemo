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
	<title>远程按钮</title>
	<sx:head/>
<script type="text/javascript">
dojo.event.topic.subscribe("/after"
	, function(data, type, e)
	{
		alert('正处于Dojo的异步交互过程中，类型是：' + type);
	});
</script>
</head>
<body>
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">盛装服务器响应的div元素</div>
简单的提交按钮，使用indicator<br />
<img id="indicator" alt="Loading..." style="display:none"
	src="${pageContext.request.contextPath}/image/indicator.gif" />
<!-- targets属性设置用于装载服务器响应的HTML元素 -->
<sx:submit type="submit"
	value="提交"
	targets="t1"
	href="ajaxTest"
	indicator="indicator"/><br />
简单的提交按钮，使用Pub-Sub事件模型(设置notifyTopics=/after属性)<br />
<sx:submit type="submit" 
	value="提交"
	targets="t1"
	href="ajaxTest"
	notifyTopics="/after"/><br />
图片按钮(通过指定type="image")<br />
<sx:submit type="image"
	label="测试Label"
	targets="t1"
	src="images/struts-power.gif"
	href="ajaxTest.action"/><br/>
异步方式提交表单：(在下面输入的文本将在上面显示出来)
<s:form id="form" action="ajaxTest">
	<input type="text" name="data"/>
	<sx:submit type="button" 
		label="发送" targets="t1" />
</s:form>
</body>
</html>