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
	<title> ʹ��subset��ȡ�Ӽ��� </title>
</head>
<body>
<table border="1" width="300">
<!-- ʹ��subset��ǩ��ȡĿ�꼯�ϵ�4��Ԫ�أ��ӵ�2��Ԫ�ؿ�ʼ��ȡ -->
<s:subset source="{'���Java����','���Android����',
	'������Java EE��ҵӦ��ʵս','���Ajax����',
	'���XML����'}" 
	start="1" count="3">
	<!-- ʹ��iterator��ǩ������Ŀ�꼯�ϣ���Ϊû��ָ��value����ֵ��
		�ʵ���ValueStackջ���ļ��� -->
	<s:iterator status="st">
		<!-- ���ݵ�ǰ����Ԫ�ص������Ƿ�Ϊ���������Ƿ�ʹ��CSS��ʽ -->
		<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
			<td><s:property/></td>
		</tr>
	</s:iterator>
</s:subset>
</table>
</body>
</html>