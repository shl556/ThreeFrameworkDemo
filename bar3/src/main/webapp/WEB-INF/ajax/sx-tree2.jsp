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
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>ʹ��sx:tree��sx:treenode��ǩ���ɶ�̬��</title>
	<sx:head/>
</head>
<body>
<h3>ʹ��sx:tree��sx:treenode��ǩ���ɶ�̬��</h3>
<sx:tree label="�����ͼ��" 
	id="book"
	href="getChild"
	showRootGrid="true" 
	showGrid="true">
	<sx:treenode label="a"/>
</sx:tree>
</body>
</html>