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
	<title> ʹ��s:select��������ѡ��� </title>
</head>
<body>
<s:form>
<!-- ʹ�ü򵥼�������������ѡ���,multiple��ʾ�Ƿ������ѡ -->
<s:select name="a" label="��ѡ����ϲ����ͼ��" 
	multiple="true" labelposition="top" list="{'���Java����' , 
	'������Java EE��ҵӦ��ʵս' , '���Android����'}"/>
<!-- ʹ�ü�Map��������������ѡ���
	ʹ��Map�����key����������Ϊѡ���value��
	ʹ��Map�����value������ʱ�䣩��Ϊѡ��ı�ǩ-->
<s:select name="b" label="��ѡ������ѡ���������" 
	labelposition="top" list="#{'���Java����':'2008��10��',
	'������Java EE��ҵӦ��ʵս':'2011��3��',
	'���Ajax����':'2007��6��'}"
	listKey="key"
	listValue="value"/>
<!-- ����һ��JavaBean���󣬲��������Stack Context�� -->
<s:bean name="com.bar3.strustDemo.tags.BookService" var="bs"/>
<!-- ʹ�ü�����Ŷ��JavaBeanʵ������������ѡ���
	ʹ�ü���Ԫ����name������Ϊѡ��ı�ǩ
	ʹ�ü���Ԫ����author������Ϊѡ���value-->
<s:select name="c" label="��ѡ����ϲ����ͼ��" 
	multiple="true" labelposition="top"
	list="#bs.books"
	listKey="author"
	listValue="name"/>
</s:form>
</body>
</html>