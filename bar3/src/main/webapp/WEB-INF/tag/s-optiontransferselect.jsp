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
	<title> ʹ��s:optiontransferselect���ɿ��ƶ��б���������б�� </title>
</head>
<body>
<s:form>
<!-- ʹ�ü򵥼��϶��������ɿ��ƶ��������б�� -->
 <s:optiontransferselect 
  	label="��ѡ����ϲ����ͼ��"
	name="cnbook" 
	leftTitle="����ͼ�飺"
	rightTitle="����ͼ��"
	list="{'���Java����' ,'���Android����',
		'������Java EE��ҵӦ��ʵս','���Ajax����'}" 
	multiple="true"
	addToLeftLabel="�����ƶ�"
	selectAllLabel="ȫ��ѡ��"
	addAllToRightLabel="ȫ������"
	headerKey="cnKey"
	headerValue="--- ѡ������ͼ�� ---"
	emptyOption="true"
	doubleList="{'Expert One-on-One J2EE Design and Development',
		'JavaScript: The Definitive Guide'}" 
	doubleName="enBook"
	doubleHeaderKey="enKey"
	doubleHeaderValue="--- ѡ������ͼ�� ---" 
	doubleEmptyOption="true"
	doubleMultiple="true"
/>
</s:form>
</body>
</html>