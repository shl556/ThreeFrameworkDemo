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
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> ʹ��s:optgroup��������ѡ����ѡ���� </title>
</head>
<body>
<s:form>
<!-- ֱ��ʹ��MapΪ�б������ѡ�� -->
<s:select label="ѡ����ϲ����ͼ��" name="book" size="7"
	list="#{'���Android����':'���','������Java EE��ҵӦ��ʵս':'���',
		'���Ajax����':'���'}"
	listKey="value"
	listValue="key" >
	<!-- ʹ��Map����������ѡ����ѡ���� -->
	<s:optgroup label="Rod Johnson"
		list="#{'Expert One-on-One J2EE Design and Development':'Johnson'}"
		listKey="value"
		listValue="key"/>
	<s:optgroup label="David Flanagan"
		list="#{'JavaScript: The Definitive Guide':'David'}"
		listKey="value"
		listValue="key"/>
</s:select>
</s:form>
</body>
</html>