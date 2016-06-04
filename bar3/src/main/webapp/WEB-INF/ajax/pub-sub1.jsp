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
<script type="text/javascript">
//dojo.event.topic.publish("/refresh","foo","bar"),表示将foo对象的bar方法注册到/refresh主题下，主题就是一个随意的字符串
// 订阅/lee主题，使用匿名函数监听
dojo.event.topic.subscribe("/lee", function(data, type, request)
{
	alert('正处于Dojo的异步交互过程中，类型是：' + type);
	alert(request);
	alert('服务器的响应为：'+data);
});
</script>
<body>
<h3>简单Pub-Sub模型</h3>
<!-- 单击该按钮时将发布事件到/lee主题 -->
<!-- 
大部分ajax标签比如A标签都有listenTopics属性，该属性指定一些列的主题名，多个主题之间以英文逗号隔开，当发布至该主题下的事件被激发时，A标签会自动异步加载服务器端响应
还有一个属性就是notifyTopics，指定一系列事件主题名，多个主题间以英文逗号隔开，配置该属性的HTML元素会把激发该元素的事件，如submit标签就把点击事件发布到指定的主题下，
当submit标签被点击时，指定主题下的所有订阅者即listenTopics该主题的标签就会自动加载服务器端响应
strust2发布的标签总是会发送三个参数，data，从服务器端返回的数据，type，与服务器端交互的状态，只有三个值，即before（交互之前），load（加载数据中）和error（）
 -->
<sx:submit type="submit" value="提交"
	align="left" notifyTopics="/lee"/>
<sx:div id="t1" cssStyle="background-color:#bbbbbb;width:360px;
	height:80px" listenTopics="/lee" href="book"/>
<sx:div id="t2" cssStyle="border:2px solid black;width:360px;
	height:120px" listenTopics="/lee" href="price"/>
</body>
</html>