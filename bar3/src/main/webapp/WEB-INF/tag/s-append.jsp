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
	<title> ʹ��s:append��ǩƴ���������� </title>
</head>
<body>
<!-- ʹ��append��ǩ����������ƴ�ӳ��µļ��ϣ�
	�¼��ϵ�������newList -->
<s:append var="newList">
	<s:param value="{'���Java����',
		'������Java EE��ҵӦ��ʵս','���Ajax����'}" />
	<s:param value="{'http://www.leegang.org', 
		'http://www.crazyit.org'}" />
</s:append>
<table border="1" width="260">
<!-- ʹ��iterator����newList���� -->
<s:iterator value="#newList" status="st">
	<tr>
		<td><s:property value="#st.count"/></td>
		<td><s:property/></td>
	</tr>
</s:iterator>
</body>
</html>