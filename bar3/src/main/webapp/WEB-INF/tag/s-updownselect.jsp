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
	<title> ʹ��s:updownselect���ɿ������ƶ�ѡ�������ѡ��� </title>
</head>
<body>
<s:form>
<!-- ʹ�ü򵥼��������ɿ������ƶ�ѡ�������ѡ��� -->
<s:updownselect name="a" label="��ѡ����ϲ����ͼ��" labelposition="top"
	moveUpLabel="�����ƶ�"
	list="{'���Java����' , '������Java EE��ҵӦ��ʵս',
	'���Ajax����'}"/>
<!-- ʹ��Map���������ɿ������ƶ�ѡ�������ѡ��� 
	 ��ʹ��emptyOption="true"����һ����ѡ��-->
<s:updownselect name="b" label="��ѡ������ѡ���������" labelposition="top"
	moveDownLabel="�����ƶ�" list="#{'���Java����':'2008��10��',
	'������Java EE��ҵӦ��ʵս':'2011��3��',
	'���Ajax����':'2007��6��'}"
	listKey="key"
	emptyOption="true"
	listValue="value"/>
<s:bean name="org.crazyit.struts2.service.BookService" id="bs"/>
<!-- ʹ�ü�����Ŷ��JavaBeanʵ�����������ƶ�ѡ�������ѡ��� -->
<s:updownselect name="c" label="��ѡ����ϲ����ͼ�������" labelposition="top"
	selectAllLabel="ȫ��ѡ��" multiple="true"
	list="#bs.books"
	listKey="author"
	listValue="name"/>
</s:form>
</body>
</html>