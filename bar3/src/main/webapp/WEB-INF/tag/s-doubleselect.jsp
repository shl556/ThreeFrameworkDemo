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
	<title> ʹ��s:doubleselect���ɼ��������б�� </title>
</head>
<body>
<s:form action="x">
	<s:doubleselect
		label="��ѡ����ϲ����ͼ��"
		name="author" list="{'���', 'David'}"
		doubleList="top == '���' ? {'���Java����',
		'������Java EE��ҵӦ��ʵս','���Ajax����'}:
		{'JavaScript: The Definitive Guide'}" 
		doubleName="book"/>	
</s:form>
</body>
</html>