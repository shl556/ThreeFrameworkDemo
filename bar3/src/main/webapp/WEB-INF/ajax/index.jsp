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
	<title> ʹ��stream���ʵ��Ajax </title>
	<script type="text/javascript" 
		src="${pageContext.request.contextPath}/js/jquery-1.11.1.js">
	</script>
	<script type="text/javascript">
		var guess = function()
		{
			// ʹ��jQuery��guessPro�������󣬲���showԪ��װ����Ӧ
			$("#show").load("ajax" 
				, $("#guessForm").serializeArray());
		}
	</script>
</head>
<body>
<s:form id="guessForm" action="ajax">
	<s:textfield name="num" label="���µ�����"/>
	<s:textfield name="name" label="��ͨ���Ĳ���"/>
	<tr>
		<td colspan="2"><input type="button" value="�£�"
			onclick="guess();"/></td>
	</tr>
</s:form>
<div id="show">
</div>
</body>
</html>