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
	<title> s:iterator��ǩ���� </title>
</head>
<body>
<table>
<tr>
<td>��ǰֵ</td><td>getCount</td><td>getIndex</td><td>isEven</td><td>isFirst</td><td>isLast</td><td>isOdd</td>
</tr>
<s:iterator value="{'���Java����','������Java EE��ҵӦ��ʵս',
	'���Ajax����' , '���Android����'}" status="st">
	<tr>
	<td><s:property/></td>
	<td><s:property value="#st.count"/></td>
	<td><s:property value="#st.index"/></td>
	<td><s:property value="#st.even"/></td>
	<td><s:property value="#st.odd"/></td>
	<td><s:property value="#st.first"/></td>
	<td><s:property value="#st.last"/></td>
	</tr>
</s:iterator>
</table>
<table border="1" width="300">
<!-- �������List���� -->
<s:iterator value="{'���Java����','������Java EE��ҵӦ��ʵս',
	'���Ajax����' , '���Android����'}" status="st">
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>

</table>
<table border="1" width="350">
	<tr>
		<th>����</th>
		<th>����</th>
	</tr>
<!-- ��ָ����Map������е������,��ָ��status���� -->
<s:iterator value="#{'���Java����':'���',
	'������Java EE��ҵӦ��ʵս':'���' ,
	'���Ajax����':'���'}" status="st">
	<!-- ���ݵ�ǰ������Ԫ�ص������Ƿ�Ϊ�����������Ƿ�ʹ�ñ���ɫ -->
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<!-- ���Map������Entry��key -->
		<td><s:property value="key"/></td>
		<!-- ���Map������Entry��value -->
		<td><s:property value="value"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>