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
	<title>��¼ҳ��</title>
</head>
<body>
<h3>�û���¼</h3>
<s:form action="loginPro">
	<s:textfield name="username" label="�û���"/>
	<s:textfield name="password" label="����"/>
	<s:submit value="��¼"/>
</s:form>
</body>
</html>
