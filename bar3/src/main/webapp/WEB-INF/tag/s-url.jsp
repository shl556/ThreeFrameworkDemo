<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
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
	<title> ʹ��s:url����URL��ַ </title>
</head>
<body>
<h2>ʹ��s:url����URL��ַ</h2>
ָֻ��value���Ե���ʽ��<br />
<s:url value="editGadget.action"/>
<hr />
ָ��action����,��ʹ��param�����������ʽ��<br />
<s:url action="showBook">
    <s:param name="author" value="'yeeku'" />
</s:url>
<hr />
�Ȳ�ָ��action����,Ҳ��ָ��value����,��ʹ��param�����������ʽ��<br />
<s:url includeParams="get"  >
    <s:param name="id" value="'22'"/>
</s:url>
<hr />
ͬʱָ��action���Ժ�value����,��ʹ��param�����������ʽ��<br />
<s:url action="showBook" value="xxxx">
    <s:param name="author" value="'yeeku'" />
</s:url>
</body>
</html>