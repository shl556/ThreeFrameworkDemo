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
	<title>远程链接</title>
	<sx:head/>
<script type="text/javascript">
	function before() {alert("before request");}
	function after() {alert("after request");}
	function handler(widget, node) 
	{
		alert('本地JavaScript处理函数');
		dojo.byId(widget.targetsArray[0]).innerHTML 
			= "疯狂Java讲义";
	}
	dojo.event.topic.subscribe("/after"
		, function(data, type, e)
		{
			alert('正处于Dojo的异步交互过程中，类型是：' + type);
		});
</script>
</head>
<body>
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">div 1</div><br />
<div id="t2" style="background-color:#bbbbbb;
	width:360px;height:80px">div 2</div><br />
同时修改div1和div2的内容<br/>
且将事件发布到/after主题(指定notifyTopics属性)<br />
<sx:a id="link1"
	href="ajaxTest"
	indicator="indicator"
	targets="t1,t2"
	notifyTopics="/after" >修改div1和div2内容</sx:a>
<img id="indicator" src="image/indicator.gif"
	alt="Loading..." style="display:none"/>
<br />
指定服务期返回失败时的错误提示(指定errorText属性)<br />
因为系统中ajaxNoUrl.jsp页面不存在，肯定出错！<br />
<sx:a id="link2"
	href="/ajaxNoUrl"
	errorText="系统服务器返回信息出错"
	targets="t1">修改'div 1'的内容，使用自定义出错提示</sx:a>
<br />
指定系统加载中的提示信息(指定loadingText属性)<br />
<sx:a id="link3"
	href="ajaxTest"
	loadingText="系统正在加载中..."
	targets="t1">修改'div 1'的内容，使用自定义Loading信息</sx:a>
<br/>
执行远程JavaScript代码(指定executeScripts＝true属性)<br />
<sx:a id="link4"
	href="testjs"
	executeScripts="true"
	targets="t2">接执行远程JavaScript，更新'div 2'的内容</sx:a>
<br />
通过使用本地JavaScript函数来实现Ajax交互(指定handler属性)<br/>
<sx:a id="link5"
	href="ajaxTest"
	handler="handler"
	targets="t2">使用本地JavaScript处理函数</sx:a>
<form id="form">
	<input type="textbox" name="data" />
</form>
提交表单请求(通过指定formId属性) <br />
<sx:a id="link6"
	href="ajaxTest"
	targets="t2"
	formId="form">div 2 会显示在上面文本框中输入的内容</sx:a>
</body>
</html>