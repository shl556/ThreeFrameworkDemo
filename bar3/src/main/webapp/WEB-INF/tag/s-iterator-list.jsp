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
	<title> ʹ��s:iterator����List���� </title>
</head>
<body>
<table border="1" width="300">
<!-- �������List���� -->
<s:iterator value="{'���Java����','������Java EE��ҵӦ��ʵս',
	'���Android����','���Ajax����'}" var="book" begin="1" end="3">
	<tr>
		<%-- <td><s:property value="book"/></td> --%>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>