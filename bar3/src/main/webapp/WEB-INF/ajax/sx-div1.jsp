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
<body>
仅一次获取服务器内容的div<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random">
	初始化文本
</sx:div>
动态更新内容的div，每隔1s刷新一次(通过指定updateFreq="1000")<br />
使用indicator(通过指定indicator="indicator")<br />
<!-- updateFreq指定更新div内容的时间间隔，单位是ms。如果不指定该属性则只在页面加载时更新该div内容
delay指定初次更新div内容的时间延迟，单位是ms，如果不指定该属性且指定了updateFreq属性，则页面加载后立即
开始计时准备刷新div内容。如果没有指定updateFreq属性，该属性无效
 -->
<sx:div id="div2"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="1000"
	indicator="indicator">
	初始化文本
</sx:div>
<img id="indicator" alt="Loading..." style="display:none"
	src="${pageContext.request.contextPath}/image/indicator.gif"/><br />
3s之后才开始更新(通过指定delay="3000")<br />
指定与服务器交互出错的提示(通过指定errorText属性)<br />
指定与服务器交互过程中的提示(通过指定loadText属性)<br />
<sx:div id="div3"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="1000"
	delay="3000"
	errorText="加载服务器数据出错"
	loadingText="正在加载服务器内容">
	初始化文本
</sx:div>
指定显示系统出错提示(通过指定showErrorTransportText="true")<br />
<sx:div id="div4"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="ajaxNoUrl"
	updateFreq="1000"
	errorText="加载服务器数据出错"
	showErrorTransportText="true"
	loadingText="正在加载服务器内容">
	初始化文本
</sx:div>
执行服务器脚本(通过指定executeScripts="true")
<sx:div id="div5"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="testjs"
	updateFreq="9000"
	executeScripts="true"
	loadingText="正在加载服务器内容">
	初始化文本
</sx:div>
</body>
</html>