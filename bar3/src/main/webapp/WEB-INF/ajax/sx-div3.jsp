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
var controller = 
{
	refresh : function() {alert("手动刷新");},
	start : function() {alert("启动自动刷新");},
	stop : function() {alert("停止自动刷新");}
};
// 将controller的refresh方法注册成/refresh主题的发布者
dojo.event.topic.registerPublisher("/refresh"
	, controller, "refresh");
// 将controller的start方法注册成/startTimer主题的发布者
dojo.event.topic.registerPublisher("/startTimer"
	, controller, "start");
// 将controller的stop方法注册成/stopTimer主题的发布者
dojo.event.topic.registerPublisher("/stopTimer"
	, controller, "stop");
// 为after主题指定一个事件订阅者
dojo.event.topic.subscribe("/after"
	, function(data, type, e)
	{
		alert('与服务器交互过程中. 现在的过程类型是：' + type+'数据是：'+data);
	});
</script>
<body>
<form id="testForm">
	<s:textfield name="data" label="输入用户数据"/>
</form>
<input type="button" value="手动刷新" 
	onclick="controller.refresh();" />
<input type="button" value="停止计时器"
	onclick="controller.stop();" />
<input type="button" value="启动计时器" 
	onclick="controller.start();" />
<br>
使用Pub-Sub机制(通过指定listenTopics等属性)<br />
发送表单请求参数(通过指定formId="form")<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	loadingText="正在加载服务器内容..."
	listenTopics="/refresh"
	startTimerListenTopics="/startTimer"
	stopTimerListenTopics="/stopTimer"
	updateFreq="9000"
	autoStart="true"
	formId="testForm"
	notifyTopics="/after">
	初始化文本
</sx:div>
</body>
</html>