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
	<title> s:if��ǩ </title>
</head>
<body>
<!-- ��Stack Context�ж���һ��age��������ֵΪ29 -->
<s:set name="age" value="5"/>
<!-- ���Stack Context�е�age���Դ���60 -->
<s:if test="#age>60">
    ������
</s:if>
<!-- ���Stack Context�е�age���Դ���35 -->
<s:elseif test="#age>35">
    ������
</s:elseif>
<!-- ���Stack Context�е�age���Դ���15 -->
<s:elseif test="#age>15">
	������
</s:elseif>
<s:else>
    ����
</s:else>
</body>
</html>