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
<!-- ����һ��Decider Bean -->
<s:bean var="mydecider" name="com.bar3.strustDemo.tags.MyDecider"/>
<!-- ʹ���Զ����Deciderʵ������ȡĿ�꼯�ϣ������Ӽ�
	ָ��var���ԣ������ɵ�Itertor����Stack Context�У�deciderʵ������ʵ��SubsetIteratorFilter.Decider�ӿ�-->
<s:subset source="{'���Java����','���Android����',
	'������Java EE��ҵӦ��ʵս','���Ajax����',
	'���XML����'}" 
	decider="#mydecider"
	var="newList"/>
ֱ�����page��Χ��newList���ԣ�<br/>
${pageScope.newList}
<table border="1" width="300">
<!-- ����page��Χ�ڵ�newList���� -->
<s:iterator status="st" value="#attr.newList">	
	<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<td><s:property/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>