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
	<title> ʹ��s:appendƴ�Ӽ��Ϻ�Map </title>
</head>
<body>
<!-- ʹ��append��List��Map����ƴ����һ��
	�¼���ʵ������Map���ϣ�������ΪnewList -->
<s:append var="newList">
	<s:param value="#{'���Java����':'���',
	'������Java EE��ҵӦ��ʵս':'���' ,
	'���Ajax����':'���'}" />
	<s:param value="#{'http://www.leegang.org', 
		'http://www.crazyit.org'}" />
</s:append>
<table border="1" width="280">
<!-- ʹ��iterator����newList���� -->
<s:iterator value="#newList" status="st">
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property value="key"/></td>
		<td><s:property value="value"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>