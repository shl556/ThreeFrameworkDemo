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
<!-- ʹ��s:generator��ǩ��һ���ַ��������ɼ���,���Ը�converter����ָ��һ��ʵ����Converter�ӿڵĶ��󣬴Ӷ����ַ���ת������������-->
<table border="1" width="240">
<!-- ʹ��generator��ǩ��ָ���ַ���������List����
	��generator��ǩ�ڣ��õ���List����λ��ValueStack���� -->
<s:generator val="'���Java����,������Java EE��ҵӦ��ʵս,
	���Ajax����'" separator=",">
<!-- û��ָ�������ĸ����ϣ�ֱ�ӵ���ValueStack���˵ļ��� -->
<s:iterator status="st">
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>
</s:generator>
</table>
</body>
</html>