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
<!-- ����һ�����ӵ�Map����keyΪ��ͨ�ַ�����valueΪList���� -->
<s:set name="bs" value="#{'���': {'���Android����', 
	'������Java EE��ҵӦ��ʵս','���Ajax����'},
	'David': {'JavaScript: The Definitive Guide'},
	'Johnson': {'Expert One-on-One J2EE Design and Development'}}"/>
<!-- ʹ��Map���������ɼ����б�� -->
<s:form action="x">
	<s:doubleselect
		label="��ѡ����ϲ����ͼ��"
		size="3"
		name="author" list="#bs.keySet()"
		doubleList="#bs[top]" 
		doubleSize="3"
		doubleName="book"/>	
</s:form>
</body>
</html>