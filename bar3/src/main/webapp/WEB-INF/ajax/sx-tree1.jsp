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
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>ʹ��sx:tree��sx:treenode��ǩ���ɾ�̬��</title>
	<sx:head/>
</head>
<body>
<h3>ʹ��sx:tree��sx:treenode��ǩ���ɾ�̬��</h3>
<!-- 
expandIconSrcMinus:ָ����ʾ���ڵ㴦��չ��״̬��ͼ���ַ
expandIconSrcPlus��ָ����ʾ���ڵ㴦������״̬��ͼ���ַ��
Ϊ��ʵ�ֶ�̬�������ڵ㣬����Ϊsx:tree��ǩָ��href���ԣ������Ը���Ϊָ���ڵ�����ӽڵ㣬ÿ���������ͼչ��ĳ��
�ڵ�ʱϵͳ����hrefָ����url�����첽���󣬸��������һ�����������nodeId���ò�����ֵ���Ǹýڵ��Id����ֵ��
 -->
<!-- ʹ��sx:tree������ -->
<sx:tree label="�����ͼ��" 
	id="book"
	showRootGrid="true" 
	showGrid="true" >
	<!-- ÿ��sx:treenode����һ�����ڵ� -->
	<sx:treenode label="���" id="yeeku">
		<!-- ʹ��sx:treenode������һ�����ӽڵ� -->
		<sx:treenode label="���Java����" id="java"/>
		<sx:treenode label="������Java EE��ҵӦ��ʵս" id="jee"/>
		<sx:treenode label="���Ajax����" id="ajax"/>
	</sx:treenode>
	<sx:treenode label="David" id="David">
		<sx:treenode label="JavaScript: The Definitive Guide"
			id="javascript"/>
	</sx:treenode>
	<sx:treenode label="Johnson" id="Johnson">
		<sx:treenode id="j2ee"
			label="Expert One-on-One J2EE Design and Development"/>
	</sx:treenode>
</sx:tree>
</body>
</html>