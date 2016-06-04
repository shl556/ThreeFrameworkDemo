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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 使用s:action标签在页面上调用Action </title>
</head>
<body>
下面调用第一个Action，并将结果包含到本页面中。<br />
<s:action name="tag1" executeResult="true"/>
<hr/>
下面调用第二个Action，并将结果包含到本页面中。<br />
但阻止本页面请求参数传入Action。<br />
<!-- excuteResult是否将Action的处理结果包含在本页面内，默认为false，不包含。ignoreContextParams指定该页面中
的请求参数是否需要传入调用的Action，默认为false，传入。name属性不支持在action名后添加参数,只能使用param标签添加参数
访问http://localhost:8080/bar3/s-action?author=sun进行测试-->
<s:action name="tag2" executeResult="true" ignoreContextParams="true">
   <%-- <s:param name="author">sun</s:param> --%>
</s:action>
本页面是否可访问？<s:property value="author"/>
<hr/>
下面调用第二个Action，且并不将结果包含到本页面中。<br />
<s:action name="tag2" executeResult="false" ignoreContextParams="false">
   <%-- <s:param name="author">sun</s:param> --%>
</s:action>
本页面是否可访问？<s:property value="author"/>
<s:debug></s:debug>
</body>
</html>