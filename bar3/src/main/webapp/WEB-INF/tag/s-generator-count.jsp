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
	<title> ʹ��s:generator���ɼ��� </title>
</head>
<body>
<!-- ʹ��generator��һ���ַ���������һ�����ϣ�ָ����var��count���� -->
<s:generator val="'Struts 2Ȩ��ָ��,������Java EE��ҵӦ��ʵս
	,���Ajax����'" separator="," var="books" count="2"/>
<table border="1" width="300">
<!-- �������Stack Congtext�е�books���� -->
<s:iterator value="#books">
	<tr>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
${requestScope.books}
</body>
</html>