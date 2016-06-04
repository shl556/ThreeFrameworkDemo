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
	<title>使用sx:bind标签</title>
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
<!-- 
sx:bind标签用于将已有的标签转换为发送异步请求的标签。由于该标签需要将已有的标签转换为发送异步请求的标签，使用
时需要指定如下两个属性：1.sourse，该属性值为一个或者多个元素的id属性值，多个id属性值之间 以英文逗号隔开，sx:bind
会把该属性指定的多个元素转换为发送异步请求的元素2.events，该属性值为一个或者多个事件名称，多个事件名称之间以英文逗号隔开，
指定了上面两个属性后，当页面的sources属性指定的元素的events事件被触发时，sx:bind标签负责将发送异步请求。
 -->
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">盛装服务器响应的div元素</div>
<s:form id="form" action="ajaxTest">
	<input type="text" name="data"/>
	<s:submit id="btn1" type="submit" value="发送"/>
</s:form>
将一个普通按钮转换为异步按钮，发送form表单里包含的表单域<br />
<sx:bind sources="btn1"
	events="onclick" 
	targets="t1"
	formId="form"
	listenTopics="/after"
	showLoadingText="false"/>
<img id="img1"
	src="image/struts-power.gif"
	alt="struts2" /><br />
将一张普通图片转换为异步请求按钮<br />
<sx:bind sources="img1"
	events="onclick"
	targets="t1"
	notifyTopics="/after"
	href="ajaxTest"/><br/>
</body>
</html>
